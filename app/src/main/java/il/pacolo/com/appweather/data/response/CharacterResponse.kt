package il.pacolo.com.appweather.data.response
import com.google.gson.annotations.SerializedName
import il.pacolo.com.appweather.data.Model

data class CharacterResponse(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("image") val image: String
){
    fun toPresentation(): Model {
        return Model(
            id = id,
            name = name,
            isAlive = "Alive",
            image = image

        )
    }
}