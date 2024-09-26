import java.text.SimpleDateFormat
import java.util.Date


object AppConfiguration {
    const val COMPILE_SDK = 34
    const val TARGET_SDK = 34
    const val MIN_SDK = 26 // Android 8
    const val MAJOR_VERSION = 1
    const val MINOR_VERSION = 0
    const val PATCH_VERSION = 0
    const val VERSION_NAME = "$MAJOR_VERSION.$MINOR_VERSION.$PATCH_VERSION"
    const val VERSION_CODE = 1
    const val KOTLIN_COMPILER_VERSION = "1.5.1"

    fun getAppVersionCode(): String {
        return SimpleDateFormat("dd/MM/yyyy").format(Date())
    }
}

