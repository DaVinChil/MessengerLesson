package ru.ns.messengerlesson

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ns.messengerlesson.data.local.User
import ru.ns.messengerlesson.data.local.UserRepository
import ru.ns.messengerlesson.data.remote.MessengerRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val messengerRepository: MessengerRepository
) : ViewModel() {
    private var _user: User? by mutableStateOf(null)
    val user: User? get() = _user

    private var _isUserFetching by mutableStateOf(false)
    val isUserFetching: Boolean get() = _isUserFetching

    init {
        loadUser()
    }

    private fun loadUser() {
        viewModelScope.launch {
            _isUserFetching = true
            _user = userRepository.getUser()
            _isUserFetching = false
        }
    }

    fun saveUser(userName: String) {
        viewModelScope.launch {
            userRepository.insertUser(userName)
            loadUser()
        }
    }
}