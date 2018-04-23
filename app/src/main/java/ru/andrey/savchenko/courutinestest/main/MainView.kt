package ru.andrey.savchenko.courutinestest.main

import com.arellomobile.mvp.MvpView
import ru.andrey.savchenko.courutinestest.User


interface MainView:MvpView {
    fun showDialog()
    fun hideDialog()
    fun showError(text:String)
    fun showResult(list:List<User>)
}