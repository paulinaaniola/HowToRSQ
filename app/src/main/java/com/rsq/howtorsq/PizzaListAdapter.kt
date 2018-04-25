package com.rsq.howtorsq

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.daimajia.swipe.SwipeLayout
import kotlinx.android.synthetic.main.item_list_bottom_pizza.view.*
import kotlinx.android.synthetic.main.item_list_top_pizza.view.*
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
        setupSwipeDelete(holder.pizzaItemSwipeLayout)
        setupBottomViewClick(holder.bottomWrapperLayout, pizza)
    }

    private fun setupBottomViewClick(bottomWrapperLayout: FrameLayout?, pizza: Pizza) {
        bottomWrapperLayout?.setOnClickListener({
            deletePizzaFromList(pizza)
        })
    }

    private fun deletePizzaFromList(pizza: Pizza) {
        listOfPizza.remove(pizza)
        notifyDataSetChanged()
    }

    private fun setupSwipeDelete(pizzaItemSwipeLayout: SwipeLayout) {
        with(pizzaItemSwipeLayout) {
            showMode = SwipeLayout.ShowMode.PullOut
            addDrag(SwipeLayout.DragEdge.Left, bottomWrapperLayout)
            addDrag(SwipeLayout.DragEdge.Right, null)
            isSwipeEnabled = true
            addSwipeListener(object : SwipeLayout.SwipeListener {
                override fun onStartOpen(layout: SwipeLayout) {

                }

                override fun onOpen(layout: SwipeLayout) {

                }

                override fun onStartClose(layout: SwipeLayout) {

                }

                override fun onClose(layout: SwipeLayout) {

                }

                override fun onUpdate(layout: SwipeLayout, leftOffset: Int, topOffset: Int) {

                }

                override fun onHandRelease(layout: SwipeLayout, xvel: Float, yvel: Float) {

                }
            })
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pizzaNameTextView = view.pizzaNameTextView
        val pizzaLayout = view.pizzaLayout
        val bottomWrapperLayout = view.bottomWrapperLayout
        val pizzaItemSwipeLayout = view.pizzaItemSwipeLayout
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