package com.example.healthcare

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import java.lang.System.exit
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {//, HomeFragment.OnAddButtonClicked{
    //override fun onAddButtonClicked() {


//            val addIntent = Intent(this, AddFragment::class.java)
//            startActivity(addIntent)
//
//    }

    //lateinit var mbtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // loadLocate()
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        val actionBar = supportActionBar
//        actionBar!!.title = resources.getString(R.string.app_name)
//
//
//        mbtn = findViewById(R.id.mChangeLang)
//
//        mbtn.setOnClickListener {
//
//            showChangeLang()
//        }



        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)
    }

//    private fun showChangeLang() {
//
//        val listItems = arrayOf("English","عربى","አማርኛ")
//
//        val mBuilder = AlertDialog.Builder(this@MainActivity)
//        mBuilder.setTitle("Choose Language")
//        mBuilder.setSingleChoiceItems(listItems, -1) { dialog, which ->
//            if (which == 0) {
//                setLocate("ar")
//                recreate()
//            } else if (which == 1) {
//                setLocate("am")
//                recreate()
//            }else if (which==2){
//                setLocate("en")
//                recreate()
//            }
//            dialog.dismiss()
//
//        }
//        val mDialog = mBuilder.create()
//        mDialog.show()
//    }


//    private fun setLocate(Lang:String){
//
//        val locale = Locale(Lang)
//        Locale.setDefault(locale)
//
//        val config = Configuration()
//
//        config.locale = locale
//        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
//
//        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
//        editor.putString("My_Lang", Lang)
//        editor.apply()
//
//        }
//
//    private fun loadLocate(){
//        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
//        val language = sharedPreferences.getString("My_Lang","")
//        setLocate(language)
//    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)

        } else {
            super.onBackPressed()
            exit(0)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(item.itemId == R.id.action_settings){
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Are you sure want to exit")
            builder.setCancelable(true)
            builder.setNegativeButton("No") { dialog, i -> dialog.cancel() }

            builder.setPositiveButton("Yes") { dialog, i -> finish() }
            val alertDialog = builder.create()
            alertDialog.show()


        }
        return super.onOptionsItemSelected(item)
    }

    fun displayScreen(id: Int){
        val fragment = when(id){
            R.id.nav_home ->{
                HomeFragment()
            }
            R.id.nav_med -> {
                AddFragment()
            }
            R.id.nav_child ->{
                ChildFragment()
            }
            R.id.nav_treat ->{
                TreatFragment()
            }
            R.id.nav_news ->{
                NewsFragment()
            }
            R.id.nav_contact ->{
                ContactFragment()
            }
            R.id.nav_about ->{
                AboutFragment()
            }
            else -> {
                HomeFragment()
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.relativelayout, fragment)
            .commit()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        displayScreen(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
