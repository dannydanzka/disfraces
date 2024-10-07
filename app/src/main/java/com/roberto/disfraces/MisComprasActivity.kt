package com.roberto.disfraces

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MisComprasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_compras)

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvDomicilio = findViewById<TextView>(R.id.tvDomicilio)
        val tvProducto = findViewById<TextView>(R.id.tvProducto)
        val tvTalla = findViewById<TextView>(R.id.tvTalla)
        val tvTelefono = findViewById<TextView>(R.id.tvTelefono)
        val btnEliminarCompra = findViewById<Button>(R.id.btnEliminarCompra)

        val sharedPreferences = getSharedPreferences("PedidosPrefs", Context.MODE_PRIVATE)

        val nombre = sharedPreferences.getString("nombre", "No hay datos registrados")
        val domicilio = sharedPreferences.getString("domicilio", "No hay datos registrados")
        val producto = sharedPreferences.getString("producto", "No hay datos registrados")
        val talla = sharedPreferences.getString("talla", "No hay datos registrados")
        val telefono = sharedPreferences.getString("telefono", "No hay datos registrados")

        tvNombre.text = "Nombre: $nombre"
        tvDomicilio.text = "Domicilio: $domicilio"
        tvProducto.text = "Producto: $producto"
        tvTalla.text = "Talla: $talla"
        tvTelefono.text = "Teléfono: $telefono"

        btnEliminarCompra.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            Toast.makeText(this, "Compra eliminada", Toast.LENGTH_SHORT).show()

            tvNombre.text = "Nombre: No hay datos registrados"
            tvDomicilio.text = "Domicilio: No hay datos registrados"
            tvProducto.text = "Producto: No hay datos registrados"
            tvTalla.text = "Talla: No hay datos registrados"
            tvTelefono.text = "Teléfono: No hay datos registrados"
        }
    }
}
