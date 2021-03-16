package com.android.thirdfileopen;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.filelibrary.activity.FileDisplayActivity;

/**
 * @ProjectName: ThirdFileOpen
 * @Package: com.android.thirdfileopen
 * @ClassName: MainActivity
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/3/16 11:37
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_fileBrowsing;
    private String fileName="TBS测试.docx";
    //    private String fileUrl="http://123.207.239.170/test.docx";//远程文档地址，如下载失败请验证此链接是否还可用（那个时候可能我养不住服务器了）
    //private String fileUrl="https://raw.githubusercontent.com/yangxch/Resources/master/test.docx";//远程文档地址
    //private String fileUrl="http://10.0.0.254:8077/upload/2021/01/24/1353222377480675328.docx";//远程文档地址
    private String fileUrl="http://10.0.0.254:8077/upload/2021/01/24/1353230629228535808.pdf";//远程文档地址
    //private String fileUrl="https://files.cnblogs.com/files/han-1034683568/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8Cv1.2.0.pdf";//远程文档地址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_fileBrowsing=findViewById(R.id.btn_fileBrowsing);
        btn_fileBrowsing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fileBrowsing:
                //动态权限申请
                /*if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
                } else {
                    FileDisplayActivity.actionStart(MainActivity.this,fileUrl,fileName);
                }*/
                FileDisplayActivity.actionStart(MainActivity.this,fileUrl,fileName);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    FileDisplayActivity.actionStart(MainActivity.this,fileUrl,fileName);
                } else {
                    Toast.makeText(this, "你拒绝了权限申请，可能无法下载文件到本地哟！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}

