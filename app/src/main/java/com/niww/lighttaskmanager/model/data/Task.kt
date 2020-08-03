package com.niww.lighttaskmanager.model.data

import java.util.*

data class Task (
    val id: Int,
    val name: String,
    val employer: User,
    val implementer: User,
    val description: String,
    val dueDate: Date
)