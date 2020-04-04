package com.example.foodcare.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcare.R
import com.example.foodcare.models.Category
import com.example.foodcare.views.CategoryListActivity
import kotlinx.android.synthetic.main.parent_view_list.view.*

class ParentRecyclerViewAdapter(
        private val parentList: List<Category>
) :
        RecyclerView.Adapter<ParentRecyclerViewAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        val layoutInflater = LayoutInflater.from(parent.context)
        view = layoutInflater.inflate(R.layout.parent_view_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parentList[position]

        holder.textLayout.setOnClickListener {
            openActivity(holder, parent)
        }
        holder.textView.setOnClickListener {
            openActivity(holder, parent)
        }
        holder.textView.text = parentList[position].name

        holder.recyclerView.apply {
            layoutManager = GridLayoutManager(holder.recyclerView.context, 1, GridLayoutManager.HORIZONTAL, false)
            adapter =
                    ChildRecyclerViewAdapter(parent.children)

            //recycledViewPool=viewPool
        }
    }

    private fun openActivity(holder: ViewHolder, children: Category) {

        val intent = Intent(holder.textLayout.context, CategoryListActivity::class.java)
//        intent.putExtra("categoryName",holder.textView.text)
        intent.putExtra("vegetableList", children)
        startActivity(holder.textLayout.context, intent, null)

    }


    override fun getItemCount(): Int {
        return parentList.size
    }


    inner class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        var recyclerView: RecyclerView = itemsView.recyclerChild
        var textView: TextView = itemsView.textView
        var textLayout: ConstraintLayout = itemsView.textLayout


    }

}


