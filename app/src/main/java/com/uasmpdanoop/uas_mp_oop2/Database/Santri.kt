package com.uasmpdanoop.uas_mp_oop2.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "santri")
data class Santri(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nomer_induk") val nomer_induk: Int,
    @ColumnInfo(name = "nama") val nama: String,
    @ColumnInfo(name = "kelas") val kelas: String,
    @ColumnInfo(name = "tahun_masuk") val tahun_masuk: Int,
    @ColumnInfo(name = "alamat") val alamat: String
)

