package com.roberto.disfraces

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etDomicilio = findViewById<EditText>(R.id.etDomicilio)
        val spProducto = findViewById<Spinner>(R.id.spProducto)
        val spTalla = findViewById<Spinner>(R.id.spTalla)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        val productos = arrayOf("Disfraz 1", "Disfraz 2", "Disfraz 3", "Disfraz 4", "Disfraz 5")
        val tallas = arrayOf("Chico", "Mediano", "Grande")

        spProducto.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, productos)
        spTalla.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tallas)

        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val domicilio = etDomicilio.text.toString().trim()
            val producto = spProducto.selectedItem.toString()
            val talla = spTalla.selectedItem.toString()
            val telefono = etTelefono.text.toString().trim()

            if (nombre.isEmpty() || domicilio.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("PedidosPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                editor.putString("nombre", nombre)
                editor.putString("domicilio", domicilio)
                editor.putString("producto", producto)
                editor.putString("talla", talla)
                editor.putString("telefono", telefono)
                editor.apply()

                Toast.makeText(this, "Pedido registrado exitosamente", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }
}
