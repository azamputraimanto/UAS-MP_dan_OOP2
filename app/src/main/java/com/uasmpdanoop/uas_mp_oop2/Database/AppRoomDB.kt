package com.uasmpdanoop.uas_mp_oop2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Santri::class, Asatid::class), version = 1)

abstract class AppRoomDB : RoomDatabase() {

    abstract fun santriDao(): SantriDao
    abstract fun asatidDao(): AsatidDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK){
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppRoomDB::class.java,
            "APPDB"
        ).build()

    }
}


