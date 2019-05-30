package com.example.healthcare

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

//    private lateinit var listener:OnAddButtonClicked
//
//
//
//    interface OnAddButtonClicked{
//        fun onAddButtonClicked()
//    }
//
//    override fun onAttach(context: Context?) {
//        super.onAttach(context)
//        if (context is OnAddButtonClicked){
//            listener = context
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container , false);

//        val addButton= view.add
//
//        addButton.setOnClickListener {
//            listener.onAddButtonClicked()
//        }


        return view
    }
}