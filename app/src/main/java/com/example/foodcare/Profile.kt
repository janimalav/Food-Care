package com.example.foodcare

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class Profile : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()

        if(auth.currentUser != null){
            view?.findViewById<ConstraintLayout>(R.id.fragmentProfile_view1)?.visibility = View.VISIBLE
        }else{
            view?.findViewById<ConstraintLayout>(R.id.fragmentProfile_view2)?.visibility = View.VISIBLE

            view?.findViewById<Button>(R.id.button4)?.setOnClickListener {
                activity?.finish()
            }
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        auth = FirebaseAuth.getInstance()

        val v = inflater.inflate(R.layout.fragment_profile, container, false)

        v.findViewById<ConstraintLayout>(R.id.cl_edit_profile).setOnClickListener{
            val intent = Intent(requireContext(),profile_page::class.java)
            startActivity(intent)
        }

        v.findViewById<ConstraintLayout>(R.id.cl_help).setOnClickListener{
            help().show(requireFragmentManager(),"Help")
        }

        v.findViewById<ConstraintLayout>(R.id.cl_contact_us).setOnClickListener{
            contact_us().show(requireFragmentManager(),"Help")
        }

        v.findViewById<ConstraintLayout>(R.id.cl_signout).setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            activity?.finish()
        }

        return v
    }
}
