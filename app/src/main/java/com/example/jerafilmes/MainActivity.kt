package com.example.jerafilmes

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jerafilmes.data.FilmeRemote
import com.example.jerafilmes.data.network.FilmeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var filmeName: TextView
    lateinit var filmeName3: TextView
    lateinit var filmeName2: TextView

    lateinit var imagefilme: ImageView

    // lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //     filmeName = findViewById(R.id.filmename)
        //       filmeName2 = findViewById(R.id.filmename2)
        //      filmeName3 = findViewById(R.id.filmename3)
        //      filmeContainer = findViewById(R.id.filmecontainer)
        //      imagefilme = findViewById(R.id.imagefilme)

        //   binding = ActivityMainBinding.inflate(layoutInflater)
        //    setContentView(binding.root)
        //    val recycler = binding.ItemRecyclerView
        //    val adapter = FilmeAdapter()
        //   adapter.filmeItems = FilmeApi(this)
        //   recycler.adapter =adapter

        getFilme()

        RecyclerView.RecyclerListener {
            getFilme()
        }
    }

    private fun getFilme() {
        lifecycleScope.launch {
            try {
                val response = requestFilme()
                val filme = response.production_companies.random()
                val filme1 = response.poster_path.random()
                filmeName?.text = filme.origin_country
                filmeName2?.text = filme.name
                filmeName3?.text = filme.id.toString()
                Glide.with(this@MainActivity)
                    .load(filme.logo_path)
                    .into(imagefilme)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private suspend fun requestFilme(): FilmeRemote {

        return withContext(Dispatchers.IO) {
            FilmeService.service.getFilmes()
        }
    }
}
