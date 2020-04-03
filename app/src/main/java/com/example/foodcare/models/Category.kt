package com.example.foodcare

import java.io.Serializable

class Category(
        val name: String,
        var children: List<Vegetable>
) : Serializable