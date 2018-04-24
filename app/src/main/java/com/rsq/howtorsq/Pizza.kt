package com.rsq.howtorsq

import java.io.Serializable

data class Pizza(
        var name: String,
        var price: Int,
        var ingredients: String
): Serializable