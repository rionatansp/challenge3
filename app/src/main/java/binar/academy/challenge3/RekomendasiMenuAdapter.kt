package binar.academy.challenge3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.challenge3.databinding.RekomendasiItemMenuBinding

class RekomendasiMenuAdapter(val data: ArrayList<MenuItem>, private val itemClickListener: OnItemRekomendasiClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemRekomendasiClickListener {
        fun onItemRekomendasiClick(data: MenuItem)
    }

    // Membuat Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RekomendasiItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RekomendasiMenuHolder(binding)
    }

    // Memberitahu banyaknya data yang akan ditampilkan
    override fun getItemCount(): Int {
        return data.size
    }

    // Melakukan penentuan data yang akan ditampilkan pada setiap item / baris
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val rekomendasiMenuHolder = holder as RekomendasiMenuHolder
        rekomendasiMenuHolder.onBind(data[position])
    }

    inner class RekomendasiMenuHolder(val binding: RekomendasiItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MenuItem) {
            binding.menuName.text = data.name
            binding.imgPreview.setImageResource(data.itemPreview)

            binding.cardMenuItem.setOnClickListener {
                itemClickListener.onItemRekomendasiClick(data)
            }
        }
    }


}

