package com.dennymathew.roomproject.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = SampleEntity.TABLE_NAME,
)
class SampleEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Column.LOCAL_ID) override var localId: Long?,
    @ColumnInfo(name = Column.SERVER_ID) override var serverId: String?,
    @Embedded override var scope: EntityScope.Company,
    @ColumnInfo(name = Column.NAME) val name: String,
) : ServerCompanyScopedEntity(
    localId = localId,
    serverId = serverId,
    scope = scope
) {

    companion object {
        internal const val TABLE_NAME = "Sample"
    }

    internal object Column {
        const val LOCAL_ID = ServerScopedEntity.Column.LOCAL_ID
        const val SERVER_ID = ServerScopedEntity.Column.SERVER_ID
        const val NAME = "name"
    }
}