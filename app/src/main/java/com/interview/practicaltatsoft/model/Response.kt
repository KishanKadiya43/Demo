package com.interview.practicaltatsoft.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(

    @SerializedName("per_page")
    @Expose
    val perPage: Int? = null,

    @SerializedName("total")
    @Expose
    val total: Int? = null,

    @SerializedName("data")
    @Expose
    val data: List<DataItem?>? = null,

    @SerializedName("page")
    @Expose
    val page: Int? = null,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int? = null,

    @SerializedName("support")
    @Expose
    val support: Support? = null
)

data class Support(

    @SerializedName("text")
    @Expose
    val text: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null
)

data class DataItem(

    @SerializedName("last_name")
    @Expose
    val lastName: String? = null,

    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("avatar")
    @Expose
    val avatar: String? = null,

    @SerializedName("first_name")
    @Expose
    val firstName: String? = null,

    @SerializedName("email")
    @Expose
    val email: String? = null
)
