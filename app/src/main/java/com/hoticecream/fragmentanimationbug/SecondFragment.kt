package com.hoticecream.fragmentanimationbug

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SecondFragment : Fragment() {


    private var started: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        started = arguments?.getBoolean(KEY_STARTED, false)!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (!started && savedInstanceState == null) {
            startActivity(Intent(requireActivity(), SecondActivity::class.java))
            started = true
            arguments?.putBoolean(KEY_STARTED, true)
        }
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    companion object {

        const val KEY_STARTED = "started"

        fun newInstance(): SecondFragment {
            val fragment = SecondFragment()
            fragment.arguments = Bundle()
            return fragment
        }

    }
}