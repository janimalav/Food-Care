package com.example.foodcare

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_page.*

class profile_page : AppCompatActivity() {
    private var PRIVATE_MODE = 0
    private val SHARED_PREF = "Asmita"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        FirebaseApp.initializeApp(
            this
        )

        //isenablefalse()

        FirebaseApp.initializeApp(this);
        val db = Firebase.firestore
        val shared: SharedPreferences = getSharedPreferences(SHARED_PREF, PRIVATE_MODE)
        val user: String? = shared.getString("username", "user")


        reset.setOnClickListener {
            val result = hashMapOf(
                "Name" to et_name.text.toString(),
                "Email" to et_email.text.toString(),
                "Password" to et_password.text.toString(),
                "Address" to et_address.text.toString()
            )

            val docRef = (db.collection("profile")).document("Malav").set(result)
                .addOnSuccessListener { void ->
                    Toast.makeText(
                        applicationContext,
                        "Upadated Sucessfully",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(
                        applicationContext,
                        "Failed",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }

        //Toast.makeText(applicationContext, "$user", Toast.LENGTH_LONG).show()
        if (!user.equals("guest")) {
            val docRef = db.collection("profile").document("Malav").get()
                .addOnSuccessListener { DocumentSnapshot ->
                    et_name.setText(DocumentSnapshot.get("Name").toString())
                    et_email.setText(DocumentSnapshot.get("Email").toString())
                    et_password.setText(DocumentSnapshot.get("Password").toString())
                    et_address.setText(DocumentSnapshot.get("Address").toString())
                    }

                .addOnFailureListener { exception ->
                    Toast.makeText(applicationContext, "get failed with ", Toast.LENGTH_LONG).show()
                    // Log.d(TAG, "get failed with ", exception)
                }
            isenabletrue()
        } else {
            et_name.setText("user")
            et_email.setText("no email")
            et_password.setText("no pass")
            et_address.setText("no home")

            isenablefalse()
        }


    }

    private fun isenablefalse() {
        et_name.isEnabled = false
        et_email.isEnabled = false
        et_password.isEnabled = false
        et_address.isEnabled = false
        reset.isEnabled = false
    }

    private fun isenabletrue() {
        /* iv_edit_profile_back.setOnClickListener {
             et_name.isEnabled = true
         }
         iv_email_edit.setOnClickListener {
             et_email.isEnabled = true
         }
         iv_password_edit.setOnClickListener {
             et_password.isEnabled = true
         }
         iv_address_edit.setOnClickListener {
             et_address.isEnabled = true
         }*/
        reset.isEnabled = true
    }
}


