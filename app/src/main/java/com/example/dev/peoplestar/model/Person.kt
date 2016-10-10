package com.example.dev.peoplestar.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import javax.annotation.Generated


@Generated("org.jsonschema2pojo")
class Person() {
    /**
     *
     * @return
     * The name
     */
    /**
     *
     * @param name
     * The name
     */
    @SerializedName("name")
    @Expose
    var name:String = ""
    /**
     *
     * @return
     * The height
     */
    /**
     *
     * @param height
     * The height
     */
    @SerializedName("height")
    @Expose
    var height:String = ""
    /**
     *
     * @return
     * The mass
     */
    /**
     *
     * @param mass
     * The mass
     */
    @SerializedName("mass")
    @Expose
    var mass:String = ""
    /**
     *
     * @return
     * The hairColor
     */
    /**
     *
     * @param hairColor
     * The hair_color
     */
    @SerializedName("hair_color")
    @Expose
    var hairColor:String = ""
    /**
     *
     * @return
     * The skinColor
     */
    /**
     *
     * @param skinColor
     * The skin_color
     */
    @SerializedName("skin_color")
    @Expose
    var skinColor:String = ""
    /**
     *
     * @return
     * The eyeColor
     */
    /**
     *
     * @param eyeColor
     * The eye_color
     */
    @SerializedName("eye_color")
    @Expose
    var eyeColor:String = ""
    /**
     *
     * @return
     * The birthYear
     */
    /**
     *
     * @param birthYear
     * The birth_year
     */
    @SerializedName("birth_year")
    @Expose
    var birthYear:String = ""
    /**
     *
     * @return
     * The gender
     */
    /**
     *
     * @param gender
     * The gender
     */
    @SerializedName("gender")
    @Expose
    var gender:String = ""
    /**
     *
     * @return
     * The homeworld
     */
    /**
     *
     * @param homeworld
     * The homeworld
     */
    @SerializedName("homeworld")
    @Expose
    var homeworld:String = ""
    /**
     *
     * @return
     * The films
     */
    /**
     *
     * @param films
     * The films
     */
    @SerializedName("films")
    @Expose
    var films:List<String> = ArrayList<String>()
    /**
     *
     * @return
     * The species
     */
    /**
     *
     * @param species
     * The species
     */
    @SerializedName("species")
    @Expose
    var species:List<String> = ArrayList<String>()
    /**
     *
     * @return
     * The vehicles
     */
    /**
     *
     * @param vehicles
     * The vehicles
     */
    @SerializedName("vehicles")
    @Expose
    var vehicles:List<String> = ArrayList<String>()
    /**
     *
     * @return
     * The starships
     */
    /**
     *
     * @param starships
     * The starships
     */
    @SerializedName("starships")
    @Expose
    var starships:List<String> = ArrayList<String>()
    /**
     *
     * @return
     * The created
     */
    /**
     *
     * @param created
     * The created
     */
    @SerializedName("created")
    @Expose
    var created:String = ""
    /**
     *
     * @return
     * The edited
     */
    /**
     *
     * @param edited
     * The edited
     */
    @SerializedName("edited")
    @Expose
    var edited:String = ""
    /**
     *
     * @return
     * The url
     */
    /**
     *
     * @param url
     * The url
     */
    @SerializedName("url")
    @Expose
    var url:String = ""
}