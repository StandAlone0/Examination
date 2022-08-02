package com.example.examination

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.examination.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callAlert()

        binding.buttonAvatar.setOnClickListener {
            val pictures = arrayOf<Int> (R.drawable.person1,R.drawable.sergey,R.drawable.egor)
            binding.imageViewAvatar.setImageResource(pictures.random())
            binding.imageViewAvatar.visibility = View.VISIBLE
            //Сделать рандомную выборку из массива картинок
        }

        binding.buttonRegister.setOnClickListener {
            if (binding.buttonRegister.text == "Register") {
                if (binding.editTextPassword.text.toString() != binding.editTextRepeatPassword.text.toString()) {
                    binding.editTextPassword.text.clear()
                    binding.editTextRepeatPassword.text.clear()
                    binding.editTextRepeatPassword.error = "Invalid password"

                }else{
             Data.name = binding.editTextName.text.toString()
             Data.surname = binding.editTextSurname.text.toString()
             Data.login= binding.editTextLogin.text.toString()
             Data.password = binding.editTextPassword.text.toString()
             Data.imageId = binding.imageViewAvatar.id

                binding.apply {
                    buttonRegister.text = "Login"
                    editTextName.visibility = View.GONE
                    editTextSurname.visibility = View.GONE
                    buttonAvatar.visibility = View.INVISIBLE
                    editTextRepeatPassword.visibility = View.INVISIBLE
                    imageViewAvatar.visibility = View.INVISIBLE
                    editTextLogin.text.clear()
                    editTextPassword.text.clear()
                }
                }


            }else{
                if (binding.editTextLogin.text.toString() == Data.login && binding.editTextPassword.text.toString() == Data.password) {
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra(Data.signUpKeyword, Data.name)
                    i.putExtra(Data.signUpKeyword, Data.surname)
                    i.putExtra(Data.signUpKeyword, Data.imageId)
                    startActivity(i)
                }else{
                    binding.textViewError.visibility = View.VISIBLE
                    binding.textViewError.error = "Invalid password or login"
                    binding.editTextLogin.text.clear()
                    binding.editTextPassword.text.clear()
                }
            }


        }
    }
    private fun callAlert (){
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Notification")
        alert.setMessage("Have You entered for the first time?")
        alert.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
            binding.apply {
                editTextName.visibility = View.VISIBLE
                editTextSurname.visibility = View.VISIBLE
                editTextRepeatPassword.visibility = View.VISIBLE
                buttonAvatar.visibility = View.VISIBLE
                buttonRegister.text = "Register"
            }
        }
        alert.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
        }
        alert.show()
    }


}