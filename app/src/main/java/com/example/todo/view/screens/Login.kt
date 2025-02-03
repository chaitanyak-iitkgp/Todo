package com.example.todo.view.screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.R
import com.example.todo.data.local.SecureStorage
import com.example.todo.utils.SharedPrefUtils
import com.example.todo.utils.ToastUtils
import com.example.todo.utils.constants.Status
import com.example.todo.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Login : AppCompatActivity() {

    private val loginViewModel by viewModels<LoginViewModel>()
    private lateinit var loginButton: Button
    private lateinit var loadingIndicator: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById<Button>(R.id.btn_login)
        loadingIndicator = findViewById(R.id.loadingIndicator)

        loginButton.setOnClickListener { tryLoginUser() }

    }

    private fun tryLoginUser() {
        val username: String = findViewById<EditText>(R.id.editText_username).getText().toString()
        val password: String = findViewById<EditText>(R.id.editText_password).getText().toString()
        loginViewModel.loginUser(this,username, password)
    }

    override fun onResume() {
        super.onResume()
        loginViewModel.loginState.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    hideLoginButton()
                }

                Status.ERROR -> {
                    ToastUtils.shortToast(this, "${it.errorModel?.message}")
                    showLoginButton()
                }

                Status.SUCCESS -> {
                    ToastUtils.shortToast(this, "Login successful")
                    goToHomePage()
                }

                else -> {

                }
            }
        }
    }

    private fun hideLoginButton() {
        loginButton.isEnabled = false
        loadingIndicator.visibility = View.VISIBLE
        loginButton.text =
            ""  // Optional: You can replace the text with an empty string or a custom string
    }

    private fun showLoginButton() {
        loadingIndicator.visibility = View.GONE
        loginButton.isEnabled = true
        loginButton.text = "Login"  // Restore the button text
    }


    private fun goToHomePage() {
        val intent = Intent(this, Listing::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()


    }

}