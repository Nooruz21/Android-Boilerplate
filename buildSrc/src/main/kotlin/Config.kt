import org.gradle.api.JavaVersion

object AndroidConfig {
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33

    const val release = "release"
    const val debug = "debug"
}

object Namespaces {
    const val app = "com.nooruz.boilerplate"
    const val data = "${app}.data"
}

object Options {
    val compileOptions = JavaVersion.VERSION_17
    const val kotlinOptions = "17"
}