package com.example.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.navigation.Route
import com.example.feature.home.adapter.SampleListAdapter
import com.example.feature.home.adapter.SampleViewPagerAdapter
import com.example.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var sampleListAdapter: SampleListAdapter
    private lateinit var sampleViewPagerAdapter: SampleViewPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    private fun initView() = with(binding) {
        fun initRv() {
            sampleListAdapter = SampleListAdapter()

            rvItemRecyclerView.run {
                adapter = sampleListAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        fun initVp() {
            sampleViewPagerAdapter = SampleViewPagerAdapter(this@HomeFragment)
            vpBannerViewPager.run {
                adapter = sampleViewPagerAdapter
            }
        }

        initRv()
        initVp()
    }

    private fun initViewModel() = with(viewModel) {
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest { state ->
                    when (state) {
                        is HomeUiState.Success -> {
                            sampleListAdapter.submitList(state.list)
                        }

                        is HomeUiState.Fail -> {
                        }
                    }
                }
            }
        }
    }
}