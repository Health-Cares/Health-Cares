package com.example.healthcare

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthcare.data.Medical
import com.example.healthcare.viewmodel.MedicalViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_add.*
import java.lang.System.exit
import java.util.*


const val NEW_MEDICAL_ACTIVITY_REQUEST_CODE = 1
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
    , HomeFragment.OnAddButtonClicked,HomeFragment.OnChildButtonClicked,HomeFragment.OnTreatButtonClicked
    ,HomeFragment.OnNewsButtonClicked,ChildFragment.OnOneImageButtonClicked, TreatFragment.OnToothacheImageButtonClicked{
    override fun onToothacheImageButtonClicked() {
        displayScreen(R.layout.fragment_toothache)
    }

    override fun onHeadacheImageButtonClicked() {
        displayScreen(R.layout.fragment_headache)
    }

    override fun onMuscleImageButtonClicked() {
        displayScreen(R.layout.fragment_muscle)
    }

    override fun onCommonImageButtonClicked() {
        displayScreen(R.layout.fragment_common)
    }

    override fun onAsthmaImageButtonClicked() {
        displayScreen(R.layout.fragment_asthma)
    }

    override fun onHeartImageButtonClicked() {
        displayScreen(R.layout.fragment_heart)
    }

    override fun onTwelveImageButtonClicked() {
        displayScreen(R.layout.fragment_twelve_month)
    }

    override fun onAboveImageButtonClicked() {
        displayScreen(R.layout.fragment_above_month)
           }


    override fun onSixImageButtonClicked() {
        displayScreen(R.layout.fragment_six_month)
    }

    override fun onOneImageButtonClicked() {

        displayScreen(R.layout.fragment_one_month)
}


    override fun onAddButtonClicked() {

        displayScreen(R.id.nav_med)
    }
    override fun onNewsButtonClicked() {
        displayScreen(R.id.nav_news)
    }

    override fun onTreatButtonCliked() {
        displayScreen(R.id.nav_treat)
    }

    override fun onTreatButtonClicked() {
        displayScreen(R.id.nav_treat)
    }

    override fun onChildButtonClicked() {
        displayScreen(R.id.nav_child)
    }

    lateinit var medicalViewModel: MedicalViewModel



    //lateinit var mbtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // loadLocate()
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val medicalViewModel = ViewModelProviders.of(this).get(MedicalViewModel::class.java)


        val medicalListAdapter = MedicalListAdapter(this)
        recycler_view.adapter = medicalListAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            val intent = Intent(this, NewMedicalActivity::class.java)
            startActivityForResult(intent, NEW_MEDICAL_ACTIVITY_REQUEST_CODE)
        }


//        medicalViewModel = ViewModelProviders.of(this).get(MedicalViewModel::class.java)
//
//        medicalViewModel.allMedical.observe(this, androidx.lifecycle.Observer { medicals ->
//            medicals?.let { medicalListAdapter.setMedicals(medicals) }
//        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == NEW_MEDICAL_ACTIVITY_REQUEST_CODE &&
            resultCode == Activity.RESULT_OK){
            val medical:Medical = data?.getSerializableExtra("MEDICAL") as Medical
            medicalViewModel.insertMedical(medical)
        }


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)

        }else{
            displayScreen(R.layout.fragment_home)
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
            builder.setMessage("Are you sure want to exit??")
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
            R.layout.fragment_one_month ->{
                OneMonthFragment()
            }
            R.layout.fragment_six_month ->{
                SixMonthFragment()
            }
            R.layout.fragment_twelve_month ->{
                TwelveMonthFragment()
            }
            R.layout.fragment_above_month ->{
                AboveMonthFragment()
            }
            R.layout.fragment_toothache ->{
                ToothacheFragment()
            }
            R.layout.fragment_headache ->{
                HeadacheFragment()
            }
            R.layout.fragment_muscle ->{
                MuscleFragment()
            }
            R.layout.fragment_common ->{
                CommonFragment()
            }
            R.layout.fragment_asthma ->{
                AsthmaFragment()
            }
            R.layout.fragment_heart ->{
                HeartFragment()
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



    private fun connected():Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }
}
