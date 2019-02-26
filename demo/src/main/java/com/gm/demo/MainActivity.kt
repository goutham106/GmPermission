package com.gm.demo

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gm.permission.GmPermissionManager
import com.gm.permission.PermissionListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var permissionManager: GmPermissionManager? = null

    private val snackBarContainer: View
        get() = container//window.decorView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }
    }


    fun singleCheck(v: View) {
        permissionManager = GmPermissionManager.builder()
            .with(this)
            .requestCode(102)
            .neededPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            )
            .setPermissionListner(object : PermissionListener {
                override fun onPermissionsGranted(requestCode: Int, acceptedPermission: String) {
                    Toast.makeText(this@MainActivity, "PERMISSION GRANTED", Toast.LENGTH_LONG).show()
                }

                override fun showGrantDialog(grantPermissionTo: String): Boolean {

                    Snackbar.make(
                        snackBarContainer,
                        permissionManager?.getPermissionMessageDialog(grantPermissionTo).toString(),
                        Snackbar.LENGTH_LONG
                    )
                        .setAction(getString(R.string.action_grant)) { permissionManager?.requestPermissions() }
                        .show()
                    return super.showGrantDialog(grantPermissionTo)
                }

                override fun showRationalDialog(requestCode: Int, deniedPermission: String): Boolean {
                    Snackbar.make(
                        snackBarContainer,
                        permissionManager?.getPermissionMessageDialog(deniedPermission).toString(),
                        Snackbar.LENGTH_LONG
                    )
                        .setAction(getString(R.string.action_settings)) { GmPermissionManager.gotoSettings(this@MainActivity) }
                        .show()
                    return super.showRationalDialog(requestCode, deniedPermission)
                }

            })
            .build()

        permissionManager?.requestPermissions()

    }

    fun multipleCheck(v: View) {
        permissionManager = GmPermissionManager.builder()
            .with(this)
            .requestCode(101)
            .neededPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            )
            .setPermissionListner(object : PermissionListener {
                override fun onPermissionsGranted(requestCode: Int, acceptedPermission: String) {
                    Toast.makeText(this@MainActivity, "PERMISSION GRANTED", Toast.LENGTH_LONG).show()
                }

                override fun showGrantDialog(grantPermissionTo: String): Boolean {


                    Snackbar.make(
                        snackBarContainer,
                        permissionManager?.getPermissionMessageDialog(grantPermissionTo).toString(),
                        Snackbar.LENGTH_INDEFINITE
                    )
                        .setAction(getString(R.string.action_grant)) { permissionManager?.requestPermissions() }
                        .show()
                    return super.showGrantDialog(grantPermissionTo)
                }

                override fun showRationalDialog(requestCode: Int, deniedPermission: String): Boolean {
                    Snackbar.make(
                        snackBarContainer,
                        permissionManager?.getPermissionMessageDialog(deniedPermission).toString(),
                        Snackbar.LENGTH_INDEFINITE
                    )
                        .setAction(getString(R.string.action_settings)) { GmPermissionManager.gotoSettings(this@MainActivity) }
                        .show()
                    return super.showRationalDialog(requestCode, deniedPermission)
                }

            })
            .build()

        permissionManager?.requestPermissions()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionManager?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
