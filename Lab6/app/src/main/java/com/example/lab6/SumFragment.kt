package com.example.lab6

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.lab6.databinding.SumFragmentBinding

class SumFragment : Fragment() {
    private lateinit var viewModel: SumViewModel

    private lateinit var _binding: SumFragmentBinding
    private var total = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SumFragmentBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SumViewModel::class.java)
        _binding.textView.text = viewModel.total.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultText : TextView = _binding.textView

        val button : Button =  _binding.button
        button.setOnClickListener {
            //total += 1
            //resultText.text = total.toString()
            viewModel.changeMainText()
            resultText.text = viewModel.total.toString()
        }
    }

}