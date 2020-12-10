package id.ac.poltektegal.uasmpdanoop2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.poltektegal.uasmpdanoop2.model.Santri

@Dao
interface SantriDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSantri(santri: Santri)

    @Update
    suspend fun updateSantri(santri: Santri)

    @Delete
    suspend fun deleteSantri(santri: Santri)

    @Query("DELETE FROM santri")
    suspend fun deleteAllSantris()

    @Query("SELECT * FROM santri ORDER BY id ASC")
    fun readAllData(): LiveData<List<Santri>>

}