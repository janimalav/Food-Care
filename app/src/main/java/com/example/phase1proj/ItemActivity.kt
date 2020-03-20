package com.example.phase1proj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item)
        val itemName = intent.getStringExtra("itemName")

    }
}
