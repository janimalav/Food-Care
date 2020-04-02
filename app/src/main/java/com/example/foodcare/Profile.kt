package com.example.foodcare

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_profile, container, false)

        v.findViewById<ConstraintLayout>(R.id.cl_edit_profile).setOnClickListener{

        var intent=Intent(requireContext(),profile_page::class.java)
            startActivity(intent)
        }
        v.findViewById<ConstraintLayout>(R.id.cl_help).setOnClickListener{
            help().show(requireFragmentManager(),"Help")
        }
        v.findViewById<ConstraintLayout>(R.id.cl_contact_us).setOnClickListener{
            contact_us().show(requireFragmentManager(),"Help")
        }
        v.findViewById<ConstraintLayout>(R.id.cl_signout).setOnClickListener{
            System.exit(0)
        }

//     cl_edit_profile.setOnClickListener {
//            var intent = Intent(this, profile_page::class.java)
//            startActivity(intent)
//        }
//        cl_help.setOnClickListener {
//            help().show(supportFragmentManager, "Help")
//        }
//        cl_contact_us.setOnClickListener {
//            contact_us().show(supportFragmentManager, "Contact Us")
//        }
//        cl_signout.setOnClickListener {
//            System.exit(0)
//        }

        return v
        // Inflate the layout for this fragment

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
