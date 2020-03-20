package com.example.phase1proj

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.phase1proj.ChildRecyclerViewAdapter.MyViewHolder
import kotlinx.android.synthetic.main.child_card_view_list.view.*

class ChildRecyclerViewAdapter(
    private val vegetableList: List<Vegetable>
) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val layoutInflater = LayoutInflater.from(parent.context)
        view = layoutInflater.inflate(R.layout.child_card_view_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vegetableTitle.text = vegetableList[position].name
        holder.vegetableThumbnail.setImageResource(vegetableList[position].thumbnail!!)

        holder.textLayout.setOnClickListener {
            openActivity(holder, vegetableList[position].name)
        }

    }

    override fun getItemCount(): Int {
        return vegetableList.size
    }

    class MyViewHolder(itemsView: View) : ViewHolder(itemsView) {
        var vegetableTitle: TextView
        var vegetableThumbnail: ImageView


        var textLayout = itemsView.item

        init {
            vegetableTitle =
                itemsView.findViewById<View>(R.id.vegetableTitle) as TextView
            vegetableThumbnail =
                itemsView.findViewById<View>(R.id.VegetableThumbnail) as ImageView
        }
    }

    private fun openActivity(holder: ChildRecyclerViewAdapter.MyViewHolder, Name: String?) {

        val intent = Intent(holder.textLayout.context, ItemActivity::class.java)
        intent.putExtra("itemName", Name)
        ContextCompat.startActivity(holder.textLayout.context, intent, null)

    }

}