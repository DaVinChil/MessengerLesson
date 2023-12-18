package ru.ns.messengerlesson.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_name")
data class User(@PrimaryKey(autoGenerate = true) val id: Long? = null, val name: String)