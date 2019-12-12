package com.artemglotov.switchcase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.artemglotov.switchcase.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    private val balanceObserver = Observer<Float> { balance ->
        text_balance.text = getString(R.string.case_price_template, balance.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        onBackPressedDispatcher.addCallback(this) {
            navController.popBackStack() || super.onSupportNavigateUp() || run {
                finish()
                true
            }
        }

        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }

        viewModel.balance.observe(this, balanceObserver)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id in listOf(R.id.destination_sign_in, R.id.destination_sign_up)) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
