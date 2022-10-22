package com.example.patikaweek5.ui.users.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.patikaweek5.data.repository.User.UserRepository
import com.example.patikaweek5.ui.model.DataState
import com.example.patikaweek5.ui.model.users.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private var _userLiveData = MutableLiveData<DataState<List<Users>?>>()
    val userLiveData: LiveData<DataState<List<Users>?>>
        get() = _userLiveData

    private val _eventStateLiveData = MutableLiveData<UserViewEvent>()
    val eventStateLiveData: LiveData<UserViewEvent>
        get() = _eventStateLiveData

    init {
        getUsers()
    }

    private fun getUsers(){
        _userLiveData.postValue(DataState.Loading())
        userRepository.getUsers().enqueue(object : Callback<List<Users>>{
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        _userLiveData.postValue(DataState.Success(it.map { safeUser ->
                            Users(
                                id = safeUser.id,
                                name = safeUser.name,
                                username = safeUser.username,
                                address = safeUser.address,
                                company = safeUser.company,
                                email = safeUser.email,
                                phone = safeUser.phone,
                                website = safeUser.website
                            )
                        }))
                    }?: kotlin.run {
                        _userLiveData.postValue(DataState.Error("Data Empty"))
                    }
                }else {
                    _userLiveData.postValue(DataState.Error(response.message()))
                }
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                _userLiveData.postValue(DataState.Error(t.message.toString()))
                _eventStateLiveData.postValue(UserViewEvent.ShowMessage(t.message.toString()))
            }

        })
    }

}

sealed class UserViewEvent {
    object NavigateToDetail : UserViewEvent()
    class ShowMessage(val message: String?) : UserViewEvent()
}