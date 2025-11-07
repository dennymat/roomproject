package com.dennymathew.roomproject

interface TransactionalDatabase {

    suspend fun <R> inTransaction(action: suspend () -> R) : R
}