package com.example.zikra.pertemuan_12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zikra.R
import com.example.zikra.databinding.FragmentRestApiBinding
import com.example.zikra.pertemuan_12.data.api.CatFactApiClient
import com.example.zikra.pertemuan_12.data.api.PhotoApiClient
import com.example.zikra.pertemuan_12.photo.PhotoAdapter
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class RestApiFragment : Fragment() {
    private var _binding: FragmentRestApiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestApiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.apply {
            title = "Pertemuan 12 - REST API & Retrofit"
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }

        // Default: list vertical
        binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())

        // Cat Fact
        loadCatFact()
        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        // Mode tampilan RecyclerView
        binding.btnVertical.setOnClickListener {
            binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())
        }
        binding.btnHorizontal.setOnClickListener {
            binding.rvGallery.layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL, false
            )
        }
        binding.btnGrid.setOnClickListener {
            binding.rvGallery.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        // Galeri foto
        loadPhoto()
    }

    private fun loadCatFact() {
        binding.tvCatFact.text = "Loading cat fact..."
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _binding?.tvCatFact?.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                binding.rvGallery.adapter = PhotoAdapter(photos)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                context?.let {
                    Toast.makeText(it, "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
