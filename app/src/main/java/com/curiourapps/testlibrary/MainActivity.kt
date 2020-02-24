package com.curiourapps.testlibrary

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.curiourapps.biolibrary.BioStart

class MainActivity : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BioStart.BioStartBuilder(this)
            .setTitle("Biometric Title")
            .setDescription("Description of Biometric")
            .setnegativeButtonText("Do Nothing")
            .build()
            .bioMet()
    }
}
