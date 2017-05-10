package test.bwie.com.zhoukaob;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview;
    private TextView text_time;
    int time=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (time>0){
                time--;
                text_time.setText(time+"");
                handler.sendEmptyMessageDelayed(0,1000);
            }else {
                Intent intent=new Intent(MainActivity.this,Secondmain.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.imageview);

        text_time = (TextView) findViewById(R.id.text_time);
//        //创建旋转动画
//        Animation animation = new RotateAnimation(0, 359);
//        animation.setDuration(500);
//        animation.setRepeatCount(8);//动画的重复次数
//        animation.setFillAfter(true);//设置为true，动画转化结束后被应用
//        imageview.startAnimation(animation);//开始动画


        //旋转动画
        RotateAnimation  rotateAnim =new RotateAnimation(0,-360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1f);
        AnimationSet set=new AnimationSet(false);



        set.addAnimation(rotateAnim);

        set.setFillAfter(true);

        set.setDuration(3000);  //设置时间

        imageview.startAnimation(set);

        handler.sendEmptyMessage(0);

    }
}
