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
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodcare.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_capture_image.*
import kotlinx.android.synthetic.main.fragment_sell.*
import java.io.ByteArrayOutputStream
import java.util.*

class SellFragment : Fragment() {

   // private lateinit var viewmModel: FoodItemViewModel
    private val CAMERA_REQUEST = 1
    private lateinit var imgview: ImageView
    private lateinit var mStorageRef:StorageReference

    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //viewmModel = ViewModelProvider(this).get(FoodItemViewModel::class.java)
        val view:View =  inflater.inflate(R.layout.fragment_sell, container, false)

        val btn = view.findViewById<FloatingActionButton>(R.id.btn_capture)
        imgview = view.findViewById(R.id.item_img)
//        mStorageRef = FirebaseStorage.getInstance().getReference()

        btn.setOnClickListener{
            val intent:Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,CAMERA_REQUEST)
        }
        return view
    }


    var itemImgUri:Uri? =null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if (requestCode == CAMERA_REQUEST && data!=null){
                val photo = data?.extras?.get("data") as Bitmap
                imgview.setImageBitmap(photo)
                var img1= MediaStore.Images.Media.insertImage(context?.contentResolver,photo,"Image",null)
                itemImgUri = Uri.parse(img1)
                Log.d("Fragment",Uri.parse(img1).toString())
                //Toast.makeText(requireContext(),data.getStringExtra("data").toString(),Toast.LENGTH_SHORT).show()

//                post.setOnClickListener {
//                    val name = item_name.text.toString().trim()
//                    if (name.isEmpty()){
//                        item_name.error=getString(R.string.error_field_required)
//                        return@setOnClickListener
//                    }
//
//                    val desc = item_desc.text.toString().trim()
//                    if(desc.isEmpty()){
//                        item_desc.error = getString(R.string.error_field_required)
//                        return@setOnClickListener
//                    }
//
//                    val price = item_price.text.toString().trim()
//                    if(desc.isEmpty()){
//                        item_price.error = getString(R.string.error_field_required)
//                        return@setOnClickListener
//                    }
//
//                    val address = item_address.text.toString().trim()
//                    if(desc.isEmpty()){
//                        item_address.error = getString(R.string.error_field_required)
//                        return@setOnClickListener
//                    }
//
//                    val fooditem = FoodItem()
//                    fooditem.name = name
//                    fooditem.description = desc
//                    fooditem.price = price
//                    fooditem.address = address
//                    viewmModel.addFoodItem(fooditem)
//
//                    uploadImageToFirebaseStorage()
//                }

            }
        }
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewmModel.result.observe(viewLifecycleOwner, Observer {
//            val message = if(it==null){
//                    getString(R.string.added)
//            }else{
//                    getString(R.string.errormsg,it.message)
//            }
//           // Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
//        })
//    }

//    private fun uploadImageToFirebaseStorage() {
//        //Log.d("Upload Image","Function Start")
//       // Toast.makeText(requireContext(),itemImgUri.toString(),Toast.LENGTH_SHORT).show()
//        if (itemImgUri == null ) return
//
//        val filename = UUID.randomUUID().toString()
//        val ref = FirebaseStorage.getInstance().getReference().child("/images/$filename")
//        //mStorageRef = FirebaseStorage.getInstance().getReference("/images/$filename")
//        //Toast.makeText(requireContext(),itemImgUri.toString(),Toast.LENGTH_SHORT).show()
//        ref.putFile(itemImgUri!!)
//            .addOnSuccessListener {
//                Log.i("Upload Image","Sucessfully uploaded the image : ${it.metadata?.path}")
//                Toast.makeText(requireContext(),itemImgUri.toString(),Toast.LENGTH_SHORT).show()
//            }
//    }
}

