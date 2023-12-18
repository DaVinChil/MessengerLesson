package ru.ns.messengerlesson.data.remote

import ru.ns.messengerlesson.data.RequestStatus
import ru.ns.messengerlesson.data.Resource
import java.lang.Exception
import javax.inject.Inject

class MessengerRepository @Inject constructor(
    private val messengerApi: MessengerApi
) {
    suspend fun sendMessage(messageDto: MessageDto): RequestStatus = try {
        messengerApi.sendMessage(messageDto)
        RequestStatus.Success
    } catch (e: Exception) {
        RequestStatus.Error(e.message ?: "Unknown error")
    }

    suspend fun getMessages(): Resource<List<Message>> = try {
        Resource.Success(messengerApi.getMessages())
    } catch (e: Exception) {
        Resource.Error(e.message ?: "Unknown error")
    }
}