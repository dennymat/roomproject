package com.dennymathew.roomproject.db

import com.dennymathew.roomproject.TransactionalDatabase
import com.dennymathew.roomproject.db.dao.SampleDao

interface UserScopedDatabase : TransactionalDatabase {

    val sampleDao: SampleDao
}