package com.dennymathew.roomproject

import android.app.Application
import androidx.room.Room
import com.dennymathew.roomproject.db.MyDatabase

object MyDatabaseFactory {

    fun getUserScopeDatabase(application: Application, userServerId: String): MyDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            MyDatabase::class.java,
            "${MyDatabase.DB_NAME_PREFIX}$userServerId"

        ).build()
    }
}
