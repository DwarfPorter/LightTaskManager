package com.niww.lighttaskmanager.navigation


import com.niww.lighttaskmanager.ui.fragments.ChatFragment
import com.niww.lighttaskmanager.ui.fragments.ProfileFragment
import com.niww.lighttaskmanager.ui.fragments.TaskListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class TaskListScreen() : SupportAppScreen() {
        override fun getFragment() = TaskListFragment.newInstance()
    }

    class ChatScreen() : SupportAppScreen() {
        override fun getFragment() = ChatFragment.newInstance()
    }

    class ProfileScreen() : SupportAppScreen() {
        override fun getFragment() = ProfileFragment.newInstance()
    }

}