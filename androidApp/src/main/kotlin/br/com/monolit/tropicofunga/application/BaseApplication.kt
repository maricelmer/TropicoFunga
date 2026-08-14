package br.com.monolit.tropicofunga.application

import android.app.Application
import br.com.monolit.tropicofunga.koin.initializeKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeKoin(
            specializedModule = module {

            }
        ) {
            androidContext(this@BaseApplication)
        }
    }
}