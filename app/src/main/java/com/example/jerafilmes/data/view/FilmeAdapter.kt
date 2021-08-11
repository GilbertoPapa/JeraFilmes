package com.example.jerafilmes.data.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jerafilmes.R
import com.example.jerafilmes.data.ProductionCompany

class FilmeAdapter:RecyclerView.Adapter<FilmeAdapter.FilmeItemViewHolder>() {

    var filmeItems = listOf<ProductionCompany>()
    inner class FilmeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleContainer: TextView = itemView.findViewById<TextView>(R.id.imagefilme)
        private val descriptionContainer: TextView = itemView.findViewById(R.id.filmename)

        fun bind(filmeItem: ProductionCompany) {
            titleContainer.text = filmeItem.toString()
            descriptionContainer.text = filmeItem.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_dois,parent, false )

        return FilmeItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmeItemViewHolder, position: Int) {
        val filmeItem = filmeItems[position]
        holder.bind(filmeItem)
    }

    override fun getItemCount(): Int {
        return filmeItems.size
    }
}