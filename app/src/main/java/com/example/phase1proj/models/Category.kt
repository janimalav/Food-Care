package com.example.phase1proj.models

import java.io.Serializable

class Category(
        val name: String,
        var children: List<Vegetable>
) : Serializable