package com.example.foodcare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment


class contact_us : DialogFragment() {

    companion object {
        fun newInstance() = contact_us()
    }

    private lateinit var viewModel: ContactUsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var w = inflater.inflate(R.layout.contact_us_fragment, container, false)

        var closeButton = w.findViewById<ImageButton>(R.id.contactus_closebutton)

        closeButton.setOnClickListener { v -> dismiss() }
        return w
    }

}
