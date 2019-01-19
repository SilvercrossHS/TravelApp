package com.schs.travelapp.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.schs.travelapp.R
import kotlinx.android.synthetic.main.activity_add_route.*

class AddRouteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_route)
        setSupportActionBar(add_route_toolbar)
        val actionBar = supportActionBar

        val saveButton: Button = findViewById(R.id.save_button)
        val routeNameTextField: TextView = findViewById(R.id.routename_textfield)


        saveButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", routeNameTextField.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        actionBar!!.title = "Create new route"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
