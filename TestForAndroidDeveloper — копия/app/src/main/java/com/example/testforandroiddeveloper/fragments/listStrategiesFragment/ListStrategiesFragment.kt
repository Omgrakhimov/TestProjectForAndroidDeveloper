package com.example.testforandroiddeveloper.fragments.listStrategiesFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.testforandroiddeveloper.R
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data.DataStorage
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data.Item


class ListStrategiesFragment : Fragment(), OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_list_strategies, container, false)
        val data = DataStorage()
        val list = data.getList()
        val rv = root.findViewById<RecyclerView>(R.id.my_recycler_view)
        rv.adapter = JurAdapter( context, this)
        rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        val adapter = rv.adapter as JurAdapter
        adapter.submitList(list)
        return root
    }

    override fun click(item: Item, position: Int) {
        val newFragment = DetailFragment.newInstance(item)
        (activity as FragmentActivity).supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, newFragment)
            .commit()
    }

}