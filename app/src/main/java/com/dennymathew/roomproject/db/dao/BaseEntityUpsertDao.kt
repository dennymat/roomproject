package com.dennymathew.roomproject.db.dao

import androidx.room.Transaction
import com.dennymathew.roomproject.db.entity.EntityId
import com.dennymathew.roomproject.db.entity.EntityScope
import com.dennymathew.roomproject.db.entity.ServerScopedEntity

abstract class BaseEntityUpsertDao(
    protected val tableName: String,
) {

    @Transaction
    protected open suspend fun <Entity : ServerScopedEntity<Scope>, Scope : EntityScope> upsertInternal(
        entity: Entity,
        insertOrIgnoreAction: suspend (Entity) -> Long,
        updateAction: suspend (Entity) -> Int
    ): EntityId {
        return upsertByServerIdInternal(
            entity = entity,
            updateAction = updateAction,
            insertOrIgnore = insertOrIgnoreAction
        )
    }

    @Transaction
    protected open suspend fun <Entity : ServerScopedEntity<Scope>, Scope : EntityScope> upsertByServerIdInternal(
        entity: Entity,
        updateAction: suspend (Entity) -> Int,
        insertOrIgnore: suspend (Entity) -> Long
    ): EntityId {

        val inserted = insertOrIgnore(entity)

        // removed update logic..

        return EntityId(
            serverId = entity.requireServerId,
            localId = inserted
        )
    }
}
