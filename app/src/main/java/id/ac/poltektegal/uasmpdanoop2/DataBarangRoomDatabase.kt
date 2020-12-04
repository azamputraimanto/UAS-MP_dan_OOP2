package id.ac.poltektegal.uasmpdanoop2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Barang::class), version = 1)
abstract class DataBarangRoomDatabase : RoomDatabase() {
    abstract fun BarangDao(): BarangDao

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
        applicationContext,
        DataBarangRoomDatabase::class.java, "DBCS"
    ).build()

}