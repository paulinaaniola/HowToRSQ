package com.rsq.howtorsq

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pizza_details.*

class PizzaDetailsActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_details)
    }

    override fun onStart() {
        super.onStart()
        val pizza = intent.getSerializableExtra("pizza")
        if (pizza is Pizza) {
            setupPizzaDetails(pizza)
        }
    }

    private fun setupPizzaDetails(pizza: Pizza) {
        nameTextView.text = pizza.name
        priceTextView.text = pizza.price.toString()
        ingredientsTextView.text = pizza.ingredients
    }

}