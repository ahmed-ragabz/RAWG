package com.ragabz.rawg.data.extensions

import com.ragabz.core.deliverable.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

fun <T> Response<T>.toFlow() = flow {
    emit(
        when (isSuccessful) {
            true -> Result.Success(body() as T)
            false -> Result.Error(Exception(message()))
        }
    )
}.catch { e ->
    emit(Result.Error(Exception(e)))
}

fun <T> Response<T>.whenSuccess(action: (T) -> Unit) {
    if (isSuccessful) {
        action.invoke(body() as T)
    }
}

fun <T> Response<T>.whenError(action: (Exception) -> Unit) {
    if (!isSuccessful)
        action.invoke(Exception(message()))
}

