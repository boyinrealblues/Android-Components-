package com.example.guesstheword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.guesstheword.databinding.FragmentGameBinding

const val SCORE_RESULT = "score123"
class GameFragment : Fragment(){

    lateinit private var binding : FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_game,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //model initialized

        val model = ViewModelProvider(this).get(GameFragmentViewModel::class.java)

        model.stringTime.observe(viewLifecycleOwner , {
            binding.timerText.text = it
        })

        model.score.observe(  viewLifecycleOwner , {
            binding.scoreText.text = it.toString()
        })

        model.word.observe(viewLifecycleOwner, {
            binding.wordText.text = it
        })

        model.check.observe(viewLifecycleOwner , {
            if (it) {
                 val bundle : Bundle = bundleOf(SCORE_RESULT to model.score)
                findNavController().navigate(R.id.next_action,bundle)
            }
        })

        binding.correctButton.setOnClickListener {
            model.onGotIt()
        }
        binding.skipButton.setOnClickListener {
            model.onSkip()
        }

    }

}