package com.samedtemiz.subcatcher.data.mappers

import com.samedtemiz.subcatcher.data.local.database.entities.SubscriptionEntity
import com.samedtemiz.subcatcher.domain.models.Subscription
import com.samedtemiz.subcatcher.domain.models.SubscriptionFrequency
import java.util.Date

/**
 * Mapper between SubscriptionEntity (data layer) and Subscription (domain layer)
 */
object SubscriptionMapper {
    
    fun toDomain(entity: SubscriptionEntity): Subscription {
        return Subscription(
            id = entity.id,
            name = entity.name,
            amount = entity.amount,
            currency = entity.currency,
            frequency = frequencyFromString(entity.frequency),
            nextPaymentDate = Date(entity.nextPaymentDate),
            category = entity.category,
            isActive = entity.isActive,
            createdAt = Date(entity.createdAt),
            updatedAt = Date(entity.updatedAt)
        )
    }
    
    fun toEntity(domain: Subscription): SubscriptionEntity {
        return SubscriptionEntity(
            id = domain.id,
            name = domain.name,
            amount = domain.amount,
            currency = domain.currency,
            frequency = domain.frequency.name,
            nextPaymentDate = domain.nextPaymentDate.time,
            category = domain.category,
            isActive = domain.isActive,
            createdAt = domain.createdAt.time,
            updatedAt = domain.updatedAt.time
        )
    }
    
    private fun frequencyFromString(frequency: String): SubscriptionFrequency {
        return try {
            SubscriptionFrequency.valueOf(frequency)
        } catch (e: IllegalArgumentException) {
            SubscriptionFrequency.MONTHLY // Default fallback
        }
    }
}

