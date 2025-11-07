package com.dennymathew.roomproject.db.dao

import com.dennymathew.roomproject.db.entity.EntityId
import com.dennymathew.roomproject.db.entity.EntityScope
import com.dennymathew.roomproject.db.entity.ServerScopedEntity

abstract class EntityDao<Scope : EntityScope, Entity : ServerScopedEntity<Scope>>(
    tableName: String
) : BaseEntityUpsertDao(tableName), UtilDao<Entity> {

    protected suspend fun upsertEntity(
        entity: Entity,
        insertAction: suspend (Entity) -> Long = { item -> insertOrIgnore(item) },
        updateAction: suspend (Entity) -> Int = { item -> updateOrAbort(item) }
    ): EntityId = upsertInternal(
        entity = entity,
        insertOrIgnoreAction = insertAction,
        updateAction = updateAction
    )
}