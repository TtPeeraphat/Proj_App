package com.example.proj_app.ui.ui.faq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proj_app.databinding.FragmentFaqBinding


class FaqFragment : Fragment() {

    private var _binding: FragmentFaqBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val faqViewModel =
            ViewModelProvider(this).get(FaqViewModel::class.java)

        _binding = FragmentFaqBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.FqTxtH
        faqViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}