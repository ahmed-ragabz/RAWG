package com.ragabz.rawg.data.datasource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ragabz.rawg.data.datasource.local.daos.GamesDao
import com.ragabz.rawg.data.datasource.local.entities.GameEntity
import java.util.concurrent.Executors

@Database(
    entities = arrayOf(
        GameEntity::class,
    ), version = 3, exportSchema = false
)
abstract class RawgDataBase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "rawg_db"

        @Volatile
        private var INSTANCE: RawgDataBase? = null

        fun instance(context: Context): RawgDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, RawgDataBase::class.java, DB_NAME)
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadScheduledExecutor().execute(Runnable() {})
                    }
                }).build()
    }

    abstract fun gamesDao(): GamesDao
}