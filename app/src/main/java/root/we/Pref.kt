package root.we

import android.content.*

/**
 * Created by root1 on 2018. 3. 29..
 */
object Pref {

    private val dataID = "start_date"

    private fun getPr(context: Context) = context.getSharedPreferences("we_pr", Context.MODE_PRIVATE)

    fun getDate(context: Context): String = getPr(context).getString(dataID, "")

    fun saveDate(date: String, context: Context) = getPr(context).edit().apply { putString(dataID, date) }.apply()

    fun removeDate(context: Context) = getPr(context).edit().remove(dataID).apply()

}