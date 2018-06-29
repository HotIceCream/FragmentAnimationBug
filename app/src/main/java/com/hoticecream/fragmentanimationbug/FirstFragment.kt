package com.hoticecream.fragmentanimationbug

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FirstFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        view.findViewById<Button>(R.id.button_next).setOnClickListener { showSecondFragment() }
        return view
    }

    private fun showSecondFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.second_in, R.anim.first_out)
                .replace(R.id.container, SecondFragment.newInstance())
                .commitAllowingStateLoss()
    }
}