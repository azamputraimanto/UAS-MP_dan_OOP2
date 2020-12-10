package id.ac.poltektegal.uasmpdanoop2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.poltektegal.uasmpdanoop2.model.Santri

@Database(entities = [Santri::class], version = 1, exportSchema = false)
abstract class SantriDatabase : RoomDatabase() {

    abstract fun santriDao(): SantriDao

    companion object {
        @Volatile
        private var INSTANCE: SantriDatabase? = null

        fun getDatabase(context: Context): SantriDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SantriDatabase::class.java,
                    "santri_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}