package com.example.myroom1_035.repository

import com.example.myroom1_035.room.Siswa
import com.example.myroom1_035.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}
