package Data

class Percent(v: Int) {
    var value = v.coerceIn(0, 100)
    fun toDouble() : Double {
        return value.toDouble()
    }
    operator fun minus(v: Int) = Percent(value - v)
    operator fun plus(v: Int) = Percent(value + v)
}





