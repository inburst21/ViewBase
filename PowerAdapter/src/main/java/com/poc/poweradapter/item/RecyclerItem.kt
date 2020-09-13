package com.poc.poweradapter.item

import kotlin.random.Random

interface RecyclerItem {
    fun getId(): Long = Random.nextLong(Long.MAX_VALUE - 1)
    fun renderKey(): String
}