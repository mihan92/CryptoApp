package com.example.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra(KEY)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(KEY) ?: ""


        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(this) {
            binding.tvPrice.text = it.price.toString()
            binding.tvMinPrice.text = it.lowDay.toString()
            binding.tvMaxPrice.text = it.highDay.toString()
            binding.tvLastMarket.text = it.lastMarket
            binding.tvLastUpdate.text = it.lastUpdate
            binding.tvFromSymbol.text = it.fromSymbol
            binding.tvToSymbol.text = it.toSymbol
            Picasso.get().load(it.imageUrl).into(binding.ivLogoCoin)

        }
    }

    companion object {
        private const val KEY = "key"

        fun newIntent(context: Context, fSymbol: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY, fSymbol)
            return intent
        }
    }
}