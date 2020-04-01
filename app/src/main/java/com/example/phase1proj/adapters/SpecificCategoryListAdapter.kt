package com.example.phase1proj.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.phase1proj.views.ItemActivity
import com.example.phase1proj.R
import com.example.phase1proj.R.layout.child_card_view_list
import com.example.phase1proj.models.Vegetable
import kotlinx.android.synthetic.main.child_card_view_list.view.*

class SpecificCategoryListAdapter(
    private val vegetableList: List<Vegetable>
) : RecyclerView.Adapter<SpecificCategoryListAdapter.MyViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder1 {
        val view: View
        val layoutInflater = LayoutInflater.from(parent.context)
        view = layoutInflater.inflate(child_card_view_list, parent, false)
        return MyViewHolder1(
            view
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder1, position: Int) {
        holder.vegetableTitle.text = vegetableList[position].name
        holder.vegetableThumbnail.setImageResource(vegetableList[position].thumbnail!!)
        holder.rateVegetable.text = "$ " + vegetableList[position].price.toString()
        holder.weightVegetable.text = vegetableList[position].weight

        holder.cardLayout.setOnClickListener {
            openActivity(holder, vegetableList[position].name)
        }
    }

    private fun openActivity(holder: MyViewHolder1, Name: String?) {

        val intent = Intent(holder.cardLayout.context, ItemActivity::class.java)
        intent.putExtra("itemName", Name)
        ContextCompat.startActivity(holder.cardLayout.context, intent, null)

    }

    override fun getItemCount(): Int {
        return vegetableList.size
    }

    class MyViewHolder1(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        var vegetableTitle: TextView
        var rateVegetable: TextView
        var weightVegetable: TextView
        var vegetableThumbnail: ImageView
        var cardLayout: ConstraintLayout

        init {
            rateVegetable = itemsView.findViewById(R.id.rate) as TextView
            weightVegetable = itemsView.findViewById(R.id.weight) as TextView
            vegetableTitle =
                itemsView.findViewById<View>(R.id.vegetableTitle) as TextView
            vegetableThumbnail =
                itemsView.findViewById<View>(R.id.VegetableThumbnail) as ImageView
            cardLayout = itemsView.item
        }
    }
}