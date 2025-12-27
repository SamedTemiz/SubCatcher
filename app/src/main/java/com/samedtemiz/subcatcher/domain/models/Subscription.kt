package com.samedtemiz.subcatcher.domain.models

import java.util.Date

/**
 * Domain model for Subscription
 * Represents a subscription in the business logic layer
 */
data class Subscription(
    val id: Long = 0,
    val name: String,
    val amount: Double,
    val currency: String,
    val frequency: SubscriptionFrequency,
    val nextPaymentDate: Date,
    val category: String? = null,
    val isActive: Boolean = true,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

enum class SubscriptionFrequency {
    MONTHLY,
    YEARLY,
    WEEKLY,
    QUARTERLY,
    ANNUAL
}

