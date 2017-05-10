package test.bwie.com.zhoukaob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.Serializable;

public class thread extends AppCompatActivity {

    private TextView text_jianjie;
    private TextView text_name;
    private ImageView imagfeview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        text_jianjie = (TextView) findViewById(R.id.text_jianjie);
        text_name = (TextView) findViewById(R.id.text_name);
        imagfeview = (ImageView) findViewById(R.id.imageview);

        Intent intent = getIntent();
       // Serializable imageview = intent.getSerializableExtra("imageview");
        String imageview1 = intent.getStringExtra("imageview");
        String name = intent.getStringExtra("name");
        String connect = intent.getStringExtra("connect");

        text_jianjie.setText(connect);
        text_name.setText(name);
        //用imageloader加载图片
        ImageLoader.getInstance().displayImage(imageview1,imagfeview);
        //imagfeview.setImageResource(imageview1);
    }
}
