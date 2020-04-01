package com.example.phase1proj.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.phase1proj.views.ItemActivity
import com.example.phase1proj.R
import com.example.phase1proj.adapters.ChildRecyclerViewAdapter.MyViewHolder
import com.example.phase1proj.models.Vegetable
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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vegetableTitle.text = vegetableList[position].name
        holder.vegetableThumbnail.setImageResource(vegetableList[position].thumbnail!!)
        holder.rateVegetable.text = "$ " + vegetableList[position].price.toString()
        holder.weightVegetable.text = vegetableList[position].weight

        holder.textLayout.setOnClickListener {
            openActivity(holder, vegetableList[position])
        }

    }

    override fun getItemCount(): Int {
        return vegetableList.size
    }

    class MyViewHolder(itemsView: View) : ViewHolder(itemsView) {
        var vegetableTitle: TextView
        var vegetableThumbnail: ImageView
        var weightVegetable: TextView
        var rateVegetable: TextView


        var textLayout = itemsView.item

        init {
            rateVegetable = itemsView.findViewById(R.id.rate) as TextView
            weightVegetable = itemsView.findViewById(R.id.weight) as TextView
            vegetableTitle =
                itemsView.findViewById<View>(R.id.vegetableTitle) as TextView
            vegetableThumbnail =
                itemsView.findViewById<View>(R.id.VegetableThumbnail) as ImageView
        }
    }

    private fun openActivity(holder: ChildRecyclerViewAdapter.MyViewHolder, item: Vegetable) {

        val intent = Intent(holder.textLayout.context, ItemActivity::class.java)
        intent.putExtra("ItemDetails", item)
        ContextCompat.startActivity(holder.textLayout.context, intent, null)

    }

}