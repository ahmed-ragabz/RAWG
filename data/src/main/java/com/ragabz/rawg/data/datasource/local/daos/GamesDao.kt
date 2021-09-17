package com.ragabz.rawg.data.datasource.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ragabz.rawg.data.datasource.local.entities.GameEntity

@Dao
interface GamesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllGames(gamesList: List<GameEntity>)

    @Query("select * from GameEntity")
    suspend fun selectAll(): List<GameEntity>
}