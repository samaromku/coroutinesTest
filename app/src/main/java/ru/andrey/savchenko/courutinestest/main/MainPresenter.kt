package ru.andrey.savchenko.courutinestest.main

import com.arellomobile.mvp.InjectViewState
import ru.andrey.savchenko.courutinestest.NetworkHandler
import ru.andrey.savchenko.courutinestest.base.BasePresenter


@InjectViewState
class MainPresenter : BasePresenter<MainView>() {
    fun getData() {
        makeNetworkRequest(request = {
            NetworkHandler.getService().getTestData().execute()
        }, onResult = {viewState.showResult(it)})
    }
}