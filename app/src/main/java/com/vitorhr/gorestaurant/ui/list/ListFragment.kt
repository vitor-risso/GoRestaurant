package com.vitorhr.gorestaurant.ui.list

import android.content.Intent
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
import com.vitorhr.gorestaurant.model.Dish
import com.vitorhr.gorestaurant.ui.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        setupCategoriesAdapter()

        setUpDishesAdapter()

        setUpLeaveAppButtonClickListener()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpLeaveAppButtonClickListener() {
        binding.IBLogout.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupCategoriesAdapter() {
        val categoriesItems = generateCategoriesItems()
        val categoriesAdapter = CategoriesRecyclerViewAdapter(categoriesItems)
        binding.RVCategories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.RVCategories.adapter = categoriesAdapter
    }

    private fun setUpDishesAdapter() {
        val dishesItems = generateDishItems()
        val dishesAdapter = DishesRecyclerViewAdapter(dishesItems, requireContext())
        binding.RVDishes.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.RVDishes.adapter = dishesAdapter
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