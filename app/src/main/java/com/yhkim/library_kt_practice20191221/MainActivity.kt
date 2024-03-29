package com.yhkim.library_kt_practice20191221

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        profileImage.setOnClickListener {
            val intent = Intent(mContext,LargeProfileImageActivity::class.java)
            intent.putExtra("imgUrl","https://m1.daumcdn.net/cfile297/image/990F2A425D0A96F10A7E54")
            startActivity(intent)
        }

        //https://gun0912.tistory.com/61
        // 마시벨로6 이상에서는 권한때문에 앱이 죽어버리므로 개발시 꼭 권한동의를 받는 알림을 넣어야 하므로 테드퍼미션을 사용한다.
        callBtn.setOnClickListener {

//            전화 권한 요청 (3) => 획득 완료되면 (1) => 인텐트를 이용해서 전화걸기 (2)

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한획득에 성공한 상태

                    var uri = Uri.parse("tel:01065781700")
                    val intent  = Intent(Intent.ACTION_CALL, uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화 권한을 허용해야 걸 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("권한설정이 필요합니다.")
                .setRationaleMessage("바로 전화를 걸기 위해 필요합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE) //ctrl + Alt = o : import 정리
                .check()

        }
    }

    override fun setValues() {
        Glide.with(mContext).load("https://m1.daumcdn.net/cfile297/image/990F2A425D0A96F10A7E54").into(profileImage)

        //움직이는 gif 적용은 ??
//        Glide.with(mContext).load("http://www.hnwoori.com/news/photo/201502/113193_765_4915.jpg").into(profileImage)
    }

}
