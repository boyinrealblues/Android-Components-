package com.example.guesstheword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.guesstheword.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    lateinit private var binding: FragmentTitleBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startButton.setOnClickListener {
             val  nav = navOptions {
                anim {
                    enter = android.R.anim.fade_in
                    exit = android.R.anim.fade_out
                    popEnter = android.R.anim.fade_in
                    popExit = android.R.anim.fade_out
                }
            }
            findNavController().navigate(R.id.next_action,null,nav)
        }
    }

}