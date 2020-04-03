package com.example.foodcare.models

import java.io.Serializable

class Category(
        val name: String,
        var children: List<Vegetable>
) : Serializable