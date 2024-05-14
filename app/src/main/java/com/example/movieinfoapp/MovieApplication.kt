package com.example.movieinfoapp

import android.app.Application
import com.example.movieinfoapp.data.AppContainer
import com.example.movieinfoapp.data.DefaultAppContainer

class MovieApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate(){
        super.onCreate()
        container = DefaultAppContainer()
    }
}