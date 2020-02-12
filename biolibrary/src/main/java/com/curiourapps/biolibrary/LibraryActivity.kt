package com.curiourapps.biolibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curiourapps.biolibrary.BioStart

class LibraryActivity : AppCompatActivity {

    public val bioStart: BioStart

    constructor(bioStart: BioStart) : super() {
        this.bioStart = bioStart
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

    bioStart.bioMet()
    }


}
