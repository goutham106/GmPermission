package com.gm.arctemplate.ui.permission

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 25/02/19.
 */
interface PermissionListener {
    fun onPermissionsGranted(requestCode: Int, acceptedPermission: String)

    //fun onPermissionsDenied(requestCode: Int, deniedPermission: String)

    fun showGrantDialog(grantPermissionTo: String): Boolean

    fun showRationalDialog(requestCode: Int, acceptedPermissionList: String): Boolean
}