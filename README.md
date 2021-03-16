怎样使用?

工程的Gradle引入方式：

    repositories {
            google()
            jcenter()
            mavenCentral()
        }

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url 'https://jitpack.io' }
            mavenCentral()
        }
    }

  dependencies {
		implementation 'com.github.gyadministrator:ThirdFileOpen:1.1'
	}

在activity使用，非常简单。
  
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_fileBrowsing;
    private String fileName = "测试1.docx";
    private String fileUrl = "https://raw.githubusercontent.com/yangxch/Resources/master/test.docx";//远程文档地址

    //private String fileUrl="http://10.0.0.254:8077/upload/2021/01/24/1353222377480675328.docx";//远程文档地址
    //private String fileUrl="http://10.0.0.254:8077/upload/2021/01/24/1353230629228535808.pdf";//远程文档地址
    //private String fileUrl="https://files.cnblogs.com/files/han-1034683568/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8Cv1.2.0.pdf";//远程文档地址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_fileBrowsing = findViewById(R.id.btn_fileBrowsing);
        btn_fileBrowsing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_fileBrowsing) {
            FileDisplayActivity.startActivity(MainActivity.this, fileUrl, fileName);
        }
    }
}


