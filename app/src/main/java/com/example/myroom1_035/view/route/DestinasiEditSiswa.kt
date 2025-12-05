package com.example.myroom1_035.view.route

import com.example.myroom1_035.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idsiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}