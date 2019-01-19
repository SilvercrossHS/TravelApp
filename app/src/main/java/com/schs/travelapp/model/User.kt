package com.schs.travelapp.model

class User (val username: String, val password: String) {
    val routes: MutableList<Route>

    init {
        routes = mutableListOf<Route>()
    }

    fun addNewRoute(routeName: String) {
        val newRoute = Route(routeName)
        routes.add(newRoute)
    }
}