package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.databinding.ActivitySplashBinding
import com.example.motivation.infra.MotivationContants
import com.example.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySplashBinding

    private lateinit var securityPreferences : SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        securityPreferences = SecurityPreferences(this)

        if( supportActionBar != null )
            supportActionBar!!.hide()

        binding.btnSave.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id
        if( id == R.id.btnSave)
            handleSave()
    }

    private fun handleSave(){
        val name = binding.editTxtName.text.toString()
        if(name != "") {
            securityPreferences.storeString(MotivationContants.KEY.PERSON_NAME, name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }else
            Toast.makeText(this, "Coloque o seu nome", Toast.LENGTH_LONG).show()

    }

}