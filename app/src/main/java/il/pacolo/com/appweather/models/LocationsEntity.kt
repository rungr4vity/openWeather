package il.pacolo.com.appweather.models

import androidx.room.*


// entities = table
// attibutes = fields

@Entity(tableName = "locations")
data class LocationsEntity(

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    @ColumnInfo(name = "cityName")
    var cityName : String? = ""



) {
    // Room will use this no-argument constructor for querying
    constructor(cityName: String) : this(0,cityName)
}
