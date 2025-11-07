package com.dennymathew.roomproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dennymathew.roomproject.db.entity.EntityId
import com.dennymathew.roomproject.db.entity.EntityScope
import com.dennymathew.roomproject.db.entity.SampleEntity

@Dao
abstract class SampleDao : EntityDao<EntityScope.Company, SampleEntity>(
    tableName = SampleEntity.TABLE_NAME
) {

    @Query("SELECT * FROM ${SampleEntity.TABLE_NAME} WHERE local_id = :localId")
    abstract suspend fun readSampleEntity(localId: Long): SampleEntity

    suspend fun upsertSampleEntity(
        entity: SampleEntity,
    ): EntityId {
        return upsertEntity(
            entity = entity,
            insertAction = ::insertOrIgnoreSampleEntity,
            updateAction = ::updateOrAbortSampleEntity,
        )
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = SampleEntity::class)
    protected abstract fun insertOrIgnoreSampleEntity(sampleEntity: SampleEntity): Long

    @Update(entity = SampleEntity::class)
    protected abstract fun updateOrAbortSampleEntity(sampleEntity: SampleEntity): Int
}
