package com.roberto.disfraces

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val productos = arrayOf("Disfraz 1", "Disfraz 2", "Disfraz 3", "Disfraz 4", "Disfraz 5")
        val lvProductos = findViewById<ListView>(R.id.lvProductos)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productos)
        lvProductos.adapter = adapter
    }
}
