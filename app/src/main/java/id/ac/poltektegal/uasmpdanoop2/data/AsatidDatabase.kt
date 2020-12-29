package id.ac.poltektegal.uasmpdanoop2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.poltektegal.uasmpdanoop2.model.Asatid

@Database(entities = [Asatid::class], version = 1, exportSchema = false)
abstract class AsatidDatabase : RoomDatabase() {

    abstract fun asatidDao(): AsatidDao

    companion object {
        @Volatile
        private var INSTANCE: AsatidDatabase? = null

        fun getDatabase(context: Context): AsatidDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AsatidDatabase::class.java,
                        "asatid_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}