package com.samedtemiz.subcatcher.domain.repositories

import com.samedtemiz.subcatcher.domain.models.Subscription
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for Subscription operations
 * Defines the contract for subscription data access
 */
interface SubscriptionRepository {
    
    fun getAllActiveSubscriptions(): Flow<List<Subscription>>
    
    fun getAllSubscriptions(): Flow<List<Subscription>>
    
    suspend fun getSubscriptionById(id: Long): Subscription?
    
    suspend fun searchSubscriptions(name: String): List<Subscription>
    
    fun getUpcomingSubscriptions(timestamp: Long): Flow<List<Subscription>>
    
    suspend fun insertSubscription(subscription: Subscription): Long
    
    suspend fun insertSubscriptions(subscriptions: List<Subscription>)
    
    suspend fun updateSubscription(subscription: Subscription)
    
    suspend fun deleteSubscription(subscription: Subscription)
    
    suspend fun deleteSubscriptionById(id: Long)
    
    suspend fun getActiveSubscriptionCount(): Int
}

