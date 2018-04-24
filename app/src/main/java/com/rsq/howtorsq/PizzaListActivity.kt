package com.rsq.howtorsq

import android.app.Activity
import android.os.Bundle

class PizzaListActivity : Activity() {

    private val listOfPizza: MutableList<Pizza> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_list)

        listOfPizza.add(Pizza("Margarita", 12, "Ser, pomidor"))
        listOfPizza.add(Pizza("Pepperoni", 12, "Ser, pomidor, pepperoni"))
        listOfPizza.add(Pizza("Kebab", 12, "Ser, pomidor, kebab"))
    }

    override fun onStart() {
        super.onStart()
    }

}
