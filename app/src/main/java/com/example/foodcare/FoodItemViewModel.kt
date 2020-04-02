package com.example.foodcare

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import java.lang.Exception

class FoodItemViewModel :ViewModel() {

    private val _result = MutableLiveData<Exception>()
    val result : LiveData<Exception?>
    get() = _result

    fun addFoodItem(fooditem:FoodItem){
        val dbFoodItems = FirebaseDatabase.getInstance().getReference(NODE_FOODITEMS)
        fooditem.id= dbFoodItems.push().key
        dbFoodItems.child(fooditem.id!!).setValue(fooditem)
            .addOnCompleteListener {
                if(it.isSuccessful) _result.value=null
                else{
                    _result.value = it.exception
                }
            }

    }

}