# Kotlin Serialization (최소)
-keepclassmembers class ** {
    @kotlinx.serialization.Serializable <fields>;
}

# Hilt
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }

# Inject 생성자 유지
-keepclassmembers class * {
    @javax.inject.Inject <init>(...);
}
