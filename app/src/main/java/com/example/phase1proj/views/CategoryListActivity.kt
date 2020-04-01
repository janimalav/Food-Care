package com.example.phase1proj.views

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phase1proj.R
import com.example.phase1proj.adapters.SpecificCategoryListAdapter
import com.example.phase1proj.models.Vegetable
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
        val categoryName = intent.getStringExtra("categoryName")
        headTitile.text = categoryName
        recyclerView = categoryListRecycler
        recyclerView.apply {
            layoutManager = GridLayoutManager(
                    this@CategoryListActivity,
                    2,
                    GridLayoutManager.VERTICAL,
                    false
            )
            adapter =
                    SpecificCategoryListAdapter(
                            getCategoryList(categoryName, 40)
                    )
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
