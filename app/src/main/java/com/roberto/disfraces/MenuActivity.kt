package com.roberto.disfraces

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Vinculamos la Toolbar desde el XML
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemPedido -> startActivity(Intent(this, PedidoActivity::class.java))
            R.id.itemProductos -> startActivity(Intent(this, ProductosActivity::class.java))
            R.id.itemMisCompras -> startActivity(Intent(this, MisComprasActivity::class.java))
            R.id.itemNosotros -> startActivity(Intent(this, NosotrosActivity::class.java))
            R.id.itemCerrarSesion -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
