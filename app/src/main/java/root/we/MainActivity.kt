package root.we

import android.content.*
import android.os.*
import android.support.v7.app.*
import android.util.*
import android.view.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by root1 on 2018. 3. 25..
 */

class MainActivity: AppCompatActivity(){

    lateinit var presentor: MainPresentor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presentor = MainPresentor(this)
        update()
        bt_main_set_start_count.setOnClickListener { presentor.showAlert() }
    }

    fun update(){
        val date = Pref.getDate(this)
        if(date.isEmpty()){
            tv_main_show_count.text = "연애 시작일이 등록되지 않았습니다."
            tv_main_show_start_date.visibility = View.GONE
        }else{
            tv_main_show_count.text = "애인과 현재 ${DateCount.getDateCount(date)}일이 되셨습니다."
            tv_main_show_start_date.text = "연애 시작일 : ${date}"
            Log.d("xxx", presentor.isServiceRunning().toString())
            if(!presentor.isServiceRunning()){ startService(Intent(this, DateCountService::class.java)) }
        }
    }



}
