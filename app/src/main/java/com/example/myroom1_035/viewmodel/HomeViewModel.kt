package com.example.myroom1_035.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myroom1_035.repository.RepositoriSiswa
import com.example.myroom1_035.room.Siswa
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

    // Perbaikan: StatwFlow menjadi StateFlow, filterNotNull dikoreksi, import flow ditambahkan
    val homeUIState: StateFlow<HomeUIState> = repositoriSiswa.getAllSiswaStream()
        .filterNotNull()
        .map { HomeUIState(listSiswa = it.toList())}
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIState()
        )

    data class HomeUIState(
        // Perbaikan: listO() menjadi listOf()
        val listSiswa : List<Siswa> = listOf()
    )
}