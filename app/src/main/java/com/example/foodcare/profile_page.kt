package com.example.foodcare

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseApp
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

        isenablefalse()

        FirebaseApp.initializeApp(this);
        val db = Firebase.firestore
        val shared: SharedPreferences = getSharedPreferences(SHARED_PREF, PRIVATE_MODE)
        val user: String? = shared.getString("username", "user")
        //Toast.makeText(applicationContext, "$user", Toast.LENGTH_LONG).show()
        if (!user.equals("guest")) {
            val docRef = db.collection("profile").get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        et_name.setText(document.data.get("Name").toString())
                        et_email.setText(document.data.get("Email").toString())
                        et_password.setText(document.data.get("Password").toString())
                        et_address.setText(document.data.get("Address").toString())
                    }
                    isenabletrue()
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(applicationContext, "get failed with ", Toast.LENGTH_LONG).show()
                    // Log.d(TAG, "get failed with ", exception)
                }
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
    }

    private fun isenabletrue() {
        iv_edit_profile_back.setOnClickListener {
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
        }
    }
}


