GmPermission
=======
It is easy to handle the runtime permission


## How to build

Add Jitpack.io to your project level build.gradle file 
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
  
Add the dependency
```gradle
dependencies {
    implementation 'com.github.goutham106:runtimepermission:0.2'
	}
```
  
## How to use
  
Create a `GmPermissionManager` object
  
```kotlin
 val permissionManager = GmPermissionManager.builder()
            .with(this)
            .requestCode(REQUEST_CODE)
            .neededPermissions(<IMPLEMENT_NEEDED PERMISSIONS IN STRING ARRAY>)
            .setPermissionListner(object : PermissionListener {
                override fun onPermissionsGranted(requestCode: Int, acceptedPermission: String) {   
			<ON PERMISSION GRANTED>
                }

                override fun showGrantDialog(grantPermissionTo: String): Boolean {
			<IMPLEMENT Snackbar/Dialog to show when permission denied>
                    return super.showGrantDialog(grantPermissionTo)
                }

                override fun showRationalDialog(requestCode: Int, deniedPermission: String): Boolean {
			<IMPLEMENT Snackbar/Dialog to show when permission denied with Don't ask again,Usually goto setting menu>
			
                    return super.showRationalDialog(requestCode, deniedPermission)
                }
            })
            .build()
                
 ```
 override 
```kotlin
override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionManager?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
```  
 
 and when you want to ask for the permission just call
 ```kotlin
permissionManager?.requestPermissions()
 ```




Detailed full sample project is included. Check [MainActivity](https://github.com/goutham106/GmPermission/blob/master/demo/src/main/java/com/gm/demo/MainActivity.kt) for full implemetation 
