package com.niww.lighttaskmanager.ui.main

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.niww.lighttaskmanager.R
import com.niww.lighttaskmanager.viewmodel.MainViewModel
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    val navigator = SupportAppNavigator(this, R.id.fragment_container)

    lateinit var model: MainViewModel
    val navigatorHolder: NavigatorHolder by lazy { get<NavigatorHolder>()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniViewModel()

        val navView: BottomNavigationView = findViewById(R.id.navigation_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }


    val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener=
        BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_profile->{model.goToProfileFragment()
                    return@OnNavigationItemSelectedListener true}
                R.id.navigation_chat->{model.goToChatFragment()
                    return@OnNavigationItemSelectedListener true}
                R.id.navigation_task_list->{model.goToTaskListFragment()
                    return@OnNavigationItemSelectedListener true}
                else -> return@OnNavigationItemSelectedListener true
            }

        }

    private fun iniViewModel() {

        val viewModel: MainViewModel by viewModel()
        model =viewModel
        model.goToTaskListFragment()

    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}