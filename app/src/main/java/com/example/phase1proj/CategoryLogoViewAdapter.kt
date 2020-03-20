package com.example.phase1proj

import android.annotation.SuppressLint
import android.content.Intent
import android.util.AttributeSet
import android.util.Xml
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.child_card_view_list.view.*


class CategoryLogoViewAdapter(private val logoList: List<CategoryLogo>) : RecyclerView.Adapter<CategoryLogoViewAdapter.MyLogoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyLogoViewHolder {
        val view: View
        val layoutInflater = LayoutInflater.from(parent.context)
        view = layoutInflater.inflate(R.layout.category_recycler, parent, false)

        return MyLogoViewHolder(view)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: MyLogoViewHolder, position: Int) {
        holder.logoName.text = logoList[position].name
        holder.logoImage.setImageResource(logoList[position].thumbnail!!)
        holder.logoImage.tag = logoList[position].thumbnail!!
        var parser = holder.logoImage.resources.getXml(R.layout.changeablecard)
        try {
            parser.next()
            parser.nextTag()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val attr: AttributeSet = Xml.asAttributeSet(parser)
        var parser_rev = holder.logoImage.resources.getXml(R.layout.changeablecard_reverse)
        try {
            parser_rev.next()
            parser_rev.nextTag()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val attr_rev: AttributeSet = Xml.asAttributeSet(parser_rev)


        holder.logoImage.setOnClickListener {
            Toast.makeText(holder.logoImage.context, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()

            if(holder.logoImage.tag == logoList[position].thumbnail!!){
                holder.logoImage.tag=R.drawable.border_category

//                holder.innerCard.layoutParams.height=holder.innerCard.layoutParams.height-5
//                holder.innerCard.layoutParams.width=holder.innerCard.layoutParams.width-5
                holder.innerCard.apply {
                    layoutParams = FrameLayout.LayoutParams(holder.innerCard.context, attr)
                }

            }
            else
            {
                println("its here")

                holder.logoImage.tag=logoList[position].thumbnail!!
                holder.innerCard.apply {
                    layoutParams = FrameLayout.LayoutParams(holder.innerCard.context, attr_rev)
                }
            }

        }

    }



    override fun getItemCount(): Int {
        return logoList.size
    }

    class MyLogoViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        var logoName: TextView
        var logoImage: ImageView
        var innerCard:CardView

        var textLayout = itemsView.item

        init {
            logoName =
                itemsView.findViewById<View>(R.id.categoryLogoName) as TextView
            logoImage =
                itemsView.findViewById<View>(R.id.categoryLogo) as ImageView
            innerCard=itemsView.findViewById(R.id.innerCardView)
        }
    }

    private fun openActivity(holder: ChildRecyclerViewAdapter.MyViewHolder, Name: String?) {

        val intent = Intent(holder.textLayout.context, ItemActivity::class.java)
        intent.putExtra("itemName", Name)
        ContextCompat.startActivity(holder.textLayout.context, intent, null)

    }

}