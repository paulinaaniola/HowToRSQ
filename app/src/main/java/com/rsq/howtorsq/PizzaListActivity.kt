package com.rsq.howtorsq

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pizza_list.*

class PizzaListActivity : Activity() {

    private val listOfPizza: MutableList<Pizza> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_list)

        createPlaceholderPizzas()
        setupAddButton()
    }

    private fun setupAddButton() {
        addButton.setOnClickListener({
            addPizzaToList()
        })
    }

    private fun addPizzaToList() {
        val pizzaName = pizzaNameEditText.text.toString()
        val price = priceEditText.text.toString().toInt()
        val ingredients = ingredientsEditText.text.toString()
        val pizzaToAdd = Pizza(pizzaName, price, ingredients)
        listOfPizza.add(pizzaToAdd)
        clearEditTextData()
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

}
