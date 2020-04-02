package com.example.foodcare

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.FileProvider
import java.io.File
import java.net.URI

class CaptureImage : AppCompatActivity() {

//    private lateinit var btn_capture: Button
//    private lateinit var imgview: ImageView
//    private val CAMERA_REQUEST_CODE = 1
//
////    private lateinit var temp:File
////    val newFile = File(temp,"default_image.jpg")
////    private lateinit var selectedphotopath:Uri
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_capture_image)
//
//        val next_activity = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//
////        selectedphotopath = FileProvider.getUriForFile(this,BuildConfig.APPLICATION_ID +
////        ".fileprovider",newFile)
////
////        next_activity.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,selectedphotopath)
////        next_activity.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
//
//        imgview = findViewById(R.id.imageView)
//        btn_capture = findViewById<Button>(R.id.button)
//        btn_capture.setOnClickListener(){
//            startActivity(next_activity)
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK){
//
////            val photoPath:Uri = selectedphotopath ?: return
////            imgview.setImageURI(photoPath)
//       }
//    }
   }
