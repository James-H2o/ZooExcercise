package com.example.jameszooexcercise.data.model


import com.google.gson.annotations.SerializedName

data class AnimalsApiAnimal(
    @SerializedName("characteristics")
    val characteristics: Characteristics?,
    @SerializedName("locations")
    val locations: List<String?>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("taxonomy")
    val taxonomy: Taxonomy?
)
