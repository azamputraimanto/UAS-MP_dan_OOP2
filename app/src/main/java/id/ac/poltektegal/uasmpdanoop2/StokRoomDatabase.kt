package id.ac.poltektegal.uasmpdanoop2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Stok::class), version = 1)
abstract class StokRoomDatabase : RoomDatabase() {
    abstract fun StokDao(): StokDao

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
        applicationContext,
        StokRoomDatabase::class.java, "DBCS"
    ).build()

}