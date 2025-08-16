package com.yowkey.network

enum class APIEnvi(val url: String) {
    DEBUG("https://api.weatherapi.com"),
    RELEASE("https://api.weatherapi.com");

    companion object {
        fun fromString(envString: String?): APIEnvi {
            return entries.find { it.name.equals(envString, ignoreCase = true) } ?: RELEASE
        }
    }
}

val CURRENT_API_ENV: APIEnvi = APIEnvi.fromString(BuildConfig.API_ENV)

val BASE_URL: String = CURRENT_API_ENV.url
