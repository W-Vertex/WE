package root.we

import java.text.*
import java.util.*

/**
 * Created by root1 on 2018. 3. 29..
 */
object DateCount {

    fun getDateCount(dateStr: String): Int{
        val date = SimpleDateFormat("yyyy년 MM월 dd일").parse(dateStr)
        return (Date().time - date.time).let {
            it / (86400000) + 1
        }.toInt()
    }

}