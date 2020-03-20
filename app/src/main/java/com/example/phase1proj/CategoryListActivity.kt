package com.example.phase1proj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.categorylist.*
import kotlinx.android.synthetic.main.layout.*

class CategoryListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categorylist)
        val categoryName = intent.getStringExtra("categoryName")
        recyclerView = categoryListRecycler
        recyclerView.apply {
            layoutManager= GridLayoutManager(this@CategoryListActivity,2,GridLayoutManager.VERTICAL,false) as RecyclerView.LayoutManager?
            adapter = SpecificCategoryListAdapter(getCategoryList(categoryName,40))
        }
    }
    private fun getCategoryList(categoryName:String,count:Int):List<Vegetable>{

        val children = mutableListOf<Vegetable>()
        repeat(count/2) {
            children.add(Vegetable("Lobster Cooked in store", "Raw", R.drawable.veggie1, "New Veggie"))
        }
        repeat(count/2) {
            children.add(Vegetable("Seasoned pork rack ribs end", "Raw", R.drawable.veggie2, "New Veggie"))
        }
        return children

    }
}
