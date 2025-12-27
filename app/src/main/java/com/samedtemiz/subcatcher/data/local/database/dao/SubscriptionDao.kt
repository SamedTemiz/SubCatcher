package com.samedtemiz.subcatcher.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.samedtemiz.subcatcher.data.local.database.entities.SubscriptionEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Subscription operations
 */
@Dao
interface SubscriptionDao {
    
    @Query("SELECT * FROM subscriptions WHERE isActive = 1 ORDER BY nextPaymentDate ASC")
    fun getAllActiveSubscriptions(): Flow<List<SubscriptionEntity>>
    
    @Query("SELECT * FROM subscriptions ORDER BY nextPaymentDate ASC")
    fun getAllSubscriptions(): Flow<List<SubscriptionEntity>>
    
    @Query("SELECT * FROM subscriptions WHERE id = :id")
    suspend fun getSubscriptionById(id: Long): SubscriptionEntity?
    
    @Query("SELECT * FROM subscriptions WHERE name LIKE :name")
    suspend fun searchSubscriptions(name: String): List<SubscriptionEntity>
    
    @Query("SELECT * FROM subscriptions WHERE nextPaymentDate <= :timestamp AND isActive = 1")
    fun getUpcomingSubscriptions(timestamp: Long): Flow<List<SubscriptionEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubscription(subscription: SubscriptionEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubscriptions(subscriptions: List<SubscriptionEntity>)
    
    @Update
    suspend fun updateSubscription(subscription: SubscriptionEntity)
    
    @Delete
    suspend fun deleteSubscription(subscription: SubscriptionEntity)
    
    @Query("DELETE FROM subscriptions WHERE id = :id")
    suspend fun deleteSubscriptionById(id: Long)
    
    @Query("SELECT COUNT(*) FROM subscriptions WHERE isActive = 1")
    suspend fun getActiveSubscriptionCount(): Int
}

