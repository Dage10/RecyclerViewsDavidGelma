package com.daviddam.recyclerviewsdavidgelma

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.daviddam.recyclerviewsdavidgelma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Lista de productos
        val productList = arrayListOf(
            Producte("Camiseta", 19.99,R.drawable.camiseta),
            Producte("Pantaló", 39.5,R.drawable.pantalo),
            Producte("Gorra", 12.0,R.drawable.gorra),
            Producte("Zapatilles", 79.99,R.drawable.zapatilles),
            Producte("Samarreta", 49.9,R.drawable.samarreta)
        )

        //Configurar RecyclerView
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.setHasFixedSize(true)

        //Crear adapter
        val adapter = ProducteAdapter(productList)
        binding.rvProducts.adapter = adapter

        //Listener de clicks
        adapter.setOnClickListener(object : ProducteAdapter.OnClickListener {
            override fun onClick(position: Int, producte: Producte) {
                // Ejemplo sencillo: Toast
                Toast.makeText(this@MainActivity, "Producto: ${producte.nom} — ${String.format("€%.2f", producte.preu)}", Toast.LENGTH_SHORT).show()

                // Opcional: abrir Activity de detalles
                val intent = Intent(this@MainActivity, DetallsProductesActivity::class.java)
                intent.putExtra(DetallsProductesActivity.EXTRA_PRODUCTE, producte)
                startActivity(intent)
            }
        })

    }
}
