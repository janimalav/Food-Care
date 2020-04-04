package com.example.foodcare

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.ktx.Firebase
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_page.*

class profile_page : AppCompatActivity() {

    private val validation = Validation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val user = FirebaseAuth.getInstance().currentUser

        findViewById<ImageView>(R.id.imageView5).setOnClickListener {
            finish()
        }
        val edtName: EditText = findViewById(R.id.et_name)
        val edtEmail: EditText = findViewById(R.id.et_email)
        val resend: Button = findViewById(R.id.resend)

        edtName.setText(user?.displayName)
        edtEmail.setText(user?.email)

        findViewById<Button>(R.id.reset).setOnClickListener {
            if(validation.checkName(edtName) && validation.checkEmail(edtEmail)){

                val profileUpdates = UserProfileChangeRequest.Builder()
                    .setDisplayName(edtName.text.toString()).build()
                user?.updateProfile(profileUpdates)

                user?.updateEmail(edtEmail.text.toString())

                Toast.makeText(baseContext,"Profile Updated", Toast.LENGTH_SHORT).show()

                FirebaseAuth.getInstance().signOut()

                val nextActivity = Intent(applicationContext, LandingActivity::class.java)
                startActivity(nextActivity)
                finish()
            }
        }

        resend.setOnClickListener {
            val email = user?.email

            if(email != null) {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)

                FirebaseAuth.getInstance().signOut()

                val nextActivity = Intent(applicationContext, LandingActivity::class.java)
                startActivity(nextActivity)
                finish()
            }
        }
    }
}
