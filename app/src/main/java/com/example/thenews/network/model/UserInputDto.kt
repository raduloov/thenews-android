package com.example.thenews.network.model

import com.google.gson.annotations.SerializedName

data class UserInputDto(

    @SerializedName("q")
    var q: String? = null,

    @SerializedName("search_in")
    var searchIn: List<String>? = null,

    @SerializedName("lang")
    var lang: List<String>? = null,

    @SerializedName("not_lang")
    var not_lang: String? = null,

    @SerializedName("countries")
    var countries: List<String>? = null,

    @SerializedName("not_countries")
    var notCountries: List<String>? = null,

    @SerializedName("from")
    var from: String? = null,

    @SerializedName("to")
    var to: String? = null,

    @SerializedName("ranked_only")
    var rankedOnly: String? = null,

    @SerializedName("from_rank")
    var fromRank: Int? = null,

    @SerializedName("to_rank")
    var toRank: Int? = null,

    @SerializedName("sort_by")
    var sortBy: String? = null,

    @SerializedName("page")
    var page: Int? = null,

    @SerializedName("size")
    var size: Int? = null,

    @SerializedName("sources")
    var sources: List<String>? = null,

    @SerializedName("not_sources")
    var notSources: List<String>? = null,

    @SerializedName("topic")
    var topic: String? = null,

    @SerializedName("published_date_precision")
    var publishedDatePrecision: String? = null
)