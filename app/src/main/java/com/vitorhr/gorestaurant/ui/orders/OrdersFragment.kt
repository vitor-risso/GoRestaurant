package com.vitorhr.gorestaurant.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitorhr.gorestaurant.R
import com.vitorhr.gorestaurant.adapter.recyclerview.DishesRecyclerViewAdapter
import com.vitorhr.gorestaurant.databinding.FragmentOrdersBinding
import com.vitorhr.gorestaurant.model.Dish

class OrdersFragment : Fragment() {

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)

        val dishesItems = generateDishItems()
        val dishesAdapter = DishesRecyclerViewAdapter(dishesItems)

        binding.RVMyOrdersDishes.layoutManager = LinearLayoutManager(requireContext())
        binding.RVMyOrdersDishes.adapter = dishesAdapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun generateDishItems(): List<Dish> = listOf(
        Dish(
            R.drawable.souce_image,
            "Ao molho",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            1900,
        ),
        Dish(
            R.drawable.veggie_image,
            "Veggio",
            "Macarrão com pimentão, ervilha e ervas finas colhidas no himalaia.",
            2100
        ),
        Dish(
            R.drawable.shrimp_image,
            "A la Camarón",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            500
        ),
        Dish(
            R.drawable.souce_image,
            "Ao molho",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            1100
        ),
        Dish(
            R.drawable.veggie_image,
            "Veggio",
            "Macarrão com pimentão, ervilha e ervas finas colhidas no himalaia.",
            2150
        ),
        Dish(
            R.drawable.shrimp_image,
            "A la Camarón",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            9000
        )
    )
}