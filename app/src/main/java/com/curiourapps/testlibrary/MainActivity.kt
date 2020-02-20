package com.curiourapps.testlibrary

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.curiourapps.biolibrary.BioPromptInfo
import com.curiourapps.biolibrary.BioStart

class MainActivity : FragmentActivity() {

    val info = BioStart.customPromptInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BioStart.bioMet(this)
        info
            .setTitle("This is a Title")
            .setDescription("And a Description")
            .setNegativeButtonText("P/W or Cancel")
            .build()
    }
}
