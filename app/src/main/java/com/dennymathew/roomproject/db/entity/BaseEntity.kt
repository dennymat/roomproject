package com.dennymathew.roomproject.db.entity

import androidx.room.Embedded

abstract class BaseEntity(
    open var localId: Long?
) {

    internal object Column {
        const val LOCAL_ID = "local_id"
    }
}

sealed class ScopedEntity<Scope : EntityScope>(
    override var localId: Long?,
    @Embedded open var scope: Scope
) : BaseEntity(localId = localId) {
    internal object Column {
        const val LOCAL_ID = BaseEntity.Column.LOCAL_ID
    }
}

abstract class ServerScopedEntity<Scope : EntityScope>(
    override var localId: Long?,
    open var serverId: String?,
    @Embedded override var scope: Scope
) : ScopedEntity<Scope>(
    localId,
    scope
) {

    val requireServerId get() = serverId!!

    internal object Column {
        const val LOCAL_ID = ScopedEntity.Column.LOCAL_ID
        const val SERVER_ID = "server_id"
    }
}

abstract class ServerCompanyScopedEntity(
    override var localId: Long?,
    override var serverId: String?,
    override var scope: EntityScope.Company
) : ServerScopedEntity<EntityScope.Company>(
    localId = localId,
    serverId = serverId,
    scope = scope
)