package com.example.jerafilmes.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jerafilmes.model.Filme1
import com.example.jerafilmes.repository.FilmesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmesViewModel: ViewModel() {



    private var filmesRepository : FilmesRepository = FilmesRepository()

    private val filmesList: MutableLiveData<List<Filme1>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch (Dispatchers.IO){
            filmesList.postValue(filmesRepository.getMovies())
        }
    }
    fun observeMovies(
        lifecycleOwner: LifecycleOwner,
        action: (List<Filme1>) -> Unit
    ) = filmesList.observe(lifecycleOwner, { action(it)})
}
