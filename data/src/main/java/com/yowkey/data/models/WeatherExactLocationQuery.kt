package com.yowkey.data.models

data class WeatherExactLocationQuery (
    val latitude : Long=0,
    val longitude : Long=0,
)

data class WeatherSearchByCityQuery (val q : String="")

data class WeatherSearchByZipQuery (val q : String="")

data class WeatherSearchByPostCodeQuery (val q : String="")

data class WeatherSearchByPostalCodeQuery (val q : String="")

data class WeatherSearchAutomaticallyQuery (val q : String="auto:ip")
