package il.pacolo.com.appweather.playgrounds.patterns


import org.junit.Test


/*TODO
* example of builder pattern */

class Component private constructor(builder:Builder) {

    var name: String? = builder.name
    var lastName:String? = builder.lastName


    class Builder {
        internal var name: String? = null
            private set
        internal  var lastName:String? = null
            private set

        fun setName(name:String) = apply { this.name = name }
        fun setLastName(lastName:String) = apply { this.lastName = lastName }
        fun build() = Component(this)
    }
}





