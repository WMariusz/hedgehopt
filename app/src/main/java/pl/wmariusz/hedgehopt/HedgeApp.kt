package pl.wmariusz.hedgehopt

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient

@HiltAndroidApp
class HedgeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Coil.setImageLoader {
            ImageLoader.Builder(this)
                .okHttpClient {
                    OkHttpClient.Builder()
                        .cache(CoilUtils.createDefaultCache(this))
                        .build()
                }
                .crossfade(true)
                .build()
        }
    }
}