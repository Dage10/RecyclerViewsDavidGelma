package com.daviddam.recyclerviewsdavidgelma

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daviddam.recyclerviewsdavidgelma.databinding.ItemsProductesBinding

class ProducteAdapter(
    private val items: List<Producte>
) : RecyclerView.Adapter<ProducteAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsProductesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producte = items[position]
        holder.binding.tvProducteNom.text = producte.nom
        holder.binding.tvProductePreu.text = String.format("€%.2f", producte.preu)
        holder.binding.ivProducte.setImageResource(producte.imagenResId)

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, producte)
        }
    }

    override fun getItemCount(): Int = items.size

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int, product: Producte)
    }

    class ViewHolder(val binding: ItemsProductesBinding) : RecyclerView.ViewHolder(binding.root)
}