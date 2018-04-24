package com.rsq.howtorsq

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_pizza.view.*

class PizzaListAdapter : RecyclerView.Adapter<PizzaListAdapter.ViewHolder>() {

    private var listOfPizza: MutableList<Pizza> = mutableListOf()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_pizza, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listOfPizza.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pizza = listOfPizza[position]
        holder.pizzaNameTextView.text = pizza.name
        holder.pizzaLayout.setOnClickListener({
            context?.startActivity(Intent(context, PizzaDetailsActivity::class.java)
                    .putExtra("pizza", pizza))
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pizzaNameTextView = view.pizzaNameTextView
        val pizzaLayout = view.pizzaLayout
    }

    fun setListOfPizza(listOfPizza: MutableList<Pizza>) {
        this.listOfPizza = listOfPizza
        notifyDataSetChanged()
    }

    fun addPizza(pizza: Pizza) {
        this.listOfPizza.add(pizza)
        notifyDataSetChanged()
    }
}