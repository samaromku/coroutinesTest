package ru.andrey.savchenko.courutinestest

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by savchenko on 23.04.18.
 */
object NetworkHandler {

    fun getService(): NetworkService {
        val client: OkHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        //real server
//        return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(NetworkService::class.java)

        return object :NetworkService{
            override fun getTestData(): Call<List<User>> {
                return object : Call<List<User>> {
                    override fun enqueue(callback: Callback<List<User>>?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun isExecuted(): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun clone(): Call<List<User>> {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun isCanceled(): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun cancel() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun execute(): Response<List<User>> {
                        return Response.success(listOf(
                                User(1, "test1"),
                                User(2, "test2"),
                                User(3, "test3"),
                                User(4, "test4")))
                    }

                    override fun request(): Request {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                }
            }
        }
    }
}