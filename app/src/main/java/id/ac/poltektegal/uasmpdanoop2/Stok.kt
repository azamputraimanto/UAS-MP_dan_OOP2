package id.ac.poltektegal.uasmpdanoop2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stok")
data class Stok(
    @PrimaryKey val kode: Int,
    @ColumnInfo(name = "kodeBarang") val kodeBarang: Int?,
    @ColumnInfo(name = "namaBarang") val namaBarang: String?,
    @ColumnInfo(name = "jumlahStok") val jumlahStok: Int?
)