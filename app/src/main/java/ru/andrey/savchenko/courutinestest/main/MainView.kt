package ru.andrey.savchenko.courutinestest.main

import ru.andrey.savchenko.courutinestest.User
import ru.andrey.savchenko.courutinestest.base.BaseView


interface MainView:BaseView {

    fun showResult(list:List<User>)
}