package com.example.foodcare.views

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.foodcare.R
import com.example.foodcare.models.Vegetable
import com.squareup.picasso.Picasso
//
//class ItemActivity : AppCompatActivity() {
//
//    private lateinit var minus: Button
//    private lateinit var plus: Button
//    private lateinit var quantity: TextView
//    private lateinit var addToCart: Button
//    private lateinit var backButton: ImageButton
//
//    private lateinit var image: ImageView
//    private lateinit var imageTitle: TextView
//    private lateinit var rate: TextView
//    private lateinit var weight: TextView
//
//
//    private lateinit var hurry: TextView
//    private var hurry_value: Int = 0
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.item)
//        image = findViewById(R.id.ItemImage)
//        imageTitle = findViewById(R.id.MainText)
//        rate = findViewById(R.id.itemPrice)
//        weight = findViewById(R.id.size_weight_value)
//
//        var itemDetails = intent.getSerializableExtra("ItemDetails") as? Vegetable
//        minus = findViewById(R.id.minus)
//        plus = findViewById(R.id.plus)
//        quantity = findViewById(R.id.quantity)
//        addToCart = findViewById(R.id.add_to_cart)
//        backButton = findViewById(R.id.backButton)
//        hurry = findViewById(R.id.hurry)
//        setValues(itemDetails)
//        hurry_value = (hurry.text.toString().split(" ")[1]).toInt()
//
//        minus.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                if (getQuantity() > 0) {
//                    quantity.text = (getQuantity() - 1).toString()
//                }
//                if (addToCart.text.toString().contains("added", true)) {
//                    setAddToCart("Update", "#ffffff", "#26b11d")
//
//
//                }
//
//
//            }
//        })
//        backButton.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                this@ItemActivity.finish()
//            }
//
//        })
//        plus.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                var get_value = getQuantity()
//                if (hurry_value > get_value) {
//                    quantity.text = (get_value + 1).toString()
//                } else {
//                    showDialog("Only " + hurry_value.toString() + " remaining in stock")
//                }
//                if (addToCart.text.toString().contains("added", true)) {
//                    setAddToCart("Update", "#ffffff", "#26b11d")
//
//
//                }
//            }
//        })
//        addToCart.setOnClickListener(object : View.OnClickListener {
//            @SuppressLint("ResourceAsColor")
//            override fun onClick(v: View?) {
//                if (getQuantity() > 0) {
//                    val billdialog = AlertDialog.Builder(this@ItemActivity)
//                    billdialog.setMessage("Are you sure to buy " + getQuantity().toString() + "item")
//                            .setCancelable(false).setNegativeButton(
////                        On click of cancel button the values cannot be clear
//                                    "Cancel",
//                                    { dialog, id -> dialog.cancel() }
//                            ).setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
//                                val billdialog = AlertDialog.Builder(this@ItemActivity)
//                                billdialog.setMessage("Order Place Successfully")
//                                        .setCancelable(false).setNegativeButton(
////                        On click of cancel button the values cannot be clear
//                                                "Ok"
//                                        ) { dialog, id ->
//                                            hurry_value -= getQuantity()
//                                            dialog.cancel()
//                                            this@ItemActivity.finish()
//                                        }
//                                val alert = billdialog.create()
//                                alert.setTitle("Notice")
//                                alert.show()
//                                //                  On click of OK  the values of all the text and edit views will be cleared
//
//                            }
//                    val alert = billdialog.create()
//                    alert.setTitle("Buy")
//                    alert.show()
//                }
//            }
//
//
//        })
//
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun setValues(itemDetails: Vegetable?) {
//
//
//        if (itemDetails != null) {
//            Picasso.get().load(itemDetails.url).into(image)
//
//            imageTitle.text = itemDetails.name
//            rate.text = "$" + itemDetails.price.toString()
//            hurry.text = "Hurry! " + itemDetails.stock.toString() + " item left"
//            weight.text = itemDetails.weight.toString()
//
//
//        }
//
//    }
//
//    private fun showDialog(message: String, setTitle: String = "Notice") {
//        val billdialog = AlertDialog.Builder(this)
//        billdialog.setMessage(message)
//                .setCancelable(false).setPositiveButton(
//                        "Ok",
//                        { dialog, id -> dialog.cancel() })
//        // create bill dialog and show
//        val alert = billdialog.create()
//        alert.setTitle(setTitle)
//        alert.show()
//    }
//
//    private fun setAddToCart(text: String, textColor: String, setBackgroundColor: String) {
//        addToCart.text = text
//        addToCart.setTextColor(Color.parseColor(textColor))
//        addToCart.setBackgroundColor(Color.parseColor(setBackgroundColor))
//
//    }
//
//    private fun getQuantity(): Int {
//
//        var quantity = quantity.text.toString().toInt()
//
//        return quantity
//
//
//    }
//
//}
