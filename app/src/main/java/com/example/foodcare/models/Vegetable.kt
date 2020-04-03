package com.example.foodcare.models

import java.io.Serializable

class Vegetable : Serializable {
    var name: String = ""
        private set
    var category: String = ""
        private set
    var thumbnail: Int? = null
        private set
    var description: String? = null
        private set
    var stock: Int? = null
        private set
    var price: Double? = null
        private set
    var weight: String? = null
        private set
    var url: String? = null
        private set

    constructor()
    constructor(
            name: String,
            category: String,
            thumbnail: Int?,
            description: String?,
            stock: Int?,
            price: Double?, weight: String?, url: String? = ""
    ) {
        this.name = name
        this.category = category
        this.thumbnail = thumbnail
        this.description = description
        this.stock = stock
        this.price = price
        this.weight = weight
        this.url = url
    }

}