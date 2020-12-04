package id.ac.poltektegal.uasmpdanoop2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StokDao {
    @Query("SELECT * FROM stok")
    fun getAll(): List<Stok>

    @Query("SELECT * FROM stok WHERE kodeBarang IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Stok>

    @Query("SELECT * FROM stok WHERE kodeBarang LIKE :kodeBarang AND " +
            "jumlahStok LIKE :jumlahStok LIMIT 1")
    fun findByName(kodeBarang: Int, namaBarang: String, jenis: String, jumlahStok: Int): Barang

    @Insert
    fun insertAll(vararg stok: Stok)

    @Delete
    fun delete(stok: Stok)
}