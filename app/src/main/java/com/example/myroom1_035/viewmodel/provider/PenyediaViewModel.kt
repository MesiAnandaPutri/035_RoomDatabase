package com.example.myroom1_035.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myroom1_035.repository.AplikasiSiswa
import com.example.myroom1_035.viewmodel.DetailViewModel
import com.example.myroom1_035.viewmodel.EditViewModel
import com.example.myroom1_035.viewmodel.EntryViewModel
import com.example.myroom1_035.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            DetailViewModel(savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EditViewModel(savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa)
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory
        .APPLICATION_KEY] as AplikasiSiswa)