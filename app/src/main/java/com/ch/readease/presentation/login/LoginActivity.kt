package com.ch.readease.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ch.readease.databinding.ActivityLoginBinding
import com.ch.readease.network.firebase.auth.FirebaseAuthDataSourceImpl
import com.ch.readease.presentation.main.MainActivity
import com.ch.readease.presentation.register.RegisterActivity
import com.ch.readease.presentation.register.RegisterViewModel
import com.ch.readease.repository.UserRepositoryImpl
import com.ch.readease.utils.GenericViewModelFactory
import com.ch.readease.utils.proceedWhen
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val viewModel: LoginViewModel by viewModels {
        GenericViewModelFactory.create(createViewModel())
    }

    private fun createViewModel(): LoginViewModel {
        val firebaseAuth = FirebaseAuth.getInstance()
        val dataSource = FirebaseAuthDataSourceImpl(firebaseAuth)
        val repo = UserRepositoryImpl(dataSource)
        return LoginViewModel(repo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setNavigateButton()
        observeResult()
    }

    private fun observeResult() {
        viewModel.loginResult.observe(this) {
            it.proceedWhen (
                doOnSuccess = {
                    navigateToMain()
                },
                doOnError = {
                    Toast.makeText(
                        this,
                        "Login Failed : ${it.exception?.message.orEmpty()}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                doOnLoading = {
                }
            )
        }
    }

    private fun setNavigateButton() {
        binding.bDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
        binding.bLogin.setOnClickListener {
            doLogin()
        }
    }

    private fun navigateToMain(){
        startActivity(Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }

    private fun isFormValid(): Boolean {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        return checkEmailValidation(email) && checkPasswordValidation(password, binding.tilPassword)
    }

    private fun checkPasswordValidation(password: String, tilPassword: TextInputLayout): Boolean {
        return if (password.isEmpty()) {
            tilPassword.isErrorEnabled = true
            tilPassword.error = "Wrong password!"
            false
        } else {
            tilPassword.isErrorEnabled = false
            true
        }
    }

    private fun checkEmailValidation(email: String): Boolean {
        return if (email.isEmpty()) {
            binding.tilEmail.isErrorEnabled = true
            binding.tilEmail.error = "Wrong email!"
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.isErrorEnabled = true
            binding.tilEmail.error = "Email pattern not valid"
            false
        } else {
            binding.tilEmail.isErrorEnabled = false
            true
        }
    }

    private fun doLogin() {
        if (isFormValid()) {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            viewModel.doLogin(email, password)
        }
    }

}