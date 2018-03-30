package root.we
import android.app.*
import android.content.*
import android.widget.*

/**
 * Created by root1 on 2018. 3. 25..
 */
class MainPresentor(val activity: MainActivity) {

    fun isServiceRunning(): Boolean{
        val manager = activity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        return manager.getRunningServices(128)
                .map {
                    it.service.className == activity.getString(R.string.date_count_service_name)
                }
                .reduce{ b1, b2 -> b1 || b2 }
    }

    fun showAlert(){
        val calendar = CalendarView(activity)
                .apply {
                    setOnDateChangeListener({ view, year, month, dayOfMonth ->
                        Pref.saveDate("${year}년 ${month + 1}월 ${dayOfMonth}일", activity)
                    })
                }
        AlertDialog.Builder(activity)
                .setTitle("연애 시작일을 선택해주세요.")
                .setMessage("선택일을 클릭하면 자동으로 저장됩니다.")
                .setView(calendar)
                .setPositiveButton("확인",{ dialog, _ -> activity.update() })
                .create()
                .show()
    }

}