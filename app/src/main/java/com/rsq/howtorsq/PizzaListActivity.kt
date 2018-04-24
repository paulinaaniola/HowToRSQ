package com.rsq.howtorsq

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_pizza_list.*

class PizzaListActivity : Activity() {

    private val listOfPizza: MutableList<Pizza> = mutableListOf()
    private var pizzaAdapter: PizzaListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_list)

        createPlaceholderPizzas()
        setupPizzaListAdapter()
        setupAddButton()
    }

    private fun setupAddButton() {
        addButton.setOnClickListener({
            addPizzaToList()
        })
    }

    private fun addPizzaToList() {
        if (isEditTextEmpty(pizzaNameEditText) && isEditTextEmpty(priceEditText) && isEditTextEmpty(ingredientsEditText)) {
            val pizzaName = pizzaNameEditText.text.toString()
            val price = priceEditText.text.toString().toInt()
            val ingredients = ingredientsEditText.text.toString()
            val pizzaToAdd = Pizza(pizzaName, price, ingredients)
            pizzaAdapter?.addPizza(pizzaToAdd)
            clearEditTextData()
        }
    }

    private fun isEditTextEmpty(edittext: EditText): Boolean {
        val isNotEmpty = edittext.text.toString().isNotEmpty()
        if (!isNotEmpty) {
            edittext.error = resources.getString(R.string.empty_edit_text_error)
        }
        return isNotEmpty
    }

    private fun clearEditTextData() {
        pizzaNameEditText.text.clear()
        priceEditText.text.clear()
        ingredientsEditText.text.clear()
    }

    private fun createPlaceholderPizzas() {
        listOfPizza.add(Pizza("Margarita", 12, "Ser, pomidor"))
        listOfPizza.add(Pizza("Pepperoni", 12, "Ser, pomidor, pepperoni"))
        listOfPizza.add(Pizza("Kebab", 12, "Ser, pomidor, kebab"))
    }

    private fun setupPizzaListAdapter() {
        pizzaAdapter = PizzaListAdapter()
        pizzaListRecyclerView.layoutManager = LinearLayoutManager(this)
        pizzaListRecyclerView.adapter = pizzaAdapter
        pizzaAdapter?.setListOfPizza(listOfPizza)
    }

}
