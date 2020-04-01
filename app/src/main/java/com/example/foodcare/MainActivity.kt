package com.example.foodcare

import android.content.Intent
import android.content.SharedPreferences
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var PRIVATE_MODE = 0
    private val SHARED_PREF = "Asmita"
    /*lateinit var cardProfile: ConstraintLayout
    lateinit var cardHelp: ConstraintLayout
    lateinit var cardContact: ConstraintLayout
    lateinit var cardSignout: ConstraintLayout*/
    override fun onCreate(savedInstanceState: Bundle?) {
        val shared: SharedPreferences = getSharedPreferences(SHARED_PREF, PRIVATE_MODE)
        var editor = shared.edit()
        editor.putString("username", "Asmita")
        editor.commit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cl_edit_profile.setOnClickListener {
            var intent = Intent(this, profile_page::class.java)
            startActivity(intent)
        }

        cl_help.setOnClickListener {
            help().show(supportFragmentManager, "Help")
        }

        cl_contact_us.setOnClickListener {
            contact_us().show(supportFragmentManager, "Contact Us")
        }

        cl_signout.setOnClickListener {
            System.exit(0)
        }

    }
}