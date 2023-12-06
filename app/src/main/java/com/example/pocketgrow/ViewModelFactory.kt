package com.example.pocketgrow

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pocketgrow.login.LoginViewModel
import com.example.pocketgrow.register.RegisterViewModel

class ViewModelFactory private constructor(
    private val repository: Application
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repository) as T
        }
//        else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
//            return DetailViewModel(repository) as T
//        } else if (modelClass.isAssignableFrom(UploadViewModel::class.java)) {
//            return UploadViewModel(repository) as T
//        } else if (modelClass.isAssignableFrom(MapsViewModel::class.java)) {
//            return MapsViewModel(repository) as T
//        }
        throw IllegalArgumentException("View model unknown: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(context)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}