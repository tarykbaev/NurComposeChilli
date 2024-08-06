import java.text.SimpleDateFormat
import java.util.Date


object Configuration {
    const val COMPILE_SDK = 34
    const val TARGET_SDK = 34
    const val MIN_SDK = 24 // Android 7
    const val MAJOR_VERSION = 1
    const val MINOR_VERSION = 0
    const val PATCH_VERSION = 0
    const val VERSION_NAME = "$MAJOR_VERSION.$MINOR_VERSION.$PATCH_VERSION"
    const val VERSION_CODE = 1

    fun getAppVersionCode(): String {
        return SimpleDateFormat("dd/MM/yyyy").format(Date())
    }
}

