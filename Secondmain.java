package test.bwie.com.zhoukaob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class Secondmain extends AppCompatActivity {

    private TextView text_xueyuan;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondmain);
        initview();
        Xutils xutils=new Xutils(Secondmain.this,gridview);
        xutils.getdata(Url.url);
    }

    private void initview() {
        text_xueyuan = (TextView) findViewById(R.id.text_xueyuan);
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Secondmain.this,thread.class);

                intent.putExtra("name",Xutils.getlist().get(position).getName()+"的信息");
                intent.putExtra("imageview",Xutils.getlist().get(position).getImg());

                intent.putExtra("connect",Xutils.getlist().get(position).getContent());
                startActivity(intent);
            }
        });

    }
}
