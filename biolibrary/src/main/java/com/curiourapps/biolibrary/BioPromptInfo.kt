package com.curiourapps.biolibrary

import androidx.biometric.BiometricPrompt

class BioPromptInfo private constructor(
    val title: String?,
    val description: String?,
    val negativeButtonText: String?): BiometricPrompt.PromptInfo.Builder() {

    data class Builder(
        var title: String? = null,
        var description: String? = null,
        var negativeButtonText: String? = null
    ) {

        fun setTitle(title: String) = apply {
            this.title = title }
        fun setDescription(description: String) = apply {
            this.description = description }
        fun setNegativeButtonText(negativeButtonText: String) = apply {
                this.negativeButtonText = negativeButtonText }
        fun build() = BioPromptInfo(title, description, negativeButtonText)

    }
}