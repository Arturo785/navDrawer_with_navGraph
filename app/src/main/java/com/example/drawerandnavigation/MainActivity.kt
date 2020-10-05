package com.example.drawerandnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //This thing is for control the hamburger
    lateinit var toogle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        //This sets the drawer layout and the listener of the hamburger
        toogle = ActionBarDrawerToggle(this,navigation_drawer_layout,R.string.open,R.string.close)
        navigation_drawer_layout.addDrawerListener(toogle)
        toogle.syncState()

        //hide some items
        hideSomeItems()

        //To make the hamburger appear
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //This sets the navigation of the navGraph
        nav_view.setupWithNavController(myNavHostFragment.findNavController())
    }

    //To detect clicks on the hamburger
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (navigation_drawer_layout.isDrawerOpen(GravityCompat.START)){
            navigation_drawer_layout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }

    private fun hideSomeItems(){
        val menu = nav_view.menu
        menu.findItem(R.id.nav_send).isVisible = false
    }
}
