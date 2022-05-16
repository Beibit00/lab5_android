
package com.example.todolist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.todolist.databinding.FragmentTodolistDetailBinding



/**
 * This Fragment shows the detailed information on a particular Amphibian
 */
class TodolistDetailFragment : Fragment() {
    //niche ne menyaem voobshe zdes
    private val viewModel: TodolistViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTodolistDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // Inflate the layout for this fragment
        return binding.root
    }
}
