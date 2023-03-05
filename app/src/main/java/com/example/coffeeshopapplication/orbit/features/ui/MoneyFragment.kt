package com.example.coffeeshopapplication.orbit.features.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeeshopapplication.databinding.FragmentMoneyBinding
import com.example.coffeeshopapplication.orbit.features.viewModel.MoneySideEffect
import com.example.coffeeshopapplication.orbit.features.viewModel.MoneyState
import com.example.coffeeshopapplication.orbit.features.viewModel.MoneyViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.orbitmvi.orbit.viewmodel.observe

class MoneyFragment : Fragment() {

    private val binding: FragmentMoneyBinding by viewBinding()
    private val viewModel by viewModel<MoneyViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observe(
            viewLifecycleOwner,
            state = ::render,
            sideEffect = ::onSideEffect
        )
    }

    private fun render(moneyState: MoneyState) {
        moneyState.money?.bpi?.EUR?.let {
            binding.tvEuroDescription.text = it.description
        }

        moneyState.money?.bpi?.USD?.let {
            binding.tvDollarDescription.text = it.description
        }

        moneyState.money?.bpi?.GBP?.let {
            binding.tvSomeDescription.text = it.description
        }
    }

    private fun onSideEffect(moneySideEffect: MoneySideEffect) {
        when(moneySideEffect){
            is MoneySideEffect.Error -> {
                Snackbar.make(requireView(), moneySideEffect.value, Snackbar.LENGTH_LONG).show()
            }
            is MoneySideEffect.Loading ->{
                binding.pgMoney.isVisible = moneySideEffect.isVisible
            }
            else -> return
        }
    }


}