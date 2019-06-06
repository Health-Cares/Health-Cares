package com.example.healthcare

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_child.view.*

class ChildFragment : Fragment() {


    private lateinit var listener: OnOneImageButtonClicked
    private lateinit var sixImageButton: OneSixImageButtonCliked
    private lateinit var twelveImageButton: OneTwelveImageButtonCliked
    private lateinit var aboveImageButton: OneAboveImageButtonCliked

    interface OneAboveImageButtonCliked {
        fun onAboveImageButtonClicked()
    }

    interface OneTwelveImageButtonCliked {

        fun onTwelveImageButtonClicked()
    }
    interface OneSixImageButtonCliked {
        fun onSixImageButtonClicked()
    }


    interface OnOneImageButtonClicked {
        fun onOneImageButtonClicked()
        fun onSixImageButtonClicked()
        fun onTwelveImageButtonClicked()
        fun onAboveImageButtonClicked()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnOneImageButtonClicked){
            listener = context
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_child, container, false);


        val oneImageButton = view.one_image_button
        val sixImageButton = view.six_image_button
        val twelveImageButton = view.twelve_image_button
        val aboveImageButton = view.above_image_button



        oneImageButton.setOnClickListener {
                listener.onOneImageButtonClicked()
            }

        sixImageButton.setOnClickListener {
            listener.onSixImageButtonClicked()
        }
        twelveImageButton.setOnClickListener {
            listener.onTwelveImageButtonClicked()
        }
        aboveImageButton.setOnClickListener {
            listener.onAboveImageButtonClicked()
        }

        return view
    }
}