package com.samedtemiz.subcatcher.data.repositories

import com.samedtemiz.subcatcher.data.local.database.dao.SubscriptionDao
import com.samedtemiz.subcatcher.data.mappers.SubscriptionMapper
import com.samedtemiz.subcatcher.domain.models.Subscription
import com.samedtemiz.subcatcher.domain.repositories.SubscriptionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Implementation of SubscriptionRepository
 * Handles data operations using Room database
 */
class SubscriptionRepositoryImpl @Inject constructor(
    private val subscriptionDao: SubscriptionDao
) : SubscriptionRepository {
    
    override fun getAllActiveSubscriptions(): Flow<List<Subscription>> {
        return subscriptionDao.getAllActiveSubscriptions()
            .map { entities -> entities.map { SubscriptionMapper.toDomain(it) } }
    }
    
    override fun getAllSubscriptions(): Flow<List<Subscription>> {
        return subscriptionDao.getAllSubscriptions()
            .map { entities -> entities.map { SubscriptionMapper.toDomain(it) } }
    }
    
    override suspend fun getSubscriptionById(id: Long): Subscription? {
        return subscriptionDao.getSubscriptionById(id)?.let { SubscriptionMapper.toDomain(it) }
    }
    
    override suspend fun searchSubscriptions(name: String): List<Subscription> {
        return subscriptionDao.searchSubscriptions(name)
            .map { SubscriptionMapper.toDomain(it) }
    }
    
    override fun getUpcomingSubscriptions(timestamp: Long): Flow<List<Subscription>> {
        return subscriptionDao.getUpcomingSubscriptions(timestamp)
            .map { entities -> entities.map { SubscriptionMapper.toDomain(it) } }
    }
    
    override suspend fun insertSubscription(subscription: Subscription): Long {
        return subscriptionDao.insertSubscription(SubscriptionMapper.toEntity(subscription))
    }
    
    override suspend fun insertSubscriptions(subscriptions: List<Subscription>) {
        subscriptionDao.insertSubscriptions(subscriptions.map { SubscriptionMapper.toEntity(it) })
    }
    
    override suspend fun updateSubscription(subscription: Subscription) {
        subscriptionDao.updateSubscription(SubscriptionMapper.toEntity(subscription))
    }
    
    override suspend fun deleteSubscription(subscription: Subscription) {
        subscriptionDao.deleteSubscription(SubscriptionMapper.toEntity(subscription))
    }
    
    override suspend fun deleteSubscriptionById(id: Long) {
        subscriptionDao.deleteSubscriptionById(id)
    }
    
    override suspend fun getActiveSubscriptionCount(): Int {
        return subscriptionDao.getActiveSubscriptionCount()
    }
}

