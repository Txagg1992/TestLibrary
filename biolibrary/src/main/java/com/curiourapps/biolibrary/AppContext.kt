package com.curiourapps.biolibrary

import android.app.Application
import android.content.Context


class AppContext : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        var context: Context? = null
            private set
    }
}

//open class AppContext : Application() {
//
//    /** Instance of the current application.  */
//    private var instance: AppContext? = null
//
//    /**
//     * Constructor.
//     */
//    fun AppContext() {
//        instance = this
//    }
//
//    /**
//     * Gets the application context.
//     *
//     * @return the application context
//     */
//    fun getContext(): Context? {
//        return instance
//    }
//}