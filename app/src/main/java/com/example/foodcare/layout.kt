package com.example.foodcare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodcare.views.home
import com.example.foodcare.models.Vegetable
import com.example.foodcare.views.fragment_account
import com.example.foodcare.views.store
import com.example.myapp.MapFragment
import com.example.myapp.SellFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

class layout : AppCompatActivity() {
    private lateinit var home: home
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        FirebaseApp.initializeApp(this);

        setHomeFragment()
        val fragment = getHomeFragment()
        val fragmentTransaction =
                supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment, "Home")
        fragmentTransaction.commit()
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)
        supportFragmentManager.beginTransaction().replace(
                R.id.container,
                home()
        ).commit()
    }

    fun setHomeFragment() {
        this.home = home()
    }

    fun getHomeFragment(): home {
        return this.home
    }


    private val navListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                var selectedFragment: Fragment? = null
                when (item.itemId) {
                    R.id.bottomNavigationBuyId -> selectedFragment = getHomeFragment()
//                R.id.navigation_cart -> selectedFragment = cart()
                    R.id.bottomNavigationSellId -> selectedFragment =
                            SellFragment()
                    R.id.bottomNavigationMapId -> selectedFragment =
                            MapFragment()
                    R.id.bottomNavigationProfileId -> selectedFragment =
                        Profile()
                }
                supportFragmentManager.beginTransaction().replace(
                        R.id.container,
                        selectedFragment!!
                ).addToBackStack(null).commit()
                true
            }


}

