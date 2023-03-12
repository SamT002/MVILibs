package com.example.coffeeshopapplication.mvikotlin.features

class CatViewImpl {
}

interface CatStore {

    sealed interface Intent{
        object LoadCatFact : Intent
    }

    sealed interface State{
        val fact:String
        val length:Int
    }

}