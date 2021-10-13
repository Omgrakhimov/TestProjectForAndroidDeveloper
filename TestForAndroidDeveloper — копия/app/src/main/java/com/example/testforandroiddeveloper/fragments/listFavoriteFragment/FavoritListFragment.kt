package com.example.testforandroiddeveloper.fragments.listFavoriteFragment

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testforandroiddeveloper.R
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.JurAdapter
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.OnItemClickListener
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data.DataStorage
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data.Item


class FavoritListFragment : Fragment(), OnItemClickListener {

    lateinit var btn_del: Button
    var pref: SharedPreferences?= null
    var adapter: JurAdapter ?= null
    var resList: MutableList<Item> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_favorit_list, container, false)
        pref = context?.getSharedPreferences("Strategies", Context.MODE_PRIVATE)

        val listFavId = pref?.all as MutableMap<String, Int>?


        val data = DataStorage()
        val list = data.getList()

        for(item in list){
            if (listFavId != null) {
                for(id_item in listFavId!!){
                    if(item.id == id_item.value) {
                        if(!resList.contains(item))
                            resList.add(item)
                    }
                }
            }
        }
        val rv = root.findViewById<RecyclerView>(R.id.my_recycler_view2)
        rv.layoutManager = LinearLayoutManager(this.context)
        rv.adapter = JurAdapter( context, this)
        rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        adapter = rv.adapter as JurAdapter
        adapter!!.submitList(resList)
        return root
    }


    override fun click(item: Item, position: Int) {
        val alertDialog = AlertDialog.Builder(this.context)
        alertDialog.setTitle("Message")
        alertDialog.setMessage("Are you sure to delete this strategy in your favorite list?")
        alertDialog.setPositiveButton("YES"){dialog, id ->
            pref?.edit()?.remove("id" + item.id)?.apply()
            resList.remove(item)
            adapter!!.notifyDataSetChanged()
            Toast.makeText(context, "You deleted this strategy", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton("NO"){dialog, id ->
            Toast.makeText(context, "You not deleted this strategy", Toast.LENGTH_LONG).show()
        }
        alertDialog.show()

    }


}