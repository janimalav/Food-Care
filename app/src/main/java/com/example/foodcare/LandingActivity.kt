package com.example.foodcare

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : AppCompatActivity(), MultiplePermissionsListener {

    private lateinit var auth: FirebaseAuth
    private val validation = Validation()

    val permissions = listOf(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    public override fun onStart() {

        super.onStart()
        Glide.with(baseContext).load(R.drawable.logo_gif).into(landing_back)

        Dexter.withActivity(this).withPermissions(permissions).withListener(this)
            .check()

        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            val nextActivity = Intent(applicationContext, layout::class.java)
            startActivity(nextActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        auth = FirebaseAuth.getInstance()

        val email = findViewById<TextInputEditText>(R.id.landing_email)
        val password = findViewById<TextInputEditText>(R.id.landing_password)

        val loginButton = findViewById<Button>(R.id.landing_login)
        loginButton.setOnClickListener {

            Dexter.withActivity(this).withPermissions(permissions).withListener(this)
                .check()

            if(validation.checkEmail(email) && validation.checkPassword(password)){
                auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {
                            val nextActivity = Intent(applicationContext, layout::class.java)
                            startActivity(nextActivity)
                        } else {
                            if (task.exception is FirebaseNetworkException) {
                                Toast.makeText(
                                    applicationContext, "Server not reachable", Toast.LENGTH_LONG
                                ).show()
                            } else if (task.exception is FirebaseAuthInvalidUserException) {
                                email.error = "No account found"
                                email.requestFocus()
                            } else if (task.exception is FirebaseAuthInvalidCredentialsException) {
                                password.setError("Wrong password")
                                password.requestFocus()
                            }else{
                                Toast.makeText(
                                    applicationContext, "Try later", Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
            }
        }

        val signup = findViewById<TextView>(R.id.landing_register)
        signup.setOnClickListener {
            val nextActivity = Intent(applicationContext, SignupActivity::class.java)
            startActivity(nextActivity)
        }

        val explore = findViewById<TextView>(R.id.landing_explore)
        explore.setOnClickListener {
            val nextActivity = Intent(applicationContext, layout::class.java)
            startActivity(nextActivity)
        }
    }

    override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>, token: PermissionToken) {
        token.continuePermissionRequest()
    }

    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
    }
}
