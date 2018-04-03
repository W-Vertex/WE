package root.we

import android.content.*
import java.text.*
import java.util.*

/**
 * Created by root1 on 2018. 4. 1..
 */
object DateCountModel {

    private val dateKey = "we_date"

    private fun preference(context: Context) = context.getSharedPreferences("we_pref", Context.MODE_PRIVATE)

    fun getDateCount(context: Context): Int?{
        val dateStr = getDateStr(context)
        if(dateStr.isEmpty()){ return null }
        val date = SimpleDateFormat("yyyy년 MM월 dd일").parse(dateStr)
        return (Date().time - date.time).let { it / (86400000) + 1 }.toInt()
    }

    fun setDateStr(context: Context, dateStr: String) = preference(context).edit().putString(dateKey, dateStr).apply()

    fun getDateStr(context: Context) = preference(context).getString(dateKey, "")

}