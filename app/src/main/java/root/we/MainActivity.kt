package root.we

import android.content.*
import android.os.*
import android.support.v7.app.*
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
        init()
        bt_main_set_start_count.setOnClickListener { presentor.showAlert() }
    }

    override fun onStart() {
        super.onStart()
        presentor.requestDateStr()?.let {
            if (!presentor.isServiceRunning()){ startService(Intent(this, DateCountService::class.java)) }
        }
    }

    private fun init(){
        presentor = MainPresentor(this)
        update()
    }

    fun update(){
        tv_main_show_count.text = presentor.requestCountStr()
        tv_main_show_start_date.visibility = View.GONE
        presentor.requestDateStr()?.let {
            tv_main_show_start_date.apply {
                text = "연애 시작일 : $it"
                visibility = View.VISIBLE
            }
        }
    }

}
