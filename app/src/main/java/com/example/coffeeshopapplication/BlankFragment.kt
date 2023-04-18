package com.example.coffeeshopapplication

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeeshopapplication.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private val binding:FragmentBlankBinding by viewBinding()


    fun send(){

    }

    fun test(){
        binding.root.setOnClickListener{}
    }

}