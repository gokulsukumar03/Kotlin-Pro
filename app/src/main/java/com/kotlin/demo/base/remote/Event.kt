package com.kotlin.demo.base.remote

open class Event


/**
 * Generic Loading Event
 */
object LoadingEvent : Event()

/**
 * Generic Success Event
 */
object SuccessEvent : Event()

/**
 * Generic Failed Event
 */
data class FailedEvent(val error: Throwable) : Event()
