package com.curiourapps.biolibrary

import android.app.Application
import android.content.Context

open class AppContext : Application() {

    /** Instance of the current application.  */
    private var instance: AppContext? = null

    /**
     * Constructor.
     */
    fun AppContext() {
        instance = this
    }

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    fun getContext(): Context? {
        return instance
    }
}