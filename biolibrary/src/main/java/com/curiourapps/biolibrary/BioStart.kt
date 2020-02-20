package com.curiourapps.biolibrary

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

class BioStart{

    companion object {
        //private val cContext = AppliContext.getContext()
        private val TAG: String = "BioStart"
        private val TAGBIO: String = "BioOpened"
        private var biometricPrompt: BiometricPrompt? = null

        fun bioMet(context: FragmentActivity) {
            val executor = ContextCompat.getMainExecutor(context)
            val callback = object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Log.d(TAG, "$errorCode :: $errString")
                    if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON)
                        Toast.makeText(context,
                            "User Cancelled : $errString", Toast.LENGTH_LONG).show()
                    if (errorCode == BiometricPrompt.ERROR_USER_CANCELED) {
                        Toast.makeText(context,
                            "User Cancelled : $errString", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Log.d(TAG, "Somehow Failed")
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Log.d(TAG, "<<< Login Success >>>")
                }
            }
            biometricPrompt = BiometricPrompt(context, executor, callback)
            openBio(context)
            //return BiometricPrompt(fragmentActivity, executor, callback)
        }

        fun customPromptInfo(): BioPromptInfo {
            return BioPromptInfo.Builder()
                .setTitle("")
                .setDescription("")
                .setNegativeButtonText("")
                .build()

        }
        fun createPromptInfo(): BiometricPrompt.PromptInfo {
            return BiometricPrompt.PromptInfo.Builder()
                .setTitle("Log In")
                .setDescription("Secure Biometric Login")
                .setNegativeButtonText("Use Password")
                .build()
        }

        private fun openBio(context: Context) {
            Log.d(TAGBIO, "<++ Biometric opened ++>")
            val promptInfo = customPromptInfo()
            if (BiometricManager.BIOMETRIC_SUCCESS == BiometricManager
                    .from(context)
                    .canAuthenticate()
            ) {
                Log.d(TAGBIO, "No error detected. Login in progress.")
                biometricPrompt?.authenticate(promptInfo)
            } else {

            }
            if (BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE == BiometricManager
                    .from(context)
                    .canAuthenticate()) {
                Log.d(TAGBIO, "This device does not have a biometric scanner.")
                Toast.makeText(context,
                    "This device does not have a biometric scanner.", Toast.LENGTH_LONG).show()
            }
            if (BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED == BiometricManager
                    .from(context)
                    .canAuthenticate()
            ) {
                Log.d(TAGBIO, "The user does not have any biometrics enrolled.")
                Toast.makeText(
                    context,
                    "The user does not have any biometrics enrolled.", Toast.LENGTH_LONG
                ).show()

                //TODO take user to the biometric settings: likely show a
                // dialog and give user a choice to set up or continue where they are.
            }
            if (BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE == BiometricManager
                    .from(context)
                    .canAuthenticate()
            ) {
                Log.d(TAGBIO, "Biometric hardware is unavailable.")
                Toast.makeText(
                    context,
                    "Biometric hardware is unavailable. \n" +
                            " Please wait for scanner to come online", Toast.LENGTH_LONG
                ).show()
            }

        }


    }

//    fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        openBio()
//        biometricPrompt = bioMet()
//    }

//    fun bioMet(): BiometricPrompt {
//
//        val fragmentActivity = FragmentActivity()
//        val executor = ContextCompat.getMainExecutor(context)
//        val callback = object : BiometricPrompt.AuthenticationCallback() {
//            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
//                super.onAuthenticationError(errorCode, errString)
//                Log.d(TAG, "$errorCode :: $errString")
//                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON)
//                    Toast.makeText(context,
//                        "User Cancelled : $errString", Toast.LENGTH_LONG).show()
//                //finish()
//                if (errorCode == BiometricPrompt.ERROR_USER_CANCELED) {
//                    Toast.makeText(context,
//                        "User Cancelled : $errString", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onAuthenticationFailed() {
//                super.onAuthenticationFailed()
//                Log.d(TAG, "Somehow Failed")
//            }
//
//            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
//                super.onAuthenticationSucceeded(result)
//                Log.d(TAG, "<<< Login Success >>>")
//            }
//        }
//        return BiometricPrompt(fragmentActivity, executor, callback)
//        //return BiometricPrompt(FragmentActivity: context, executor, callback)
//    }
//
//    private fun createPromptInfo(): BiometricPrompt.PromptInfo {
//        return BiometricPrompt.PromptInfo.Builder()
//            .setTitle("Log into myFios")
//            .setDescription("Touch Fingerprint sensor")
//            .setNegativeButtonText("Use Password")
//            .build()
//    }

//    private fun openBio(view: View) {
//        Log.d(TAGBIO, "<++ Biometric opened ++>")
//        val promptInfo = createPromptInfo()
//        if (BiometricManager.BIOMETRIC_SUCCESS == BiometricManager
//                .from(context)
//                .canAuthenticate()
//        ) {
//            Log.d(TAGBIO, "No error detected. Login in progress.")
//            biometricPrompt.authenticate(promptInfo)
//        } else {
//
//        }
//        if (BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE == BiometricManager
//                .from(context)
//                .canAuthenticate()
//        ) {
//            Log.d(TAGBIO, "This device does not have a biometric scanner.")
//            Toast.makeText(context,
//                "This device does not have a biometric scanner.", Toast.LENGTH_LONG).show()
//        }
//        if (BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED == BiometricManager
//                .from(context)
//                .canAuthenticate()
//        ) {
//            Log.d(TAGBIO, "The user does not have any biometrics enrolled.")
//            Toast.makeText(context,
//                "The user does not have any biometrics enrolled.", Toast.LENGTH_LONG).show()
//
//            //TODO take user to the biometric settings: likely show a
//            // dialog and give user a choice to set up or continue where they are.
//        }
//        if (BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE == BiometricManager
//                .from(context)
//                .canAuthenticate()
//        ) {
//            Log.d(TAGBIO, "Biometric hardware is unavailable.")
//            Toast.makeText(context,
//                "Biometric hardware is unavailable. \n" +
//                        " Please wait for scanner to come online", Toast.LENGTH_LONG).show()
//        }
//
//    }

}