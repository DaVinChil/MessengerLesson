package ru.ns.messengerlesson.data

sealed class Resource<T>(val value: T? = null) {
    class Success<T>(value: T) : Resource<T>(value)
    class Error<T>(val message: String) : Resource<T>()
}