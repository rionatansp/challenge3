package binar.academy.challenge3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import binar.academy.challenge3.databinding.FragmentDetailBinding
import java.lang.Exception


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuName = DetailFragmentArgs.fromBundle(arguments as Bundle).menuSelected?.name
        val menuPrice = DetailFragmentArgs.fromBundle(arguments as Bundle).menuSelected?.price
        val menuDescription = DetailFragmentArgs.fromBundle(arguments as Bundle).menuSelected?.deskripsi
        val menuImage = DetailFragmentArgs.fromBundle(arguments as Bundle).menuSelected?.itemPreview
        binding.namaMenu.text = menuName
        binding.hargaMenu.text = "Rp. ${menuPrice?.formatSepartor()}"
        binding.deskripsiMenu.text = menuDescription
        binding.imgPreview.setImageResource(menuImage!!)
        binding.deskripsiLokasi.text = RestoranInfo().alamat

        binding.cardLocation.setOnClickListener {
            goToMaps(RestoranInfo().urlAlamat)
        }

        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Menghitung jumlah harga item di keranjang
        var totalHarga = 0
        var jumlah = 1

        binding.tvItemCount.text = jumlah.toString()
        binding.btnTambahKeranjang.text = "Tambah Ke Keranjang - Rp ${menuPrice?.formatSepartor()}"

        binding.btnPlus.setOnClickListener {
            jumlah++
            totalHarga = menuPrice!! * jumlah
            binding.tvItemCount.text = jumlah.toString()
            binding.btnTambahKeranjang.text = "Tambah Ke Keranjang - Rp ${totalHarga.formatSepartor()}"
        }

        binding.btnMin.setOnClickListener {
            jumlah--
            if (jumlah <= 1) jumlah = 1
            totalHarga = menuPrice!! * jumlah
            binding.tvItemCount.text = jumlah.toString()
            binding.btnTambahKeranjang.text = "Tambah Ke Keranjang - Rp ${totalHarga.formatSepartor()}"
        }

        // Menuju ke Maintenance Fragment
        binding.btnTambahKeranjang.setOnClickListener {
            val actionToFragmentMaintenance = DetailFragmentDirections.actionDetailFragmentToMaintenanceFragment2()
            view.findNavController().navigate(actionToFragmentMaintenance)

        }


    }

    fun goToMaps(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(requireContext(),"Google Maps tidak terinstal", Toast.LENGTH_SHORT).show()
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}