package com.example.dev.peoplestar.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import javax.annotation.Generated

@Generated("org.jsonschema2pojo")
class Planet {

    /**

     * @return
     * * The name
     */
    /**

     * @param name
     * * The name
     */
    @SerializedName("name")
    @Expose
    var name: String? = null
    /**

     * @return
     * * The rotationPeriod
     */
    /**

     * @param rotationPeriod
     * * The rotation_period
     */
    @SerializedName("rotation_period")
    @Expose
    var rotationPeriod: String? = null
    /**

     * @return
     * * The orbitalPeriod
     */
    /**

     * @param orbitalPeriod
     * * The orbital_period
     */
    @SerializedName("orbital_period")
    @Expose
    var orbitalPeriod: String? = null
    /**

     * @return
     * * The diameter
     */
    /**

     * @param diameter
     * * The diameter
     */
    @SerializedName("diameter")
    @Expose
    var diameter: String? = null
    /**

     * @return
     * * The climate
     */
    /**

     * @param climate
     * * The climate
     */
    @SerializedName("climate")
    @Expose
    var climate: String? = null
    /**

     * @return
     * * The gravity
     */
    /**

     * @param gravity
     * * The gravity
     */
    @SerializedName("gravity")
    @Expose
    var gravity: String? = null
    /**

     * @return
     * * The terrain
     */
    /**

     * @param terrain
     * * The terrain
     */
    @SerializedName("terrain")
    @Expose
    var terrain: String? = null
    /**

     * @return
     * * The surfaceWater
     */
    /**

     * @param surfaceWater
     * * The surface_water
     */
    @SerializedName("surface_water")
    @Expose
    var surfaceWater: String? = null
    /**

     * @return
     * * The population
     */
    /**

     * @param population
     * * The population
     */
    @SerializedName("population")
    @Expose
    var population: String? = null
    /**

     * @return
     * * The residents
     */
    /**

     * @param residents
     * * The residents
     */
    @SerializedName("residents")
    @Expose
    var residents: List<String> = ArrayList()
    /**

     * @return
     * * The films
     */
    /**

     * @param films
     * * The films
     */
    @SerializedName("films")
    @Expose
    var films: List<String> = ArrayList()
    /**

     * @return
     * * The created
     */
    /**

     * @param created
     * * The created
     */
    @SerializedName("created")
    @Expose
    var created: String? = null
    /**

     * @return
     * * The edited
     */
    /**

     * @param edited
     * * The edited
     */
    @SerializedName("edited")
    @Expose
    var edited: String? = null
    /**

     * @return
     * * The url
     */
    /**

     * @param url
     * * The url
     */
    @SerializedName("url")
    @Expose
    var url: String? = null

}