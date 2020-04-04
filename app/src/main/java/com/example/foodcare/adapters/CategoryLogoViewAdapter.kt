package com.example.foodcare.adapters

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
import com.example.foodcare.*
import com.example.foodcare.models.Category
import com.example.foodcare.models.CategoryLogo
import com.example.foodcare.views.ItemActivity
import com.example.foodcare.views.home
import kotlinx.android.synthetic.main.child_card_view_list.view.*

class CategoryLogoViewAdapter(private val logoList: List<CategoryLogo>, private val home: home) :
        RecyclerView.Adapter<CategoryLogoViewAdapter.MyLogoViewHolder>() {
    private lateinit var parents: List<Category>
    private lateinit var globalparents: List<Category>
    private lateinit var selectCategories: List<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyLogoViewHolder {
        val view: View
        val layoutInflater = LayoutInflater.from(parent.context)
        view = layoutInflater.inflate(R.layout.category_recycler, parent, false)
        parents = home.getParentsItems()

        return MyLogoViewHolder(
                view
        )
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: MyLogoViewHolder, position: Int) {
        holder.logoName.text = logoList[position].name

        var imageSource = when (logoList[position].name) {
            "Meat & Poultry" -> R.drawable.meat_1
            "Fish & Seafood" -> R.drawable.fish_sea_food_m
            "Dairy & Cheese" -> R.drawable.dairy_cheese_m
            "Fruits & Veggies" -> R.drawable.fruits_veggies_1
            "Bakery" -> R.drawable.bakery_m
            "Grocery" -> R.drawable.grocery
            "Frozen" -> R.drawable.frozen_1
            "Drinks" -> R.drawable.drinks_m
            "Organic" -> R.drawable.organic
            "Other" -> R.drawable.veggie1

            else -> R.drawable.veggie2
        }
        holder.logoImage.setImageResource(imageSource)
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
        globalparents = home.wholeParentItems()


        var set_globalparents = globalparents.copy()
        selectCategories = mutableListOf()
        holder.logoImage.setOnClickListener {
            set_globalparents = home.wholeParentItems().copy()
            //            Toast.makeText(holder.logoImage.context, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()

            if (holder.logoImage.tag == logoList[position].thumbnail!!) {
                holder.logoImage.tag =
                    R.drawable.border_category

                (selectCategories as MutableList<String>).add(holder.logoName.text.toString())
                parents = home.SearchItems(
                        "", parents = set_globalparents as MutableList<Category>,
                        categoryList = selectCategories
                )
                home.setParentsWithAdapter(parents)
//                holder.innerCard.layoutParams.height=holder.innerCard.layoutParams.height-5
//                holder.innerCard.layoutParams.width=holder.innerCard.layoutParams.width-5
                holder.innerCard.apply {
                    layoutParams = FrameLayout.LayoutParams(holder.innerCard.context, attr)
                }

            } else {
                println("its here")
                set_globalparents = home.wholeParentItems().copy()

                (selectCategories as MutableList<String>).remove(holder.logoName.text.toString())
                parents = home.SearchItems(
                        "", parents = set_globalparents as MutableList<Category>,
                        categoryList = selectCategories
                )
                home.setParentsWithAdapter(parents)
                holder.logoImage.tag = logoList[position].thumbnail!!
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
        var innerCard: CardView

        var textLayout = itemsView.item

        init {
            logoName =
                    itemsView.findViewById<View>(R.id.categoryLogoName) as TextView
            logoImage =
                    itemsView.findViewById<View>(R.id.categoryLogo) as ImageView
            innerCard = itemsView.findViewById(R.id.innerCardView)
        }
    }

    private fun openActivity(holder: ChildRecyclerViewAdapter.MyViewHolder, Name: String?) {

        val intent = Intent(holder.textLayout.context, ItemActivity::class.java)
        intent.putExtra("itemName", Name)
        ContextCompat.startActivity(holder.textLayout.context, intent, null)

    }

    fun List<Category>.copy(): List<Category> {
        val arr = mutableListOf<Category>()
        for (i in this) {
            arr.add(i)
        }
        return arr
    }


}