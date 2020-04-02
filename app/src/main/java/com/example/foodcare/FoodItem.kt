package com.example.foodcare

import com.google.firebase.database.Exclude

data class FoodItem(
    @get:Exclude
    var id:String?=null,
    var name:String? = null,
    var description:String? = null,
    var price:String? = null,
    var units:String? = null,
    var address:String? = null,
    var category: String? = null,
    var imgurl: String? = null,
    var userName: String? = null,
    var longitude: Double? = null,
    var latitude: Double? = null
) {
    constructor() : this(null,null,null,null,null,null,
        null,null, null, null)
}