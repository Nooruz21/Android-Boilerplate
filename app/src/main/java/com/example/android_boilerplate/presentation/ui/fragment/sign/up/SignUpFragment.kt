package com.example.android_boilerplate.presentation.ui.fragment.sign.up

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_boilerplate.presentation.base.BaseFragment
import com.nooruz.boilerplate.R
import com.nooruz.boilerplate.databinding.FragmentSignUpBinding

class SignUpFragment :
    BaseFragment<SignUpViewModel, FragmentSignUpBinding>(R.layout.fragment_sign_up) {
    override val viewModel: SignUpViewModel by viewModels()

    override val binding by viewBinding(FragmentSignUpBinding::bind)

}