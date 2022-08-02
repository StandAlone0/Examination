package com.example.examination

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.graphics.drawable.toDrawable
import com.example.examination.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = binding.toolbarMain.menu.add("Settings")
        val b = binding.toolbarMain.menu.add("Quit")

        binding.toolbarMain.setNavigationIcon(R.drawable.ic_baseline_menu_24)
        binding.toolbarMain.setNavigationOnClickListener {
            //Поместить ф-ю с вытягиванием Drawable layout
        }


        i.setShowAsAction(0)


        i.setOnMenuItemClickListener {
            val intent = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(intent)
            return@setOnMenuItemClickListener true
        }
        b.setOnMenuItemClickListener {

            return@setOnMenuItemClickListener true
        }
//        binding.toolbarMain.setMenu(MenuBuilder(this), )


        val home = binding.bottomNav.menu.add("Home")
        val map = binding.bottomNav.menu.add("Map")
        val profile = binding.bottomNav.menu.add("Profile")
        home.setIcon(R.drawable.ic_baseline_home_24)
        profile.setIcon(R.drawable.ic_baseline_person_24)
        map.setIcon(R.drawable.ic_baseline_map_24)

        binding.bottomNav.setBackgroundColor(getColor(R.color.green))



        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView, )


    }

}