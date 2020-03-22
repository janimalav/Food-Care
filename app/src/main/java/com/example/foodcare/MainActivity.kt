package com.example.foodcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_edit_profile_back.setOnClickListener{
            var intent = Intent(this, profile_page::class.java)
            startActivity(intent)
        }


    }
}
