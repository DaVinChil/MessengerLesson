package ru.ns.messengerlesson.data

sealed class RequestStatus {
    object Success : RequestStatus()
    class Error(val message: String) : RequestStatus()
}