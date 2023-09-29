package com.example.android_boilerplate.presentation.ui.fragment.sign.`in`

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_boilerplate.presentation.base.BaseFragment
import com.example.android_boilerplate.presentation.extention.activityNavController
import com.example.android_boilerplate.presentation.extention.navigateSafely
import com.example.data.local.preferences.PreferencesHelper
import com.nooruz.boilerplate.R
import com.nooruz.boilerplate.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<SignInViewModel, FragmentSignInBinding>(R.layout.fragment_sign_in) {
    override val viewModel: SignInViewModel by viewModels()

    override val binding by viewBinding(FragmentSignInBinding::bind)

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun setupListeners() {
        clickSignIn()
        clickSignUp()
    }

    private fun clickSignIn() {
        binding.buttonSignIn.setOnClickListener {
            preferencesHelper.isAuthorize = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }
    }

    private fun clickSignUp() {
        binding.buttonSignUp.setOnClickListener {
            activityNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
}