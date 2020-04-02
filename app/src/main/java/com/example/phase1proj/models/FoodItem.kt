package com.example.phase1proj.models

import com.google.firebase.database.Exclude

class FoodItem(
        @get:Exclude
        var id: String? = null,
        var name: String? = null,
        var description: String? = null,
        var price: String? = null,
        var weight: String? = null,
        var address: String? = null,
        var category: String? = null,
        var imgurl: String? = null,
        var username: String? = null
) {
    constructor() : this(null, null, null, null, null, null, null, null)
}
