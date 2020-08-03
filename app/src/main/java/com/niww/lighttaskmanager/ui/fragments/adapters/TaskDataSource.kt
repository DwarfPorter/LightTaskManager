package com.niww.lighttaskmanager.ui.fragments.adapters

import androidx.paging.PositionalDataSource
import com.niww.lighttaskmanager.model.data.Task

class TaskDataSource(val repo:TaskRepository): PositionalDataSource<Task>() {

    var last:Task? =null

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Task>) {

        Thread.sleep(3000)
        println("запрос дополнительных данных ; позиция начальная = " + params.startPosition + " ; кол-во = " + params.loadSize)

        val startPosition = params.startPosition
        val loadSize = params.loadSize


        val list = mutableListOf<Task>()



        for(i in startPosition..(startPosition+loadSize-1)){

            println("Entity передано из repo  "+ repo.getEntity(i))
            repo.getEntity(i)?.let{
                list+=it
                last = it
            }?:(last?.let{
                list+=it
                println(" list + last Entity; id = " + last!!.id)
            })

        }

        println("list  =  " +list)

        callback.onResult(list)

    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Task>) {
        val startPosition = params.requestedStartPosition
        val loadSize = params.requestedLoadSize
        val pageSize =params.pageSize

        Thread.sleep(3000)

        val list = mutableListOf<Task>()

        for(i in startPosition..(startPosition+loadSize-1)){

            repo.getEntity(i)?.let{
                list+=it
            }
            println("Entity передано из repo  "+ repo.getEntity(i))
        }
        val realPos = startPosition

        callback.onResult(list,startPosition)
    }
}