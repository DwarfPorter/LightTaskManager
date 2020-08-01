package com.niww.lighttaskmanager.di


import com.niww.lighttaskmanager.viewmodel.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val application = module {
    single<Cicerone<Router>>{ Cicerone.create() }
    single <NavigatorHolder>{ get<Cicerone<Router>>().navigatorHolder }
    single <Router>{ get<Cicerone<Router>>().router }

}

val mainScreen = module {
    factory { MainViewModel(get()) }
}
