package com.example.movieapp_try1.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDao {

    @Upsert
    suspend fun upsertAll(result: List<ResultsEntity>)


    @Query("SELECT * FROM resultsentity")
    fun pagingSource():PagingSource<Int, ResultsEntity>

    @Query("DELETE FROM resultsentity")
    suspend fun clearAll()
}