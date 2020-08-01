package com.niww.lighttaskmanager.viewmodel

import androidx.lifecycle.ViewModel
import com.niww.lighttaskmanager.navigation.Screens
import ru.terrakok.cicerone.Router

class MainViewModel(val router: Router): ViewModel() {


    fun goToTaskListFragment(){
        router.replaceScreen(Screens.TaskListScreen())
    }

    fun goToChatFragment(){
        router.replaceScreen(Screens.ChatScreen())
    }

    fun goToProfileFragment(){
        router.replaceScreen(Screens.ProfileScreen())
    }


}