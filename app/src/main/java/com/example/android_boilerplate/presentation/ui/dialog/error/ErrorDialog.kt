package com.example.android_boilerplate.presentation.ui.dialog.error

import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_boilerplate.presentation.base.BaseDialog
import com.nooruz.boilerplate.R
import com.nooruz.boilerplate.databinding.DialogErrorBinding

class ErrorDialog : BaseDialog<DialogErrorBinding>(R.layout.dialog_error) {

    override val binding: DialogErrorBinding by viewBinding(DialogErrorBinding::bind)
    private val args by navArgs<ErrorDialogArgs>()

    override fun initialize() = with(binding) {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        titleErrorTxt.text = args.titleError
        descErrorTxt.text = args.descError
    }
}