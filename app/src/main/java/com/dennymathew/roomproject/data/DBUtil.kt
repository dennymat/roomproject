package com.dennymathew.roomproject.data

import android.app.Application
import com.dennymathew.roomproject.MyDatabaseFactory
import com.dennymathew.roomproject.db.entity.EntityScope
import com.dennymathew.roomproject.db.entity.SampleEntity

object DBUtil {

    suspend fun insertEntry(application: Application, userServerId: String = "1") {
        val db = MyDatabaseFactory.getUserScopeDatabase(application = application, userServerId = userServerId)
        db.sampleDao.upsertSampleEntity(
            SampleEntity(
                localId = null,
                serverId = "1",
                name = "denny",
                scope = EntityScope.Company(
                    companyServerId = "1",
                )
            )
        )
    }
}