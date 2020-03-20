package com.example.phase1proj

import android.content.Context
import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.marginTop
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.phase1proj.ChildRecyclerViewAdapter.MyViewHolder
import kotlinx.android.synthetic.main.layout.view.*
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
            openActivity(holder)
            Toast.makeText(holder.textLayout.context, holder.textView.text, Toast.LENGTH_LONG)
            .show() }
        holder.textView.setOnClickListener {
            openActivity(holder)
            Toast.makeText(holder.textView.context, holder.textView.text, Toast.LENGTH_LONG)
            .show() }
        holder.textView.text = parentList[position].name

        holder.recyclerView.apply {
            layoutManager = GridLayoutManager(holder.recyclerView.context,1,GridLayoutManager.HORIZONTAL,false)
            adapter = ChildRecyclerViewAdapter(parent.children)

            //recycledViewPool=viewPool
        }
        holder.recyclerView.marginTop
    }

    private fun openActivity(holder:ViewHolder) {

        val intent = Intent(holder.textView.context,CategoryListActivity::class.java)
        intent.putExtra("categoryName",holder.textView.text)
        startActivity(holder.textView.context,intent,null)

    }


    override fun getItemCount(): Int {
        return parentList.size
    }


   inner class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        var recyclerView:RecyclerView = itemsView.recyclerChild
        var textView: TextView = itemsView.textView
        var textLayout:LinearLayout =itemsView.textLayout


    }

}