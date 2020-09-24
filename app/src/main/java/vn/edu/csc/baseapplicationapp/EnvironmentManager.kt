package vn.edu.csc.baseapplicationapp

object EnvironmentManager {
    const val DEV_BASE_URL = ""
    const val TEST_BASE_URL = ""
    const val SANDBOX_BASE_URL = "https://run.mocky.io/"
    const val STAGING_BASE_URL = ""
    const val PRODUCTION_BASE_URL = ""

    val env: ENV = ENV.SANDBOX

    enum class ENV {
        DEV,
        TEST,
        SANDBOX,
        STAGING,
        PRODUCTION
    }
}