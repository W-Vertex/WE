package root.we

import android.app.*
import android.content.*
import android.os.*
import me.leolin.shortcutbadger.*
import java.util.*



/**
 * Created by root1 on 2018. 3. 25..
 */
class DateCountService: Service() {

    override fun onBind(intent: Intent): IBinder? = null
    lateinit var timer: Timer

    override fun onCreate() {
        super.onCreate()
        timer = Timer()
        setBadge()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        timer.schedule(object: TimerTask(){
            override fun run() {
                setBadge()
            }
        }, getTime(), 1000 * 60 * 24)
        return START_STICKY
    }

    private fun setBadge(){
        DateCountModel.getDateCount(this)?.let {
            ShortcutBadger.applyCount(this, it)
        }
    }

    private fun getTime(): Long{
        val today = Date()
        val nextDay = Date(today.year, today.month, today.date).time + 86400000
        return nextDay - today.time
    }

}