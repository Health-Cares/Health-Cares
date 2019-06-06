package com.example.healthcare

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_child.view.*
import kotlinx.android.synthetic.main.fragment_treat.view.*

class TreatFragment : Fragment() {


    private lateinit var listener: OnToothacheImageButtonClicked
    private lateinit var headacheImageButton: OneHeadacheImageButtonCliked
    private lateinit var muscleImageButton: OneMuscleImageButtonCliked
    private lateinit var commonImageButton: OneCommonImageButtonCliked
    private lateinit var asthmaImageButton: OneAsthmaImageButtonCliked
    private lateinit var heartImageButton: OneHeartImageButtonCliked

    interface OnToothacheImageButtonClicked {
        fun onToothacheImageButtonClicked()
        fun onHeadacheImageButtonClicked()
        fun onMuscleImageButtonClicked()
        fun onCommonImageButtonClicked()
        fun onAsthmaImageButtonClicked()
        fun onHeartImageButtonClicked()

    }
    interface OneHeadacheImageButtonCliked {
        fun onHeadacheImageButtonClicked()

    }
    interface OneMuscleImageButtonCliked {
        fun onMuscleImageButtonClicked()

    }
    interface OneCommonImageButtonCliked {
        fun onCommonImageButtonClicked()

    }
    interface OneAsthmaImageButtonCliked {
        fun onAsthmaImageButtonClicked()

    }
    interface OneHeartImageButtonCliked {
        fun onHeartImageButtonClicked()
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnToothacheImageButtonClicked){
            listener = context
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_treat, container, false);


        val toothacheImageButton = view.toothache_image_button
        val headacheImageButton = view.headache_image_button
        val muscleImageButton = view.muscle_image_button
        val commonImageButton = view.common_image_button
        val asthmaImageButton = view.asthma_image_button
        val heartImageButton = view.heart_image_button



        toothacheImageButton.setOnClickListener {
            listener.onToothacheImageButtonClicked()
        }

        headacheImageButton.setOnClickListener {
            listener.onHeadacheImageButtonClicked()
        }
        muscleImageButton.setOnClickListener {
            listener.onMuscleImageButtonClicked()
        }
        commonImageButton.setOnClickListener {
            listener.onCommonImageButtonClicked()
        }
        asthmaImageButton.setOnClickListener {
            listener.onAsthmaImageButtonClicked()
        }
        heartImageButton.setOnClickListener {
            listener.onHeartImageButtonClicked()
        }

        return view
    }
}