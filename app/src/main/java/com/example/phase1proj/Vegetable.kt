package com.example.phase1proj

class Vegetable {
    var name: String? = null
        private set
    var category: String? = null
        private set
    var thumbnail: Int? = null
        private set
    var description: String? = null
        private set

    constructor() {}
    constructor(
        name: String?,
        category: String?,
        thumbnail: Int?,
        description: String?
    ) {
        this.name = name
        this.category = category
        this.thumbnail = thumbnail
        this.description = description
    }

}