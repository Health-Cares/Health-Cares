package com.example.healthcare

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var listener:OnAddButtonClicked
    private lateinit var childButton:OnChildButtonClicked
    private lateinit var treatButton: OnTreatButtonClicked
    private lateinit var newsButton: OnNewsButtonClicked



    interface OnAddButtonClicked{
        fun onAddButtonClicked()
        fun onChildButtonClicked()
        fun onTreatButtonClicked()
        fun onNewsButtonClicked()
    }
//
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnAddButtonClicked){
            listener = context
        }
    }

    interface OnChildButtonClicked{
        fun onChildButtonClicked()
    }
    interface OnTreatButtonClicked{
        fun onTreatButtonCliked()
    }

    interface OnNewsButtonClicked {
        fun onNewsButtonClicked()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container , false);

        val addButton= view.add
        val childButton = view.child_button
        val treatButton = view.treat_button
        val newsButton = view.news_button


        addButton.setOnClickListener {
            listener.onAddButtonClicked()
        }
        childButton.setOnClickListener {
            listener.onChildButtonClicked()
        }
        treatButton.setOnClickListener {
            listener.onTreatButtonClicked()
        }
        newsButton.setOnClickListener {
            listener.onNewsButtonClicked()
        }


        return view
    }
}