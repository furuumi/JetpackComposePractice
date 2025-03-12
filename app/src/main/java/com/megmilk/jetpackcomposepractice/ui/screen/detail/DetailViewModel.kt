package com.megmilk.jetpackcomposepractice.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.megmilk.jetpackcomposepractice.data.repository.UserInfoRepository

class DetailViewModelFactory(private val repository: UserInfoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(UserInfoRepository::class.java)
            .newInstance(repository)
    }
}

class DetailViewModel (private val repository: UserInfoRepository) : ViewModel() {
    fun getInfo(): String {
        return repository.getInfo()
    }
}