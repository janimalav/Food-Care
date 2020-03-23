package com.example.foodcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LandingActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val validation = Validation()

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            Toast.makeText(baseContext, "Already login.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(baseContext, "Not logged in.", Toast.LENGTH_SHORT).show()
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

            if(validation.checkEmail(email) && validation.checkPassword(password)){
                auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {
                            val nextActivity = Intent(applicationContext, MainActivity::class.java)
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
            val nextActivity = Intent(applicationContext, MainActivity::class.java)
            startActivity(nextActivity)
        }
    }
}
