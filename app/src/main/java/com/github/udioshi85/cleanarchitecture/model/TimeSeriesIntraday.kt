package com.github.udioshi85.cleanarchitecture.model

import com.google.gson.annotations.SerializedName

class TimeSeriesIntraday(@SerializedName("Meta Data") val metadata: MetaData, @SerializedName("Time Series (5min)") val dates: Map<String, Any>) {

    class MetaData(@SerializedName("1. Information") val information: String,
                   @SerializedName("2. Symbol") val symbol: String,
                   @SerializedName("3. Last Refreshed") val lastRefreshed: String,
                   @SerializedName("4. Interval") val interval: String,
                   @SerializedName("5. Output Size") val outputSize: String,
                   @SerializedName("6. Time Zone") val timezone: String)
}