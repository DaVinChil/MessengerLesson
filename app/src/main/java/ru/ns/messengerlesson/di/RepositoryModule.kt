package ru.ns.messengerlesson.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ns.messengerlesson.data.remote.MessengerApi
import ru.ns.messengerlesson.data.remote.MessengerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun messengerRepository(messengerApi: MessengerApi) = MessengerRepository(messengerApi)
}