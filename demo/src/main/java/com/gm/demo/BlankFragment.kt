package com.gm.demo


import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gm.permission.GmPermissionManager
import com.gm.permission.PermissionListener
import kotlinx.android.synthetic.main.content_main.*

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {

    var permissionManager: GmPermissionManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_single.setOnClickListener { singleCheck() }
        btn_multi.setOnClickListener { multipleCheck() }
    }


    private fun singleCheck() {
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
                    Toast.makeText(activity, "PERMISSION GRANTED", Toast.LENGTH_LONG).show()
                }

                override fun showGrantDialog(grantPermissionTo: String): Boolean {

                    (activity as FragmentActivity).openAlertDialog(
                        message = permissionManager?.getPermissionMessageDialog(grantPermissionTo).toString(),
                        positiveButtonName = getString(R.string.action_grant),
                        positiveListner = DialogInterface.OnClickListener { _, _ ->
                            permissionManager?.requestPermissions()
                        }
                    )

                    return super.showGrantDialog(grantPermissionTo)
                }

                override fun showRationalDialog(requestCode: Int, deniedPermission: String): Boolean {
                    (activity as FragmentActivity).openAlertDialog(
                        message = permissionManager?.getPermissionMessageDialog(deniedPermission).toString(),
                        positiveButtonName = getString(R.string.action_settings),
                        positiveListner = DialogInterface.OnClickListener { _, _ ->
                            GmPermissionManager.gotoSettings(activity as Activity)
                        }
                    )
                    return super.showRationalDialog(requestCode, deniedPermission)
                }

            })
            .build()

        permissionManager?.requestPermissions()

    }

    private fun multipleCheck() {
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
                    Toast.makeText(activity, "REQUEST : GRANTED", Toast.LENGTH_LONG).show()
                }

                override fun showGrantDialog(grantPermissionTo: String): Boolean {

                    (activity as FragmentActivity).openAlertDialog(
                        message = permissionManager?.getPermissionMessageDialog(grantPermissionTo).toString(),
                        positiveButtonName = getString(R.string.action_grant),
                        positiveListner = DialogInterface.OnClickListener { _, _ ->
                            permissionManager?.requestPermissions()
                        }
                    )
                    return super.showGrantDialog(grantPermissionTo)
                }

                override fun showRationalDialog(requestCode: Int, deniedPermission: String): Boolean {
                    (activity as FragmentActivity).openAlertDialog(
                        message = permissionManager?.getPermissionMessageDialog(deniedPermission).toString(),
                        positiveButtonName = getString(R.string.action_settings),
                        positiveListner = DialogInterface.OnClickListener { _, _ ->
                            GmPermissionManager.gotoSettings(activity as Activity)
                        }
                    )
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



}
