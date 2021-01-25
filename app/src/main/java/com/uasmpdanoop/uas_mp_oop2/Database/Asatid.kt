package com.uasmpdanoop.uas_mp_oop2.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asatid")
data class Asatid(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "kode_asatid") val kode_asatid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "alumni") val alumni: String,
    @ColumnInfo(name = "tahun_lulus") val tahun_lulus: Int
)
