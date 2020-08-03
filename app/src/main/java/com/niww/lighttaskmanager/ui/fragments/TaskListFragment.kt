package com.niww.lighttaskmanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.niww.lighttaskmanager.R
import com.niww.lighttaskmanager.ui.fragments.adapters.TaskDataSource
import com.niww.lighttaskmanager.ui.fragments.adapters.TaskListPagingAdapter
import com.niww.lighttaskmanager.ui.fragments.adapters.TaskPositionDataSourceFactory
import com.niww.lighttaskmanager.ui.fragments.adapters.TaskRepository
import kotlinx.android.synthetic.main.fragment_task_list.*
import java.util.concurrent.Executors


class TaskListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(context, R.layout.fragment_task_list,  null)

                return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    fun initRecycler(){

        task_list_recyclerView.layoutManager= LinearLayoutManager(context)

        val adapter = TaskListPagingAdapter()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(5)
            .setInitialLoadSizeHint(8)
            .setPrefetchDistance(4)
            .build()

        val executor = Executors.newSingleThreadExecutor();

        val repo = TaskRepository()
        val dataSource = TaskDataSource(repo)

        val factory = TaskPositionDataSourceFactory(repo)


        val pagedListLiveData = LivePagedListBuilder(factory, config).setFetchExecutor(executor).build().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        task_list_recyclerView.adapter=adapter
    }

    companion object{

    fun newInstance():Fragment{

        return TaskListFragment()
    }
}



}