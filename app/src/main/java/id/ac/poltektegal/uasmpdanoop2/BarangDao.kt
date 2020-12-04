package id.ac.poltektegal.uasmpdanoop2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BarangDao {
    @Query("SELECT * FROM barang")
    fun getAll(): List<Barang>

    @Query("SELECT * FROM barang WHERE kode IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Barang>

    @Query("SELECT * FROM barang WHERE namaBarang LIKE :namaBarang AND " +
            "jenis LIKE :jenis LIMIT 1")
    fun findByName(namaBarang: String, jenis: String, ukuran: String, harga: String): Barang

    @Insert
    fun insertAll(vararg barang: Barang)

    @Delete
    fun delete(barang: Barang)
}