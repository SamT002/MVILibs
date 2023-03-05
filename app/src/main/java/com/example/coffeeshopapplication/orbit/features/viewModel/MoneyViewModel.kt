package com.example.coffeeshopapplication.orbit.features.viewModel

import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.coffeeshopapplication.orbit.data.model.Money
import com.example.coffeeshopapplication.orbit.data.repository.MoneyRepository
import kotlinx.parcelize.Parcelize
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container


@Parcelize
data class MoneyState(
    val money: Money?
) : Parcelable

sealed interface MoneySideEffect {
    data class Error(val value: String) : MoneySideEffect
    data class Loading(val isVisible: Boolean) : MoneySideEffect
}

class MoneyViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val moneyRepository: MoneyRepository
) : ViewModel(), ContainerHost<MoneyState, MoneySideEffect> {

    override val container = container<MoneyState, MoneySideEffect>(
        initialState = MoneyState(null),
        savedStateHandle = savedStateHandle,
        buildSettings = {

        }
    ) {
        if (it.money == null) {
            loadMoney()
        }
    }

    private fun loadMoney() = intent {
        postSideEffect(sideEffect = MoneySideEffect.Loading(true))
        try {
            val money = moneyRepository.fetchMoney()
            reduce {
                state.copy(money = money)
            }
        } catch (t: Throwable) {
            postSideEffect(MoneySideEffect.Error(t.message.toString()))
        } finally {
            postSideEffect(MoneySideEffect.Loading(false))
        }
    }


}