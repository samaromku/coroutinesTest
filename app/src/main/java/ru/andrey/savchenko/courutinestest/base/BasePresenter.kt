package ru.andrey.savchenko.courutinestest.base

import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import retrofit2.Response
import java.util.concurrent.TimeUnit

open class BasePresenter<T : BaseView> : MvpPresenter<T>() {
    fun<T> makeNetworkRequest(beforeRequest: () -> Unit = { showDialog() },
                    afterRequest: () -> Unit = { hideDialog() },
                    request: () -> Response<T>,
                    onResult: (result: T) -> Unit,
                    errorShow: (error: String) -> Unit = { t -> showError(t) }): Job {
        return launch(UI) {
            beforeRequest()
            delay(1000, TimeUnit.MILLISECONDS)
            var result: Response<T>? = null
            try {
                result = async(CommonPool) {
                    request()
                }.await()
            } catch (ex: Throwable) {
                ex.printStackTrace()
                errorShow(ex.message.toString())
            }
            afterRequest()
            delay(1000, TimeUnit.MILLISECONDS)

            if (result != null) {
                val body = result.body()
                //here you can add all checks errors
                body?.let { onResult(it) }
            }
        }
    }

    fun showDialog() {
        viewState.showDialog()
    }

    fun hideDialog() {
        viewState.hideDialog()
    }

    fun showError(error: String) {
        viewState.showError(error)
    }
}