package com.dennymathew.roomproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.withTransaction
import com.dennymathew.roomproject.db.entity.SampleEntity

@Database(
    entities = [
        SampleEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class MyDatabase : RoomDatabase(), UserScopedDatabase {

    companion object {
        const val DB_NAME_PREFIX = "my_db_user_database_"
    }

    override suspend fun <R> inTransaction(action: suspend () -> R): R = withTransaction(action)
}