package com.example.foodcare.models

class CategoryLogo() {
    var name: String? = null
        private set
    var thumbnail: Int? = null
        private set
    var url: String? = null
        private set

    constructor(name: String?, thumbnail: Int, url: String?) : this() {
        this.name=name
        this.thumbnail=thumbnail
        this.url=url
    }
}