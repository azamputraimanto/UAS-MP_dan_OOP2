package id.ac.poltektegal.uasmpdanoop2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.poltektegal.uasmpdanoop2.model.Asatid

@Dao
interface AsatidDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAsatid(asatid: Asatid)

    @Update
    suspend fun updateAsatid(asatid: Asatid)

    @Delete
    suspend fun deleteAsatid(asatid: Asatid)

    @Query("DELETE FROM asatid")
    suspend fun deleteAllAsatids()

    @Query("SELECT * FROM asatid ORDER BY id ASC")
    fun readAllData(): LiveData<List<Asatid>>
}