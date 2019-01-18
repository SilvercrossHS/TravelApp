package com.schs.travelapp.model

class User (username: String, password: String, userRoutes: List<Route>) {
    val name = username
    val location = password
    val routes = mutableListOf<Route>()

}