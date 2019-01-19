package com.schs.travelapp.activity

import android.content.ClipData
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.schs.travelapp.R
import com.schs.travelapp.model.Route
import com.schs.travelapp.model.User
import kotlinx.android.synthetic.main.activity_routes.*

class RoutesActivity : AppCompatActivity() {

    val user = User("username", "password")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routes)
        setSupportActionBar(routes_toolbar)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(getRoutesData())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.routes_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_route -> {
                val intent = Intent(this, AddRouteActivity::class.java)
                startActivityForResult(intent, 1)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null)
            return

        val name: String = data.getStringExtra("name")
        val newRoute = Route(name)
        user.routes.add(newRoute)
        recyclerview.adapter?.notifyDataSetChanged()
    }

    private fun getRoutesData(): MutableList<Route> {
        return user.routes
    }

    class Adapter(private val routes: MutableList<Route>): RecyclerView.Adapter<Adapter.ViewHolder>(){

        override fun getItemCount() = routes.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView?.text = routes[position].routeName
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textView: TextView? = null
            init {
                textView = itemView.findViewById(R.id.text_list_item)
            }
        }
    }
}
