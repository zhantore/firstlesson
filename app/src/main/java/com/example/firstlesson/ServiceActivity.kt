package com.example.firstlesson

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.firstlesson.helper_class.MyService

class ServiceActivity : AppCompatActivity() {

    val TASK1_CODE = 1
    val TASK2_CODE = 2
    val TASK3_CODE = 3

    val STATUS_START = 100
    val STATUS_FINISH = 200

    final val PARAM_TIME = "time"
    final val PARAM_TASK = "task"
    val PARAM_RESULT = "result"
    val PARAM_STATUS = "status"

    val BROADCAST_ACTION = "MyIntentFilter"

    val LOG_TAG = "ServiceActivity()"
    var tvTask1: TextView? = null
    var br: BroadcastReceiver? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        tvTask1 = findViewById(R.id.textView2)
        tvTask1!!.text = "Task1"

        // создаем BroadcastReceiver
        br = object : BroadcastReceiver() {
            // действия при получении сообщений
            override fun onReceive(context: Context?, intent: Intent) {
                val task = intent.getIntExtra(PARAM_TASK, 0)
                val status = intent.getIntExtra(PARAM_STATUS, 0)
                Log.d(LOG_TAG, "onReceive: task = $task, status = $status")

                // Ловим сообщения о старте задач
                if (status == STATUS_START) {
                    when (task) {
                        TASK1_CODE -> tvTask1!!.text = "Task1 start"
                    }
                }

                // Ловим сообщения об окончании задач
                if (status == STATUS_FINISH) {
                    val result = intent.getIntExtra(PARAM_RESULT, 0)
                    when (task) {
                        TASK1_CODE -> tvTask1!!.text = "Task1 finish, result = $result"
                    }
                }
            }
        }

        // создаем фильтр для BroadcastReceiver
        // создаем фильтр для BroadcastReceiver
        val intFilt = IntentFilter(BROADCAST_ACTION)
        // регистрируем (включаем) BroadcastReceiver
        // регистрируем (включаем) BroadcastReceiver
        registerReceiver(br, intFilt)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }

    fun onClickStart(v: View?) {
        // Создаем Intent для вызова сервиса,
        // кладем туда параметр времени и код задачи
        val intent: Intent = Intent(this, MyService::class.java).putExtra(PARAM_TIME, 7)
                .putExtra(PARAM_TASK, TASK1_CODE)
        // стартуем сервис
        startService(intent)
//        intent = Intent(this, MyService::class.java).putExtra(PARAM_TIME, 4)
//                .putExtra(PARAM_TASK, TASK2_CODE)
//        startService(intent)
//        intent = Intent(this, MyService::class.java).putExtra(PARAM_TIME, 6)
//                .putExtra(PARAM_TASK, TASK3_CODE)
//        startService(intent)
    }

}