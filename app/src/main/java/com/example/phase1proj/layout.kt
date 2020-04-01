package com.example.phase1proj

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.phase1proj.views.fragment_account
import com.example.phase1proj.views.home
import com.example.phase1proj.views.store
import com.google.android.material.bottomnavigation.BottomNavigationView


class layout : AppCompatActivity() {
    private lateinit var home: home
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)


        setHomeFragment()
        val fragment = getHomeFragment()
        val fragmentTransaction =
            supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment, "Home")
        fragmentTransaction.commit()
        val bottomNav =
            findViewById<BottomNavigationView>(R.id.bottom_navigation)
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
                R.id.navigation_home -> selectedFragment = getHomeFragment()
//                R.id.navigation_cart -> selectedFragment = cart()
                R.id.navigation_stores -> selectedFragment =
                    store()
                R.id.navigation_account -> selectedFragment =
                    fragment_account()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.container,
                selectedFragment!!
            ).addToBackStack(null).commit()
            true
        }


}