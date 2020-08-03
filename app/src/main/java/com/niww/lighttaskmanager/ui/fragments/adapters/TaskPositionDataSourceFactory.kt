package com.niww.lighttaskmanager.ui.fragments.adapters

import androidx.paging.DataSource
import com.niww.lighttaskmanager.model.data.Task


class TaskPositionDataSourceFactory internal constructor(private val taskRepository: TaskRepository) : DataSource.Factory<Int, Task>() {

    override fun create(): DataSource<Int, Task> {
        return TaskDataSource(taskRepository)
    }
}

