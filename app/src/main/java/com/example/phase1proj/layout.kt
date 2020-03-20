package com.example.phase1proj



import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout.*


class layout : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var logorecycler: RecyclerView
    private lateinit var linearLayout: LinearLayout

    lateinit var toolbar: ActionBar


    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.layout)

        logorecycler= recyclerCategory

        logorecycler.apply {
            layoutManager = GridLayoutManager(this@layout,1,
                GridLayoutManager.HORIZONTAL,false)
            adapter = CategoryLogoViewAdapter(getLogos(40))
        }

        recyclerView = recyclerParent
        recyclerView.apply {
            layoutManager= LinearLayoutManager(this@layout,RecyclerView.VERTICAL,false) as RecyclerView.LayoutManager?

            adapter = ParentRecyclerViewAdapter(getParents(4))


//            layoutParams= ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,40)

        }


//        toolbar = supportActionBar!!
//        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

    }
    private fun getLogos(count:Int):List<CategoryLogo>{
        val categories = mutableListOf<CategoryLogo>()
        repeat(count/2) {
            val logo = CategoryLogo("Veggies", R.drawable.veggie1,"")
            categories.add(logo)
        }
        repeat(count/2) {
            val logo = CategoryLogo("Arjun", R.drawable.veggie2,"")
            categories.add(logo)
        }
        return categories
    }


    private fun getParents(count:Int):List<Category>{
        val parents = mutableListOf<Category>()
        repeat(count/2) {
            val parent = Category("Veggies", getChildren(20))
            parents.add(parent)
        }
        repeat(count/2) {
            val parent = Category("Arjun", getChildren(20))
            parents.add(parent)
        }
        return parents
    }


    private fun getChildren(count:Int):List<Vegetable>{
        val children = mutableListOf<Vegetable>()
        repeat(count/2) {
            children.add(Vegetable("Lobster Cooked in store", "Raw", R.drawable.veggie1, "New Veggie"))
        }
        repeat(count/2) {
            children.add(Vegetable("Seasoned pork rack ribs end", "Raw", R.drawable.veggie2, "New Veggie"))
        }
        return children
    }
    fun onClickStore(v: View?) {

        val tv = findViewById(R.id.textView) as TextView


        //alter text of textview widget
        tv.text = "This text view is clicked"
        //assign the textview forecolor
        tv.setTextColor(Color.BLUE)
    }

}