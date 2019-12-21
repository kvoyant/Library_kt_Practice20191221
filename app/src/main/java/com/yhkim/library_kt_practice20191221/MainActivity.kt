package com.yhkim.library_kt_practice20191221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
//        Glide.with(mContext).load("https://m1.daumcdn.net/cfile297/image/990F2A425D0A96F10A7E54").into(profileImage)
        Glide.with(mContext).load("http://m1.daumcdn.net/cfile297/image/990F2A425D0A96F10A7E54").into(profileImage)
    }

}
