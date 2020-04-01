package com.example.phase1proj.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phase1proj.R
import com.example.phase1proj.adapters.CategoryLogoViewAdapter
import com.example.phase1proj.adapters.ParentRecyclerViewAdapter
import com.example.phase1proj.models.Category
import com.example.phase1proj.models.CategoryLogo
import com.example.phase1proj.models.Vegetable


class home : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var logorecycler: RecyclerView
    private lateinit var linearLayout: LinearLayout
    private lateinit var searchview: SearchView

    lateinit var toolbar: ActionBar
    private lateinit var parents: List<Category>
    private var count: Int = 4


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)


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
        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )

            adapter = ParentRecyclerViewAdapter(
                getParents(count)
            )


//            layoutParams= ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,40)

        }
        searchview = view.findViewById(R.id.searchText) as SearchView


        var noResultsImage = view.findViewById(R.id.noResult) as ImageView
        searchview.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(context, "Looking for $query", Toast.LENGTH_LONG).show()

                searchview.clearFocus()
                var categories = getParents(4, query)
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
                    searchview.clearFocus()
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(
                            context,
                            RecyclerView.VERTICAL,
                            false
                        )
                        adapter =
                            ParentRecyclerViewAdapter(
                                getParents(4, newText)
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

//        toolbar = supportActionBar!!
//        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

    }

    private fun getLogos(count: Int): List<CategoryLogo> {
        val categories = mutableListOf<CategoryLogo>()
        repeat(count / 2) {
            val logo = CategoryLogo(
                "Raw",
                R.drawable.veggie1,
                ""
            )
            categories.add(logo)
        }
        repeat(count / 2) {
            val logo = CategoryLogo(
                "Meat",
                R.drawable.veggie2,
                ""
            )
            categories.add(logo)
        }
        return categories
    }


    private fun getParents(count: Int, searchText: String? = ""): List<Category> {
        var parents = mutableListOf<Category>()
        repeat(count / 2) {
            val parent = Category(
                "Veggies",
                getChildren(20)
            )
            parents.add(parent)
        }
        repeat(count / 2) {
            val parent =
                Category("Arjun", getChildren(20))
            parents.add(parent)
        }
        parents = SearchItems(searchText, parents)
        this.parents = parents
        return parents
    }

    fun getParentsItems(): List<Category> {
        return this.parents
    }

    fun wholeParentItems(): List<Category> {
        var parents_whole = mutableListOf<Category>()
        repeat(count / 2) {
            val child_whole = Category(
                "Veggies",
                getChildren(20)
            )
            parents_whole.add(child_whole)
        }
        repeat(count / 2) {
            val child_whole =
                Category("Arjun", getChildren(20))
            parents_whole.add(child_whole)
        }
        return parents_whole
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


//            layoutParams= ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,40)

        }
    }

    fun SearchItems(
        searchText: String?,
        parents: MutableList<Category>,
        categoryList: List<String>? = null
    ): MutableList<Category> {
        var parents1 = parents.copy()
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


    private fun getChildren(count: Int): List<Vegetable> {
        val children = mutableListOf<Vegetable>()
        repeat(count / 2) {
            children.add(
                Vegetable(
                    "Lobster Cooked in store",
                    "Meat",
                    R.drawable.veggie1,
                    "New Veggie", 20, 45.20, "300g"
                )
            )
        }
        repeat(count / 2) {
            children.add(
                Vegetable(
                    "Seasoned pork rack ribs end",
                    "Raw",
                    R.drawable.veggie2,
                    "New Veggie", 10, 21.20, "400g"
                )
            )
        }
        return children
    }

    fun List<Category>.copy(): List<Category> {
        val arr = mutableListOf<Category>()
        for (i in this) {
            arr.add(i)
        }
        return arr
    }
//    fun onClickStore(v: View?) {
//
//        val tv = findViewById(R.id.textView) as TextView
//
//
//        //alter text of textview widget
//        tv.text = "This text view is clicked"
//        //assign the textview forecolor
//        tv.setTextColor(Color.BLUE)
//    }

}