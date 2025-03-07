package com.yogaiw_18102180.praktikum8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sms_receiver.*

class SmsReceiverActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_receiver)

        val penipuan = arrayOf("hadiah", "blogspot", "wordpress", "pulsa", "selamat", "transfer", "mobil", "polisi", "rumah")

        title = getString(R.string.incoming_message)
        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)
        tv_from.text = getString(R.string.coming_from)+": "+senderNo
        tv_message.text = senderMessage
        btn_close.setOnClickListener {
            finish()
        }

        val splittedMsg = senderMessage.toString().toLowerCase().split(" ").toTypedArray()
        for(i in splittedMsg) {
            Log.d("TAG", i)
            for(j in penipuan) {
                if (i==j) {
                    Log.d("TAG", "indikasi")
                    tv_cek.text = getString(R.string.penipuan_true)
                    break
                } else {
                    tv_cek.text = getString(R.string.penipuan_false)
                }
            }
            break
        }
    }
}