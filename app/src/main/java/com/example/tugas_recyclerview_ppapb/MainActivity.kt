package com.example.tugas_recyclerview_ppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugas_recyclerview_ppapb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnlgn.setOnClickListener{
                val username = usernamelgn.text.toString()
                val password = passwordlgn.text.toString()

                if (username == "Muflih Raihan" && password == "12345"){
                    val intentToHomeActivity =
                        Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intentToHomeActivity)
                }
                else{
                    Toast.makeText(this@MainActivity, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}