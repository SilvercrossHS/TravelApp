package com.schs.travelapp.model

class User (username: String, password: String, userRoutes: Array<Route>) {
    val name = username
    val location = password
    val routes = userRoutes
}