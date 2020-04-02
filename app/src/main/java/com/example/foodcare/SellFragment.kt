package com.example.myapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.foodcare.FoodItem
import com.example.foodcare.FoodItemViewModel
import com.example.foodcare.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_capture_image.*
import kotlinx.android.synthetic.main.fragment_sell.*
import java.io.ByteArrayOutputStream
import java.util.*
import androidx.lifecycle.ViewModelProvider as ViewModelProvider1

class SellFragment : Fragment() {

    private lateinit var viewmModel: FoodItemViewModel
    private val CAMERA_REQUEST = 1
    private lateinit var imgview: ImageView
    private lateinit var mStorageRef: StorageReference

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmModel = ViewModelProvider1(this).get(FoodItemViewModel::class.java)
        val view: View = inflater.inflate(R.layout.fragment_sell, container, false)

        //val btn = view.findViewById<FloatingActionButton>(R.id.btn_capture)
        imgview = view.findViewById(R.id.item_img)
        mStorageRef = FirebaseStorage.getInstance().getReference()

        imgview.setOnClickListener{
            val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_REQUEST)
        }

//        btn.setOnClickListener {
//            val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(intent, CAMERA_REQUEST)
//
//        }

        var CATEGORIES = arrayOf("Meat & Poultry", "Fish & Seafood", "Dairy & Cheese", "Fruits & Veggies","Bakery","Grocery","Frozen","Drinks","Organic","Other")
        //val adapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,COUNTRIES)
        //val adapter = ArrayAdapter
        var drop_item = view.findViewById<AutoCompleteTextView>(R.id.filled_exposed_dropdown)
        drop_item.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.dropdown_item,
                CATEGORIES
            )
        )

        val post = view.findViewById<Button>(R.id.post)

        post.setOnClickListener {
            Log.d("Sell Pressed","Button pressed")
            Toast.makeText(requireContext(), "Button pressed", Toast.LENGTH_SHORT).show()
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
            if (desc.isEmpty()) {
                item_price.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val address = item_address.text.toString().trim()
            if (desc.isEmpty()) {
                item_address.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val category= filled_exposed_dropdown.text.toString().trim()
            Toast.makeText(requireContext(),category,Toast.LENGTH_LONG).show()
            Log.d("Sell",category)
            val fooditem = FoodItem()
            fooditem.name = name
            fooditem.description = desc
            fooditem.price = price
            fooditem.address = address
            fooditem.category=category
            fooditem.imgurl = uploadImageToFirebaseStorage()
            viewmModel.addFoodItem(fooditem)
        }

        return view
    }

    var itemImgUri: Uri? = null
    var photo: Bitmap? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) if (requestCode == CAMERA_REQUEST && data != null) {
            photo = data.extras?.get("data") as Bitmap
            imgview.setImageBitmap(photo)

//                var img1= MediaStore.Images.Media.insertImage(context?.contentResolver,photo,"Image",null)
//                itemImgUri = Uri.parse(img1)
//                Log.d("Fragment",Uri.parse(img1).toString())
//                //Toast.makeText(requireContext(),data.getStringExtra("data").toString(),Toast.LENGTH_SHORT).show()
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
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun uploadImageToFirebaseStorage(): String {
//        //Log.d("Upload Image","Function Start")
//        // Toast.makeText(requireContext(),itemImgUri.toString(),Toast.LENGTH_SHORT).show()
        if (photo == null) return ""
//
        var bytes: ByteArrayOutputStream = ByteArrayOutputStream()
        photo!!.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        var path: String = MediaStore.Images.Media.insertImage(
            requireContext().contentResolver, photo,
            "Title", null
        )

        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().reference.child("/images/$filename")

        ref.putFile(Uri.parse(path))
            .addOnSuccessListener {
                Log.i("Upload Image", "Sucessfully uploaded the image : ${it.metadata?.path}")
                Toast.makeText(requireContext(), Uri.parse(path).toString(), Toast.LENGTH_SHORT)
                    .show()
            }

        return filename
    }
}

