package com.vitorhr.gorestaurant.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vitorhr.gorestaurant.databinding.ActivityLoginBinding
import com.vitorhr.gorestaurant.ui.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val viewModel by viewModel<LoginViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater).apply {
            viewModel = this@LoginActivity.viewModel
        }

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setUpObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpObservers() {
        viewModel.navigate.observe(this) {
            if (it) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }
}