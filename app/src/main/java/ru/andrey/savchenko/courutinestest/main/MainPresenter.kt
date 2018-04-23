package ru.andrey.savchenko.courutinestest.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import retrofit2.Response
import ru.andrey.savchenko.courutinestest.NetworkHandler
import ru.andrey.savchenko.courutinestest.User


@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    fun getTestDate() {
        launch(UI) {
            viewState.showDialog()
            var result: Response<List<User>>? = null
            try {
                result = async(CommonPool) {
                    NetworkHandler.getService().getTestData().execute()
                }.await()
            } catch (ex: Throwable) {
                ex.printStackTrace()
                viewState.showError(ex.message.toString())
            }
            viewState.hideDialog()

            if (result != null) {
                val body = result.body()
                //here you can add all checks errors
                body?.let { viewState.showResult(it) }
            }
        }
    }
}