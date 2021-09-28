package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationContants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityMainBinding

    private lateinit var securityPreferences : SecurityPreferences
    private var mPhraseFilter : Int = MotivationContants.PHRASEFILTER.INFINITY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        securityPreferences = SecurityPreferences(this)
        val name = securityPreferences.getString("name")
        binding.txtName.setText("Olá, $name!")
        handleNewPhrase()

        binding.btnNewPhrase.setOnClickListener(this)
        binding.imgInfinity.setOnClickListener(this)
        binding.imgHappy.setOnClickListener(this)
        binding.imgSunn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        val listIdImgs = listOf(R.id.imgInfinity, R.id.imgHappy, R.id.imgSunn)

        if(id==R.id.btnNewPhrase){
            handleNewPhrase()
        }else if(id in listIdImgs){
            handleFilter(id)
        }
    }

    private fun handleFilter(id : Int) {
        when(id){
            R.id.imgInfinity -> {
                mPhraseFilter = MotivationContants.PHRASEFILTER.INFINITY
                binding.imgInfinity.setColorFilter(resources.getColor(R.color.colorAccent))
                binding.imgSunn.setColorFilter(resources.getColor(R.color.white))
                binding.imgHappy.setColorFilter(resources.getColor(R.color.white))
            }

            R.id.imgHappy -> {
                mPhraseFilter = MotivationContants.PHRASEFILTER.HAPPY
                binding.imgInfinity.setColorFilter(resources.getColor(R.color.white))
                binding.imgSunn.setColorFilter(resources.getColor(R.color.white))
                binding.imgHappy.setColorFilter(resources.getColor(R.color.colorAccent))
            }

            R.id.imgSunn -> {
                mPhraseFilter = MotivationContants.PHRASEFILTER.SUNN
                binding.imgInfinity.setColorFilter(resources.getColor(R.color.white))
                binding.imgSunn.setColorFilter(resources.getColor(R.color.colorAccent))
                binding.imgHappy.setColorFilter(resources.getColor(R.color.white))
            }
        }
    }

    private fun handleNewPhrase() {
        binding.txtStatus.text = Mock().getPhrase(mPhraseFilter)
    }
}