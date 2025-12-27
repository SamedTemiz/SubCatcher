package com.samedtemiz.subcatcher.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.samedtemiz.subcatcher.data.local.database.dao.SubscriptionDao
import com.samedtemiz.subcatcher.data.local.database.entities.SubscriptionEntity

/**
 * Room database for SubCatcher application
 * Manages all local data storage
 */
@Database(
    entities = [SubscriptionEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun subscriptionDao(): SubscriptionDao
    
    companion object {
        const val DATABASE_NAME = "subcatcher_database"
    }
}

