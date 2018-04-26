package ru.andrey.savchenko.courutinestest.base

import com.arellomobile.mvp.MvpView

/**
 * Created by savchenko on 26.04.18.
 */
interface BaseView :MvpView{
    fun showDialog()
    fun hideDialog()
    fun showError(text:String)
}