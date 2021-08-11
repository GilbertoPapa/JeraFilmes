package com.example.jerafilmes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jerafilmes.model.Filme1
import com.google.android.material.circularreveal.CircularRevealGridLayout
import com.squareup.picasso.Picasso

class Adapter_activity_dois (private val filme1: List<Filme1>, private val context: Context)
    : RecyclerView.Adapter<Adapter_activity_dois.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_dois,
            parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filme1.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(filme1[position].posterPath?.isNotEmpty())
            Picasso.get().load(BASE_URL_IMAGE+filme1[position].posterPath).into(holder.posterPath)
        holder.title.text = filme1[position].title
        holder.moviesView.setOnClickListener{
            val intent = Intent(context, LoginActivity ::class.java)
            intent.putExtra("extra_movie",filme1[position])
            holder.moviesView.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.filmename)
        val posterPath: ImageView = itemView.findViewById(R.id.imagefilme)
        val moviesView: CircularRevealGridLayout = itemView.findViewById(R.id.FilmesView)
    }

    companion object {
        const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original"
    }
}