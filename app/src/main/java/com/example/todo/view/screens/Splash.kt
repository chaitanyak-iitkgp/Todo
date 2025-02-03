package com.example.todo.view.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.todo.R
import com.example.todo.utils.ToastUtils
import com.example.todo.utils.constants.Status
import com.example.todo.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Splash : AppCompatActivity() {

    private val UserViewModel by viewModels<UserViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycleScope.launch {
            UserViewModel.getActiveUser(this@Splash)
        }
    }

    override fun onResume() {
        super.onResume()
        UserViewModel.activeUser.observe(this) {
            when (it.status) {
                Status.ERROR -> {
                    ToastUtils.shortToast(this, "${it.errorModel?.message}")
                    goToLogin()
                }

                Status.SUCCESS -> {
                    goToHome()
                }

                else -> {

                }
            }
        }
    }

    private fun goToLogin() {
        val intent = Intent(this, Login::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        startActivity(intent)
        finish()
    }


    private fun goToHome() {
        val intent = Intent(this, Listing::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
}