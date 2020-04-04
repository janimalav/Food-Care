package com.example.foodcare.adapters

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
import com.example.foodcare.views.ItemActivity
import com.example.foodcare.R
import com.example.foodcare.models.Vegetable
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.child_card_view_list.view.*
import java.io.File


class ChildRecyclerViewAdapter(
        private val vegetableList: List<Vegetable>

) :
        RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder>() {
    private val storage: FirebaseStorage = Firebase.storage
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View

        val layoutInflater = LayoutInflater.from(parent.context)
        view = layoutInflater.inflate(R.layout.child_card_view_list, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.vegetableTitle.text = vegetableList[position].name
        if (vegetableList[position].thumbnail!! == 999) {
            var imagesRef: StorageReference? = storage.getReferenceFromUrl("gs://foodcare-c10c6.appspot.com/images/" + vegetableList[position].url)
            val localFile = File.createTempFile("images", "jpg")
//            if (imagesRef != null) {
//                imagesRef.getFile(localFile).addOnSuccessListener {
//                    // Local temp file has been created
//                }.addOnFailureListener {
//                    // Handle any errors
//                }
//            }
            Picasso.get().load(vegetableList[position].url).into(holder.vegetableThumbnail)
//            GlideApp.with(holder.vegetableThumbnail.context).load(imagesRef).into(holder.vegetableThumbnail)
//        } else {
//            holder.vegetableThumbnail.setImageResource(R.drawable.veggie1)
        }
        holder.rateVegetable.text = "$ " + vegetableList[position].price.toString()
        //holder.weightVegetable.text = vegetableList[position].weight

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

    private fun openActivity(holder: MyViewHolder, item: Vegetable) {

        val intent = Intent(holder.textLayout.context, ItemActivity::class.java)
        intent.putExtra("ItemDetails", item)
        ContextCompat.startActivity(holder.textLayout.context, intent, null)

    }

}