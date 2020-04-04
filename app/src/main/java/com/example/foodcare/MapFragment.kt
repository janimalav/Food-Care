package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foodcare.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.FirebaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MapFragment : Fragment(),OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootview= inflater.inflate(R.layout.fragment_map, container, false)
        val mapFragment = this.childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        return rootview
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        //this is sample data

        val latitude = 44.637456
        val longitude =-63.590225
        val zoomLevel = 12f
        val overlaySize = 100f

        var homeLatLng = LatLng(latitude, longitude)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
        map.addMarker(MarkerOptions().position(homeLatLng))

        // here is all the location data from the user inserted in database
        // all the location will be stored to database when user puts the product to sell
        var database = FirebaseDatabase.getInstance()
        var ref = database.getReference("fooditems")

        ref.addListenerForSingleValueEvent(object : ValueEventListener{


            override fun onCancelled(p0: DatabaseError) {}

            override fun onDataChange(p0: DataSnapshot) {
                val children = p0!!.children
                children.forEach {
                    val latitude = it.child("latitude").getValue().toString()
                    val longitude = it.child("longitude").getValue().toString()

                    homeLatLng = LatLng(latitude.toDouble(),longitude.toDouble())
                    map.addMarker(MarkerOptions().position(homeLatLng).title(it.child("userName").getValue().toString()))
                }
            }
        })
    }
}
