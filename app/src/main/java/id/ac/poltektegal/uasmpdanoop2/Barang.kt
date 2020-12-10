package id.ac.poltektegal.uasmpdanoop2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class Barang(
    @PrimaryKey val kode: Int,
    @ColumnInfo(name = "namaBarang") val namaBarang: String?,
    @ColumnInfo(name = "jenis") val jenis: String?,
    @ColumnInfo(name = "ukuran") val ukuran: String?,
    @ColumnInfo(name = "hargaJual") val hargaJual: Int?
)