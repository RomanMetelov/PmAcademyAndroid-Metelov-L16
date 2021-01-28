package com.example.pmacademyandroid_metelov_l16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pmacademyandroid_metelov_l16.databinding.MyFragmentBinding

private const val ARG_NAME = "countryName"
private const val ARG_POPULATION = "countryPopulation"
private const val ARG_AREA = "countryArea"

class MyFragment : Fragment() {

    private lateinit var binding: MyFragmentBinding

    private var country: String = "Name"
    private var population: Double = 0.0
    private var area: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getString(ARG_NAME, "Name")
            population = it.getDouble(ARG_POPULATION, 0.0)
            area = it.getDouble(ARG_AREA, 0.0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = getString(R.string.country_name, country)
        binding.tvPopulation.text = getString(R.string.country_population, population)
        binding.tvArea.text = getString(R.string.country_area, area)
        binding.tvDensity.text = getString(R.string.country_density, area /population)
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, population: Double, area: Double) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putDouble(ARG_POPULATION, population)
                    putDouble(ARG_AREA, area)
                }
            }
    }
}