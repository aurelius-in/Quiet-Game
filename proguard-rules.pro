# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\<user>\AppData\Local\Android\Sdk\tools\proguard\proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# Keep the support library fragments
-keep public class * extends androidx.fragment.app.Fragment
-keep public class * extends androidx.appcompat.app.ActionBarDrawerToggle
-keep public class * extends androidx.recyclerview.widget.RecyclerView.Adapter
-keep public class * extends androidx.appcompat.widget.Toolbar

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Retrofit specific classes
-keep class com.google.gson.annotations.SerializedName
-keep class retrofit2.** { *; }
-keepclassmembers class retrofit2.** { *; }

# OkHttp specific classes
-dontwarn okhttp3.logging.**
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }

# Glide specific classes
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# Facebook SDK specific classes
-keep class com.facebook.* {
    *;
}

# Ignore warnings for various support libraries
-dontwarn androidx.appcompat.**
-dontwarn androidx.cardview.**
-dontwarn androidx.constraintlayout.**
-dontwarn androidx.recyclerview.**
-dontwarn androidx.annotation.**
-dontwarn androidx.lifecycle.**
-dontwarn androidx.navigation.**
