package com.daviddam.recyclerviewsdavidgelma

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.daviddam.recyclerviewsdavidgelma.databinding.ActivityDetallsProductesBinding


class DetallsProductesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetallsProductesBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val producte = intent.getSerializableExtra(EXTRA_PRODUCTE) as? Producte
        producte?.let {
            binding.ivProducteDetalls.setImageResource(it.imagenResId)
            binding.tvNom.text = it.nom
            binding.tvPreu.text = String.format("€%.2f", it.preu)
        }
    }

    companion object {
        const val EXTRA_PRODUCTE = "extra_producte"
    }
}
