package ru.ns.messengerlesson.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.ns.messengerlesson.data.local.UserDao
import ru.ns.messengerlesson.data.local.UserDatabase
import ru.ns.messengerlesson.data.local.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun userDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(appContext, UserDatabase::class.java, "database.db")
            .build()

    @Provides
    @Singleton
    fun userDao(userDatabase: UserDatabase) = userDatabase.getUserDao()

    @Provides
    @Singleton
    fun userRepository(userDao: UserDao) = UserRepository(userDao)
}