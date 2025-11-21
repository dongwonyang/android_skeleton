package com.example.feature.home.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feature.home.databinding.FragmentHomeBinding
import com.example.feature.home.databinding.ItemHomeTextBinding

class SampleViewPagerFragment: Fragment() {
    private var _binding: ItemHomeTextBinding? = null
    private val binding get() = _binding!!

    private var title:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(TITLE_PARAMS)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemHomeTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvHomeText1.text = title ?: null
    }

    companion object {
        private const val TITLE_PARAMS: String = "title"

        @JvmStatic
        fun newInstance(
            title: String,
        ) = SampleViewPagerFragment().apply {
            arguments = Bundle().apply {
                putString(TITLE_PARAMS, title)
            }
        }
    }
}