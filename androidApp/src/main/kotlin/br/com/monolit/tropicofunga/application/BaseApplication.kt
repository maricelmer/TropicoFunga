package br.com.monolit.tropicofunga.application

import android.app.Application
import android.content.Context
import br.com.monolit.tropicofunga.koin.initializeKoin
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeKoin(
            specializedModule = module {
                single<Settings> {
                    SharedPreferencesSettings(
                        get<Context>().getSharedPreferences(
                            "tropico_funga_settings",
                            Context.MODE_PRIVATE,
                        )
                    )
                }
            }
        ) {
            androidContext(this@BaseApplication)
        }
    }
}