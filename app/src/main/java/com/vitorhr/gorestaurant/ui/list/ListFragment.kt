package com.vitorhr.gorestaurant.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitorhr.gorestaurant.R
import com.vitorhr.gorestaurant.adapter.recyclerview.CategoriesRecyclerViewAdapter
import com.vitorhr.gorestaurant.adapter.recyclerview.DishesRecyclerViewAdapter
import com.vitorhr.gorestaurant.databinding.FragmentListBinding
import com.vitorhr.gorestaurant.model.Categories
import com.vitorhr.gorestaurant.model.Dishes
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.init()
        _binding = FragmentListBinding.inflate(inflater, container, false)

        val categoriesItems = generateCategoriesItems()
        val categoriesAdapter = CategoriesRecyclerViewAdapter(categoriesItems)
        binding.RVCategories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.RVCategories.adapter = categoriesAdapter

        val dishesItems = generateDishItems()
        val dishesAdapter = DishesRecyclerViewAdapter(dishesItems)
        binding.RVDishes.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.RVDishes.adapter = dishesAdapter

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun generateCategoriesItems(): List<Categories> = listOf(
        Categories(
            R.drawable.pasta_icon,
            "Massas"
        ),
        Categories(
            R.drawable.pizza_icon,
            "Pizzas"
        ),
        Categories(
            R.drawable.meat_icon,
            "Carnes"
        ),

        Categories(
            R.drawable.pasta_icon,
            "Massas"
        ),
        Categories(
            R.drawable.pizza_icon,
            "Pizzas"
        ),
        Categories(
            R.drawable.meat_icon,
            "Carnes"
        )
    )

    private fun generateDishItems(): List<Dishes> = listOf(
        Dishes(
            R.drawable.souce_image,
            "Ao molho",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            "19,90"
        ),
        Dishes(
            R.drawable.veggie_image,
            "Veggio",
            "Macarrão com pimentão, ervilha e ervas finas colhidas no himalaia.",
            "21,90"
        ),
        Dishes(
            R.drawable.shrimp_image,
            "A la Camarón",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            "50,90"
        ),
        Dishes(
            R.drawable.souce_image,
            "Ao molho",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            "119,90"
        ),
        Dishes(
            R.drawable.veggie_image,
            "Veggio",
            "Macarrão com pimentão, ervilha e ervas finas colhidas no himalaia.",
            "221,90"
        ),
        Dishes(
            R.drawable.shrimp_image,
            "A la Camarón",
            "Macarrão ao molho branco, fughi e cheiro verde das montanhas.",
            "520,90"
        )
    )
}