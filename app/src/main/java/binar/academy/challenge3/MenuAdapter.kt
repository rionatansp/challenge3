package binar.academy.challenge3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import binar.academy.challenge3.databinding.GridItemMenuBinding
import binar.academy.challenge3.databinding.LinearItemMenuBinding
import binar.academy.challenge3.databinding.ItemMenuHeaderBinding
import kotlinx.android.extensions.LayoutContainer
import java.lang.IllegalArgumentException

class MenuAdapter(val isGrid: Boolean, val data: List<Any>, private val itemClickListener: OnItemMenuClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_HEADER = 0
        private const val ITEM_MENU = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is String -> ITEM_HEADER
            is MenuItem -> ITEM_MENU
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    interface OnItemMenuClickListener {
        fun onItemMenuClick(data: MenuItem)
    }


    // Membuat Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            ITEM_HEADER -> {
//                val binding = ItemMenuHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return MenuHeaderHolder(binding)
//            }
//            ITEM_MENU -> {
//                if (isGrid) {
//                    val binding = GridItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                    return GridMenuHolder(binding)
//                }
//                else {
//                    val binding = LinearItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                    return LinearMenuHolder(binding)
//                }
//            }
//            else -> throw IllegalArgumentException("Undefined view type")
//        }

        if (isGrid) {
            val binding = GridItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return GridMenuHolder(binding)
        }
        else {
            return when(viewType) {
                ITEM_HEADER -> {
                    return MenuHeaderHolder(ItemMenuHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
                }
                ITEM_MENU -> {
                    return LinearMenuHolder(LinearItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false))
                } else -> throw IllegalArgumentException("Undefined view type")
            }
        }
    }




    // Memberitahu banyaknya data yang akan ditampilkan
    override fun getItemCount(): Int {
        return data.size
    }

    // Melakukan penentuan data yang akan ditampilkan pada setiap item / baris
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder.itemViewType) {
//            ITEM_HEADER -> {
//                val headerHolder = holder as MenuHeaderHolder
//                headerHolder.bindContent(data[position] as String)
//            }
//            ITEM_MENU -> {
//                if (isGrid) {
//                    val gridHolder = holder as GridMenuHolder
//                    gridHolder.onBind(data[position] as MenuItem)
//                } else {
//                    val linearMenuHolder = holder as LinearMenuHolder
//                    linearMenuHolder.onBind(data[position] as MenuItem)
//                }
//            }
//        }

        if (isGrid) {
            val gridHolder = holder as GridMenuHolder
            gridHolder.onBind(data[position] as MenuItem)
        } else {
            when (holder.itemViewType) {
                ITEM_HEADER -> {
                    val headerHolder = holder as MenuHeaderHolder
                    headerHolder.bindContent(data[position] as String)
                }
                ITEM_MENU -> {
                    val linearMenuHolder = holder as LinearMenuHolder
                    linearMenuHolder.onBind(data[position] as MenuItem)
                }
            }
        }
    }
    inner class LinearMenuHolder(val binding: LinearItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MenuItem) {
            binding.imgPreview.setImageResource(data.itemPreview)
            binding.namaMenu.text = data.name
            binding.hargaMenu.text = "Rp. ${data.price.formatSepartor()}"
            val deskripsi = data.deskripsi.split(" ").take(8).joinToString(" ")
            binding.deskripsiMenu.text = "${deskripsi} ...."

            binding.cardMenuItem.setOnClickListener {
                itemClickListener.onItemMenuClick(data)
            }
        }
    }

    inner class GridMenuHolder(val binding: GridItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MenuItem) {
            binding.menuName.text = data.name
            binding.hargaMenu.text = "Rp. ${data.price.formatSepartor()}"
            binding.imgPreview.setImageResource(data.itemPreview)

            binding.cardMenuItem.setOnClickListener {
                itemClickListener.onItemMenuClick(data)
            }
        }
    }


    inner class MenuHeaderHolder(val binding: ItemMenuHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindContent(text: String) {
            binding.textHeader.text = text
        }
    }
}




