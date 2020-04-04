package com.example.foodcare.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcare.FoodItem
import com.example.foodcare.R
import com.example.foodcare.adapters.CategoryLogoViewAdapter
import com.example.foodcare.adapters.ParentRecyclerViewAdapter
import com.example.foodcare.models.Category
import com.example.foodcare.models.CategoryLogo
import com.example.foodcare.models.Vegetable
import com.google.firebase.database.*

class home : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var logorecycler: RecyclerView
    private lateinit var searchview: SearchView
    private val dbitems = FirebaseDatabase.getInstance().getReference("fooditems")
    private var usermap: HashMap<String, MutableList<Vegetable>> = hashMapOf()


    private lateinit var vegetables_3: List<Vegetable>
    private var parents: List<Category> = listOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home, container, false)
        vegetables_3 = mutableListOf()
        fetchVegetbles(dbitems)
//        wholeFetchVegetbles(dbitems)

        //
        logorecycler = view.findViewById(R.id.recyclerCategory)

        logorecycler.apply {
            layoutManager = GridLayoutManager(
                context, 1,
                GridLayoutManager.HORIZONTAL, false
            )
            adapter = CategoryLogoViewAdapter(
                getLogos(2), this@home
            )

        }

        recyclerView = view.findViewById(R.id.recyclerParent)
        searchview = view.findViewById(R.id.searchText) as SearchView

//
//        if(parents.isNotEmpty())
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(
//                context,
//                RecyclerView.VERTICAL,
//                false
//            )
//
//            adapter = ParentRecyclerViewAdapter(
//                parents
//            )
//
//
////            layoutParams= ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,40)
//
//        }


        var noResultsImage = view.findViewById(R.id.noResult) as ImageView
        searchview.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(context, "Looking for $query", Toast.LENGTH_LONG).show()
                var new_parents: MutableList<Category> = mutableListOf()
                for (i in parents) {
                    var new_childrens: MutableList<Vegetable> = mutableListOf()
                    var category_name = i.name
                    for (j in i.children) {
                        new_childrens.add(
                            Vegetable(
                                j.name,
                                j.category,
                                j.thumbnail,
                                j.description,
                                j.stock,
                                j.price,
                                j.weight,
                                j.url
                            )
                        )
                    }
                    new_parents.add(Category(category_name, new_childrens))
                }
                searchview.clearFocus()
                var categories = SearchItems(query, new_parents)
                if (categories.isNotEmpty()) {
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(
                            context,
                            RecyclerView.VERTICAL,
                            false
                        )
                        adapter =
                            ParentRecyclerViewAdapter(
                                categories
                            )
                        invalidate()

                    }
                    logorecycler.visibility = View.VISIBLE
                    logorecycler.apply {
                        layoutManager = GridLayoutManager(
                            context, 1,
                            GridLayoutManager.HORIZONTAL, false
                        )
                        adapter =
                            CategoryLogoViewAdapter(
                                getLogos(2),
                                this@home
                            )

                    }
                    recyclerView.visibility = View.VISIBLE
                    noResultsImage.visibility = View.INVISIBLE

                } else {
                    logorecycler.visibility = View.INVISIBLE
                    recyclerView.visibility = View.INVISIBLE
                    noResultsImage.visibility = View.VISIBLE
                }
                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.equals("")) {
                    var new_parents: MutableList<Category> = mutableListOf()
                    for (i in parents) {
                        var new_childrens: MutableList<Vegetable> = mutableListOf()
                        var category_name = i.name
                        for (j in i.children) {
                            new_childrens.add(
                                Vegetable(
                                    j.name,
                                    j.category,
                                    j.thumbnail,
                                    j.description,
                                    j.stock,
                                    j.price,
                                    j.weight,
                                    j.url
                                )
                            )
                        }
                        new_parents.add(Category(category_name, new_childrens))
                    }
                    searchview.clearFocus()
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(
                            context,
                            RecyclerView.VERTICAL,
                            false
                        )
                        adapter =
                            ParentRecyclerViewAdapter(
                                SearchItems(newText, parents = new_parents)
                            )
                        invalidate()
                        recyclerView.visibility = View.VISIBLE
                        logorecycler.visibility = View.VISIBLE
                        noResultsImage.visibility = View.INVISIBLE
                    }
                    return false
                } else {
                    logorecycler.visibility = View.INVISIBLE
                    recyclerView.visibility = View.INVISIBLE

                }
                return false
            }
        })
        return view


    }

    private fun getLogos(count: Int): List<CategoryLogo> {
        val categories = mutableListOf<CategoryLogo>()
        var category_name = listOf(
            "Meat & Poultry",
            "Fish & Seafood",
            "Dairy & Cheese",
            "Fruits & Veggies",
            "Bakery",
            "Grocery",
            "Frozen",
            "Drinks",
            "Organic",
            "Other"
        )
        for (name in category_name) {
            val logo = CategoryLogo(
                name,
                R.drawable.veggie1,
                ""
            )
            categories.add(logo)
        }
        return categories
    }


    fun getParentsItems(): List<Category> {
        return this.parents
    }

    fun wholeParentItems(): List<Category> {

        return this.parents
    }


    fun setParentsWithAdapter(parents: List<Category>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )

            adapter =
                ParentRecyclerViewAdapter(parents)


        }
    }

    fun SearchItems(
        searchText: String?,
        parents: MutableList<Category>,
        categoryList: List<String>? = null
    ): MutableList<Category> {
        var new_parents: MutableList<Category> = mutableListOf()
        for (i in parents) {
            var new_childrens: MutableList<Vegetable> = mutableListOf()
            var category_name = i.name
            for (j in i.children) {
                new_childrens.add(
                    Vegetable(
                        j.name,
                        j.category,
                        j.thumbnail,
                        j.description,
                        j.stock,
                        j.price,
                        j.weight,
                        j.url
                    )
                )
            }
            new_parents.add(Category(category_name, new_childrens))
        }
        var parents1 = new_parents
        if (searchText != "") {
            for (i in parents1) {

                if (!i.name.contains(searchText.toString(), ignoreCase = true)) {

                    i.children = i.children.filter {
                        it.name.contains(searchText.toString(), ignoreCase = true)
                    }.toMutableList()
                }
            }
            parents1 = parents1.filter { it.children.isNotEmpty() }.toMutableList()
        }
        if (categoryList != null) {
            if (categoryList.isNotEmpty()) {
                for (i in parents1) {


                    i.children = i.children.filter {
                        categoryList.contains(it.category)
                    }.toMutableList()

                }
                parents1 = parents1.filter { it.children.isNotEmpty() }.toMutableList()
            }
        }
        return parents1.toMutableList()
    }


    fun List<Category>.copy(): List<Category> {
        val arr = mutableListOf<Category>()
        for (i in this) {
            arr.add(i)
        }
        return arr
    }

    fun fetchVegetbles(dbitems: DatabaseReference) {
        usermap = hashMapOf()
        dbitems.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {}

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val vegetables_1 = mutableListOf<Vegetable>()
                    val data_parents = mutableListOf<Category>()
                    for (authorSnapshot in snapshot.children) {

                        val author = authorSnapshot.getValue(FoodItem::class.java)
                        if (author != null) {
                            if (author.userName.isNullOrEmpty()) {
                                author.userName = "other"
                            }
                            if (usermap[author.userName!!] == null) {

                                var new_vegetable = mutableListOf<Vegetable>(
                                    Vegetable(
                                        name = author.name!!,
                                        category = author.category!!,
                                        thumbnail = 999,
                                        description = author.description,
                                        stock = author.units?.toInt(),
                                        price = author.price?.toDouble(),
                                        weight = "229g",
                                        url = author.imgurl
                                    )
                                )
                                usermap.put(author.userName!!, new_vegetable)
                            } else {
                                var old_vegetable: MutableList<Vegetable> =
                                    usermap.getValue(author.userName!!)
                                old_vegetable.add(
                                    (Vegetable(
                                        name = author.name!!,
                                        category = author.category!!,
                                        thumbnail = 999,
                                        description = author.description,
                                        stock = author.units?.toInt(),
                                        price = author.price?.toDouble(),
                                        weight = "229g",
                                        url = author.imgurl
                                    ))
                                )
                            }

                        }


                    }
                    for ((key, value) in usermap) {
                        data_parents.add(Category(key, value.toList()))
                    }
                    parents = data_parents

                    if (!parents.isNullOrEmpty()) {
                        setParentsWithAdapter(parents)


                    }


                }
            }

        })

    }


}