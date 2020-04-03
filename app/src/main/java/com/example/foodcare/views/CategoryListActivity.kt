package com.example.foodcare.views

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcare.R
import com.example.foodcare.adapters.SpecificCategoryListAdapter
import com.example.foodcare.models.Category
import com.example.foodcare.models.Vegetable
import kotlinx.android.synthetic.main.categorylist.*

class CategoryListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var backButton: ImageButton
    private lateinit var headTitile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categorylist)
        backButton = findViewById(R.id.backButton)
        headTitile = findViewById(R.id.categoryListView)
        backButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                this@CategoryListActivity.finish()
            }

        })
        var itemDetails = intent.getSerializableExtra("vegetableList") as? Category
//        val categoryName = intent.getStringExtra("categoryName")
        if (itemDetails != null) {
            headTitile.text = itemDetails.name
        }
        recyclerView = categoryListRecycler
        recyclerView.apply {
            layoutManager = GridLayoutManager(
                    this@CategoryListActivity,
                    2,
                    GridLayoutManager.VERTICAL,
                    false
            )
            if (itemDetails != null) {
                adapter =
                        SpecificCategoryListAdapter(
                                itemDetails.children
                        )
            }
        }
    }

    private fun getCategoryList(categoryName: String, count: Int): List<Vegetable> {

        val children = mutableListOf<Vegetable>()
        repeat(count / 2) {
            children.add(
                    Vegetable(
                            "Lobster Cooked in store",
                            "Raw",
                        R.drawable.veggie1,
                            "New Veggie",
                            20,
                            45.20,
                            "300g"
                    )
            )
        }
        repeat(count / 2) {
            children.add(
                    Vegetable(
                            "Seasoned pork rack ribs end",
                            "Raw",
                        R.drawable.veggie2,
                            "New Veggie",
                            10,
                            21.20,
                            "400g"
                    )
            )
        }
        return children

    }
}
