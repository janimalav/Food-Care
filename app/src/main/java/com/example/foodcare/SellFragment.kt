package com.example.myapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.foodcare.FoodItem
import com.example.foodcare.FoodItemViewModel
import com.example.foodcare.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.fragment_sell.*
import java.io.ByteArrayOutputStream
import java.util.*
import androidx.lifecycle.ViewModelProvider as ViewModelProvider1

class SellFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var mStorageRef: StorageReference

    private var locationManager : LocationManager? = null
    private var longitude: Double = 0.0
    private var latitude: Double = 0.0

    private lateinit var viewmModel: FoodItemViewModel
    private var CAMERA_REQUEST = 1888
    private lateinit var imgview: ImageView

    val fooditem = FoodItem()

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser

        if(currentUser != null){
            view?.findViewById<ConstraintLayout>(R.id.fragmentSell_view1)?.visibility = View.VISIBLE
        }else{
            view?.findViewById<ConstraintLayout>(R.id.fragmentSell_view2)?.visibility = View.VISIBLE

            Glide.with(requireContext()).load(R.drawable.logo_gif).into(landing_back_sell)

            view?.findViewById<Button>(R.id.button2)?.setOnClickListener {
                activity?.finish()
            }
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View? {

        auth = FirebaseAuth.getInstance()
        mStorageRef = FirebaseStorage.getInstance().reference

        locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        try {
            locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L,
                0f, locationListener)
        }catch (e: Exception){
            Log.d("Sell Fragment", "Exception in location manager initialize")
        }

        viewmModel = ViewModelProvider1(this).get(FoodItemViewModel::class.java)
        val view: View = inflater.inflate(R.layout.fragment_sell, container, false)

        imgview = view.findViewById(R.id.item_img)
        imgview.setOnClickListener{
            val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_REQUEST)
        }


        val CATEGORIES = arrayOf("Meat & Poultry", "Fish & Seafood", "Dairy & Cheese",
            "Fruits & Veggies","Bakery","Grocery","Frozen","Drinks","Organic","Other")
        val drop_item = view.findViewById<AutoCompleteTextView>(R.id.filled_exposed_dropdown)
        drop_item.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.dropdown_item,
                CATEGORIES
            )
        )

        val post = view.findViewById<Button>(R.id.post)
        post.setOnClickListener {
            val name = item_name.text.toString().trim()
            if (name.isEmpty()) {
                item_name.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val desc = item_desc.text.toString().trim()
            if (desc.isEmpty()) {
                item_desc.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val price = item_price.text.toString().trim()
            if (price.isEmpty()) {
                item_price.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val units = item_weight.text.toString().trim()
            if (units.isEmpty()) {
                item_weight.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val address = item_address.text.toString().trim()
            if (desc.isEmpty()) {
                item_address.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val category= filled_exposed_dropdown.text.toString().trim()

            fooditem.name = name
            fooditem.description = desc
            fooditem.price = price
            fooditem.address = address
            fooditem.category = category
            fooditem.units = units
            fooditem.longitude = longitude
            fooditem.latitude = latitude
            // get username with the following line
            fooditem.userName = auth.currentUser?.displayName
            uploadImageToFirebaseStorage()
        }

        return view
    }

    var photo: Bitmap? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) if (requestCode == CAMERA_REQUEST && data != null) {
            photo = data.extras?.get("data") as Bitmap
            imgview.setImageBitmap(photo)
        }
    }

    @SuppressLint("StringFormatInvalid")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmModel.result.observe(viewLifecycleOwner, Observer {
            val message = if (it == null) {
                getString(R.string.added)
            } else {
                getString(R.string.errormsg, it.message)
            }
        })
    }

    private fun uploadImageToFirebaseStorage() {
        if (photo == null){
            Toast.makeText(context,"Please upload the picture of food item.", Toast.LENGTH_SHORT).show()
            return
        }

        view?.findViewById<ConstraintLayout>(R.id.fragmentSell_view1)?.visibility = View.GONE
        view?.findViewById<ConstraintLayout>(R.id.fragmentSell_view3)?.visibility = View.VISIBLE

        val bytes: ByteArrayOutputStream = ByteArrayOutputStream()
        photo!!.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path: String = MediaStore.Images.Media.insertImage(
            requireContext().contentResolver, photo,
            "Title", null
        )

        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().reference.child("/images/$filename")

        ref.putFile(Uri.parse(path))
            .addOnSuccessListener {
                Log.i("Upload Image", "Successfully uploaded the image : $it")

                ref.downloadUrl.addOnSuccessListener {
                    fooditem.imgurl = it.toString()
                    viewmModel.addFoodItem(fooditem)

                    view?.findViewById<ConstraintLayout>(R.id.fragmentSell_view3)?.visibility = View.GONE
                    view?.findViewById<ConstraintLayout>(R.id.fragmentSell_view4)?.visibility = View.VISIBLE

                    view?.findViewById<Button>(R.id.button3)?.setOnClickListener {
                        val fragmentTransaction = fragmentManager?.beginTransaction()
                        fragmentTransaction?.replace(R.id.nav_container,SellFragment())
                        fragmentTransaction?.commit()
                    }
                }
            }
    }

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            longitude = location.longitude
            latitude = location.latitude
        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
}