package com.vitorhr.gorestaurant.ui.itemdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitorhr.gorestaurant.adapter.recyclerview.AdditionalRecyclerViewAdapter
import com.vitorhr.gorestaurant.databinding.ActivityItemDetailsBinding
import com.vitorhr.gorestaurant.listener.AdditionalClickListener
import com.vitorhr.gorestaurant.model.AdditionalItem
import com.vitorhr.gorestaurant.model.Dish
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.text.DecimalFormat

class ItemDetailsActivity : AppCompatActivity() {

    private var _binding: ActivityItemDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ItemDetailsViewModel> {

        val image = intent.getIntExtra("IMAGE_ID", 0)
        val title = intent.getStringExtra("TITLE")
        val description = intent.getStringExtra("DESCRIPTION")
        val price = intent.getIntExtra("ORIGINAL_PRICE", 0)

        parametersOf(
            Dish(
                image,
                title ?: "",
                description ?: "",
                price
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityItemDetailsBinding.inflate(layoutInflater).apply {
            viewModel = this@ItemDetailsActivity.viewModel
            lifecycleOwner = this@ItemDetailsActivity
        }
        val image = intent.getIntExtra("IMAGE_ID", 0)
        val title = intent.getStringExtra("TITLE")
        val description = intent.getStringExtra("DESCRIPTION")
        val price = intent.getIntExtra("ORIGINAL_PRICE", 0)

        binding.IVArrowBack.setOnClickListener {
            finish()
        }


        binding.TVDishTitle.text = title
        binding.TVDescription.text = description
        binding.IVDish.setImageResource(image)
        val formatter = DecimalFormat("##,##")
        binding.TVPrice.text = formatter.format(price)

        val additionalItems = getAdditionalItems()
        val onDecrementClickListener = createOnDecrementClickListener()
        val onIncrementClickListener = createOnIncrementClickListener()
        val additionalRecyclerViewAdapter = AdditionalRecyclerViewAdapter(
            additionalItems,
            onDecrementClickListener,
            onIncrementClickListener
        )

        binding.RVAdditionals.layoutManager = LinearLayoutManager(this)
        binding.RVAdditionals.adapter = additionalRecyclerViewAdapter

        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

    private fun createOnDecrementClickListener() = AdditionalClickListener { priceIncents ->
        viewModel.decrementFromTotalPrice(priceIncents)
    }

    private fun createOnIncrementClickListener() = AdditionalClickListener { priceIncents ->
        viewModel.incrementToTotalPrice(priceIncents)
    }


    private fun getAdditionalItems() = listOf(
        AdditionalItem(
            "Bacon",
            500
        ),
        AdditionalItem(
            "Limão siciliano",
            250
        ),
        AdditionalItem(
            "Tomate", 350
        ),
        AdditionalItem(
            "Molho branco",
            450
        )
    )
}