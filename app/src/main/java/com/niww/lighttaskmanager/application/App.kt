package com.niww.lighttaskmanager.application

import android.app.Application
import com.niww.lighttaskmanager.di.application
import com.niww.lighttaskmanager.di.mainScreen
import org.koin.core.context.startKoin
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(application, mainScreen))
        }

    }


}