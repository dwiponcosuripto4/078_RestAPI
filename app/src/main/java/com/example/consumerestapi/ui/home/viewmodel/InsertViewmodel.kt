package com.example.consumerestapi.ui.home.viewmodel

import com.example.consumerestapi.model.Kontak

data class InsertViewmodel(
    val id: Int = 0,
    val nama: String = 0,
    val alamat: String = "",
    val nohp : String = ""
)

fun InsertUiEvent.toKontak() : Kontak = Kontak(
    id = id,
    nama = nama,
    alamat = alamat,
    nohp = nohp,
)

data class InsertUiEvent(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

