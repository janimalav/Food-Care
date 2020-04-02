package com.example.phase1proj.models



class FoodItem(

        var id: String? = null,
        var name: String? = null,
        var description: String? = null,
        var price: String? = null,
        var units: String? = null,
        var address: String? = null,
        var category: String? = null,
        var imgurl: String? = null,
        var userName: String? = null
) {
    constructor() : this(null, null, null, null, null, null, null, null)
}
