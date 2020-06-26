package ink.z31.catbooru.data.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class LoggingInterceptor : Interceptor {
    private val TAG = "LoggingInterceptor"
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        Log.d(TAG, "发送数据 ${request.url()} on ${chain.connection()}")
        val response: Response = chain.proceed(request)
        val responseBody = response.peekBody(1024 * 1024.toLong())
        Log.d(TAG, "接收数据 ${response.request().url()} ${responseBody.string()}")
        return response
    }
}