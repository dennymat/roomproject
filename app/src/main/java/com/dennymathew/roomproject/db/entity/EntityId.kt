package com.dennymathew.roomproject.db.entity

import androidx.room.ColumnInfo

data class EntityId(
    @ColumnInfo(name = ServerScopedEntity.Column.LOCAL_ID) val localId: Long,
    @ColumnInfo(name = ServerScopedEntity.Column.SERVER_ID) val serverId: String?
)