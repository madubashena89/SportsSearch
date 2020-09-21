package top.stores.sportssearch.view

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import top.stores.sportssearch.R

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_sports -> {
                moveToFragment(SportFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.nav_leagues -> {
                moveToFragment(LeagueFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                moveToFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(!AppController.applicationContext().isNetworkAvailable(applicationContext)){
            showDialog()
        }
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        moveToFragment(SportFragment())
    }



    private fun moveToFragment(fragment : Fragment){
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }


    private fun showDialog(){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Please check the internet connection for the device.")
            .setCancelable(false)
            .setPositiveButton("Ok", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("You are offline!!")
        alert.show()
    }
}