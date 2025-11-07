package com.dennymathew.roomproject.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface UtilDao<Entity> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnore(entity: Entity): Long

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateOrAbort(entity: Entity): Int
}