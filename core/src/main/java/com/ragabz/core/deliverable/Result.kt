package com.ragabz.core.deliverable

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()

    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data: $data]"
            is Error -> "Error[error: $error]"
            is Loading -> "Loading..."
        }
    }
}

inline fun <reified X> Result<X>.runIfSuccess(action: (X) -> Unit) {
    if (this is Result.Success) {
        action.invoke(this.data)
    }
}

inline fun <reified X> Result<X>.runIfError(action: (Exception) -> Unit) {
    if (this is Result.Error) {
        action.invoke(this.error)
    }
}

inline fun <reified X> Result<X>.runIfLoading(action: () -> Unit) {
    if (this is Result.Loading) {
        action.invoke()
    }
}