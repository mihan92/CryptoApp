package com.example.cryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.domain.CoinInfo
import com.squareup.picasso.Picasso

class CoinAdapter(private val context: Context) :
    ListAdapter<CoinInfo, CoinAdapter.CoinViewHolder>(CoinInfoDiffCallback()) {

    var onCoinClickListener: ((CoinInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = getItem(position)
        holder.binding.tvSymbols.text =
            context.getString(R.string.symbols_template, coin.fromSymbol, coin.toSymbol)
        holder.binding.tvPrice.text = coin.price.toString()
        holder.binding.tvLastUpdate.text =
            context.getString(
                R.string.last_update_template,
                coin.lastUpdate
            )
        holder.itemView.setOnClickListener {
            onCoinClickListener?.invoke(coin)
        }
        Picasso.get().load(coin.imageUrl).into(holder.binding.ivLogoCoin)
    }

    class CoinViewHolder(val binding: ItemCoinInfoBinding) : RecyclerView.ViewHolder(binding.root)
}