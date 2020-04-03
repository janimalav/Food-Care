package com.example.foodcare

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val validation = Validation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        Glide.with(baseContext).load(R.drawable.logo_gif).into(sigup_img)

        auth = FirebaseAuth.getInstance()

        findViewById<ImageView>(R.id.imageView4).setOnClickListener {
            finish()
        }

        val name = findViewById<TextInputEditText>(R.id.signup_name)
        val email = findViewById<TextInputEditText>(R.id.signup_email)
        val password = findViewById<TextInputEditText>(R.id.signup_password)
        val rePassword = findViewById<TextInputEditText>(R.id.signup_repassword)

        val signupButton = findViewById<Button>(R.id.signup_signup)
        signupButton.setOnClickListener {

            if(validation.checkName(name) && validation.checkEmail(email) && validation.checkPassword
                    (password) && validation.checkConfirmPassword(password, rePassword)){
                auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {

                            val profileUpdates = UserProfileChangeRequest.Builder()
                                    .setDisplayName(name.text.toString()).build()

                            auth.currentUser?.updateProfile(profileUpdates)

                            finish()
                        } else {
                            if (task.exception is FirebaseAuthUserCollisionException) {
                                email.error = "Email already in use"
                                email.requestFocus()
                            } else {
                                Toast.makeText(applicationContext, "Something went Wrong" +
                                            "..Try Again!", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }
        }
    }
}
