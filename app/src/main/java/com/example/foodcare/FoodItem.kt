package com.example.foodcare

import com.google.firebase.database.Exclude

data class FoodItem(
    @get:Exclude
    var id:String?=null,
    var name:String? = null,
    var description:String? = null,
    var price:String? = null,
    var weight:String? = null,
    var address:String? = null,
    var category: String?=null
) {
    constructor() : this(null,null,null,null,null,null,null)
}