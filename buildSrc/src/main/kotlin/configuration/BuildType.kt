package configuration

interface BuildType {

    companion object {
        const val Debug = "debug"
        const val Release = "release"
    }

    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val baseUrl: String
}

object DebugBuildType : BuildType {
    override val isMinifyEnabled: Boolean = true

    override val isTestCoverageEnabled: Boolean = false

    const val applicationIdSuffix = ".debug"
    const val versionNameSuffix = "-DEBUG"

    override val baseUrl: String
        get() = "\"http://openlibrary.org/\""
}

object ReleaseBuildType : BuildType {
    override val isMinifyEnabled: Boolean = true
    override val isTestCoverageEnabled: Boolean = false

    override val baseUrl: String
        get() = "\"http://openlibrary.org/\""
}