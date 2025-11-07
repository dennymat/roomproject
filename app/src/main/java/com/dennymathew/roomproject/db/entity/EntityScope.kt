package com.dennymathew.roomproject.db.entity

import androidx.room.ColumnInfo

sealed class EntityScope {

    companion object Column {
        const val COMPANY_SERVER_ID = "company_server_id"
    }

    data class Company(
        @ColumnInfo(name = COMPANY_SERVER_ID) val companyServerId: String
    ) : EntityScope()
}