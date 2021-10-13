package com.example.testforandroiddeveloper.fragments.listStrategiesFragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testforandroiddeveloper.R
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data.Item
import java.io.File


class DetailFragment : Fragment() {
    lateinit var title: TextView
    lateinit var image: ImageView
    lateinit var text: TextView
    lateinit var btn_add: Button
    var pref: SharedPreferences ?= null
    var id_choose = -9999

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_detail, container, false)

        title = root.findViewById(R.id.title)
        image = root.findViewById(R.id.image)
        text = root.findViewById(R.id.text)
        btn_add = root.findViewById(R.id.btn_add_list)

        image.setImageResource(Integer.parseInt(arguments?.getString("IMG").toString()))
        title.text = arguments?.getString("TITLE")
        text.text = arguments?.getString("TEXT")


        btn_add.setOnClickListener {
            pref = context?.getSharedPreferences("Strategies", MODE_PRIVATE)
            id_choose = arguments?.getInt("id")!!

            saveData(id_choose)
            Toast.makeText(context, "You added new strategy in your favorite list", Toast.LENGTH_LONG).show()
        }
        return root
    }

    fun saveData(res: Int){
        val editor = pref?.edit()
        editor?.putInt("id" + res, res)
        editor?.apply()
    }


    companion object {
        fun newInstance(text: Item) : DetailFragment {
            val detail = DetailFragment()
            val bundle = Bundle()
            bundle.putString("TITLE", text.title)
            bundle.putInt("id", text.id)
            bundle.putString("IMG", text.image.toString())
            bundle.putString("TEXT", text.text)
            detail.arguments = bundle
            return detail
        }
    }
}