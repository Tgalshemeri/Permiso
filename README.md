# Permiso


Permiso is an android library to make requesting permissions more simple and easier and using one single code.


## Installation

in ``` settings.gradle ``` :
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
in ```App build.gradle``` dependencies: 
```
	dependencies {
	        implementation 'com.github.Tgalshemeri:Permiso:1.0'
	}
```


## Usage:
- First you need to add permissions in ``` AndroidManifest.xml ```

```
<uses-permission android:name="android.permission.CAMERA"/>
    <uses-permission android:name="android.permission.READ_CONTACTS"/>
```
- Then you can use the library in this simple way:



```
        val arrayOfPerms = arrayOf(android.Manifest.permission.CAMERA , android.Manifest.permission.READ_CONTACTS)

        Permiso(activity).permissions(arrayOfPerms).request { allGranted, granted, denied ->
            if (allGranted){
                Toast.makeText(this , "All Permissions are granted." , Toast.LENGTH_LONG).show()
            }

        }
        
```

As you can see the callback will return three parameters:
- ```allGranted:``` returns true when all permissions are granted.
- ```granted:``` returns List of all granted permissions.
- ```denied:``` returns List of all denied permissions.

