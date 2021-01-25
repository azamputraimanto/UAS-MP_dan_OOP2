package com.uasmpdanoop.uas_mp_oop2.Database

import androidx.room.*

@Dao
interface AsatidDao {
    @Insert
    suspend fun addAsatid(asatid: Asatid)

    @Update
    suspend fun updateAsatid(asatid: Asatid)

    @Delete
    suspend fun deleteAsatid(asatid: Asatid)

    @Query("SELECT * FROM asatid")
    suspend fun getAllAsatid(): List<Asatid>

    @Query("SELECT * FROM asatid WHERE id=:asatid_id")
    suspend fun getAsatid(asatid_id: Int) : List<Asatid>
}

