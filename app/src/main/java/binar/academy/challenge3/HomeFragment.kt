package binar.academy.challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.challenge3.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), RekomendasiMenuAdapter.OnItemRekomendasiClickListener, MenuAdapter.OnItemMenuClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var isGrid = false
    override fun onItemRekomendasiClick(data: MenuItem) {
        pindahFragmentDetail(data)
    }

    override fun onItemMenuClick(data: MenuItem) {
        pindahFragmentDetail(data)
    }

    fun pindahFragmentDetail(data: MenuItem) {
        val actionToDetailFragment = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
        actionToDetailFragment.menuSelected = data
        findNavController().navigate(actionToDetailFragment)
    }

    fun pindahFragmentMaintenance() {
        val actionToMaintenanceFragment = HomeFragmentDirections.actionHomeFragmentToMaintenanceFragment()
        findNavController().navigate(actionToMaintenanceFragment)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupMenuRekomendasi(Menu.menus)
        setupRecyclerView(isGrid)
        setupActionChangeLayout()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnChart.setOnClickListener {
            pindahFragmentMaintenance()
        }

        binding.btnUser.setOnClickListener {
            pindahFragmentMaintenance()
        }
    }

    fun setupMenuRekomendasi(listItem: List<Any>) {
        var menuRekomendasi = arrayListOf<MenuItem>()
        val filteredList = listItem.filterNot { it is String } as ArrayList<MenuItem>

        for (menu in filteredList) {
            if (menu.bestSeller == 1) {
                menuRekomendasi.add(menu)
            }
        }
        binding.rvRekomendasiMenu.adapter = RekomendasiMenuAdapter(menuRekomendasi, this)
        binding.rvRekomendasiMenu.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    fun setupRecyclerView(isGrid: Boolean) {
        if (isGrid) {
            binding.rvItemMenu.adapter = MenuAdapter(isGrid,Menu.menus.filterNot { it is String }, this)
            binding.btnChangeLayout.setImageResource(R.drawable.icon_list_layout)
            val layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rvItemMenu.layoutManager = layoutManager
        } else {
            binding.rvItemMenu.adapter = MenuAdapter(isGrid,Menu.menus, this)
            binding.btnChangeLayout.setImageResource(R.drawable.icon_grid_layout)
            binding.rvItemMenu.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    fun setupActionChangeLayout() {
        binding.btnChangeLayout.setOnClickListener {
            isGrid = !isGrid
            setupRecyclerView(isGrid)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}