package com.samedtemiz.subcatcher.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Room entity for Subscription
 * Represents subscription data in the database layer
 */
@Entity(tableName = "subscriptions")
data class SubscriptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val amount: Double,
    val currency: String,
    val frequency: String, // MONTHLY, YEARLY, etc.
    val nextPaymentDate: Long, // Stored as timestamp
    val category: String? = null,
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

