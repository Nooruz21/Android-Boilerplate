package com.example.android_boilerplate.presentation.ui.fragment.main.foopaging

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_boilerplate.presentation.base.BaseFragment
import com.example.android_boilerplate.presentation.extention.showToastLong
import com.example.android_boilerplate.presentation.ui.adapter.FooPagingAdapter
import com.example.android_boilerplate.presentation.ui.adapter.paging.CommonLoadStateAdapter
import com.nooruz.boilerplate.R
import com.nooruz.boilerplate.databinding.FragmentFooPagingBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.InterruptedIOException

@AndroidEntryPoint
class FooPagingFragment : BaseFragment<FooPagingViewModel, FragmentFooPagingBinding>(
    R.layout.fragment_foo_paging
) {

    override val viewModel: FooPagingViewModel by viewModels()
    override val binding by viewBinding(FragmentFooPagingBinding::bind)

    private val fooPagingAdapter = FooPagingAdapter()

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() = with(binding) {
        with(recyclerFooPaging) {
            layoutManager = LinearLayoutManager(context)
            adapter = fooPagingAdapter.withLoadStateFooter(
                footer = CommonLoadStateAdapter { fooPagingAdapter.retry() }
            )
        }

        fooPagingAdapter.addLoadStateListener { loadStates ->
            recyclerFooPaging.isVisible = loadStates.refresh is LoadState.NotLoading
            loaderFooPaging.isVisible = loadStates.refresh is LoadState.Loading

            if (loadStates.refresh is LoadState.Error) {
                if ((loadStates.refresh as LoadState.Error).error is InterruptedIOException) {
                    showToastLong("Timeout")
                }
            }
        }
    }

    override fun setupRequests() {
        fetchFooPaging()
    }

    private fun fetchFooPaging() {
        viewModel.fooPaging.collectPaging {
            fooPagingAdapter.submitData(it)
        }
    }
}