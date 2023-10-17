pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")
        maven(url = "https://devrepo.kakao.com/nexus/repository/kakaomap-releases/")
        maven(url = "https://naver.jfrog.io/artifactory/maven/")

        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Tachi"
include(":app")
include(":presentation")
include(":data")
include(":domain")
