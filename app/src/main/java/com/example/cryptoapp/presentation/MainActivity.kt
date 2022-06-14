package com.example.cryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.presentation.adapters.CoinAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CoinAdapter(this)
        binding.rvCoinPriceList.adapter = adapter
        adapter.onCoinClickListener = {
            val intent = DetailActivity.newIntent(this@MainActivity, it.fromSymbol)
            startActivity(intent)
        }

        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this){
            adapter.submitList(it)
        }
    }
}