package com.example.foodcare

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment


class help : DialogFragment() {

    companion object {
        fun newInstance() = help()
    }

    private lateinit var viewModel: HelpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.help_fragment, container, false)

        var closeButton = v.findViewById<ImageButton>(R.id.help_closebutton)

        closeButton.setOnClickListener { v -> dismiss() }
        return v
    }


}
