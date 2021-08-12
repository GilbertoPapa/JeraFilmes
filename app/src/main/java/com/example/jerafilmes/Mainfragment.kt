package com.example.jerafilmes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jerafilmes.model.Filme1
import com.example.jerafilmes.viewmodel.FilmesViewModel

class MainFragment : Fragment() {

    private lateinit var mainActivityViewModel : FilmesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(FilmesViewModel::class.java)
        mainActivityViewModel.getMovies()
        mainActivityViewModel.observeMovies(this){handleMovies(it)}
    }

    private fun handleMovies(movies: List<Filme1>){
        rv_list?.layoutManager = GridLayoutManager(context,2)
        rv_list?.adapter = context?.let { Adapter_activity_dois(movies, it) }
    }

}