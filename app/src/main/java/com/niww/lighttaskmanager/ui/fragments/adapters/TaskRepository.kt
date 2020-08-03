package com.niww.lighttaskmanager.ui.fragments.adapters

import com.niww.lighttaskmanager.model.data.Task
import com.niww.lighttaskmanager.model.data.User
import java.util.*

class TaskRepository {

    val list = mutableListOf<Task>(
        Task(1, "work 1", User("Вася"), User("Петрович"),"to do the job 1" , Date(2020, 8, 22)),
        Task(2, "work 2", User("Иван Иваныч"), User("Сан Саныч"),"to do the job 2" , Date(2020, 7, 20)),
        Task(3, "work 3", User("Витя"), User("Гоша"),"to do the job 3" , Date(2020, 8, 25)),
        Task(4, "work 4", User("Афонасий"), User("Элвис Пресли"),"to do the job 4" , Date(2020, 10, 20)),
        Task(5, "work 5", User("Аркадий"), User("Федя"),"to do the job 5" , Date(2020, 9, 27))
    )

    fun getEntity(pos:Int)=if(pos<=list.size-1)list[pos]else(null)


}