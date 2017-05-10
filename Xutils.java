package test.bwie.com.zhoukaob;

import android.content.Context;
import android.util.Log;
import android.widget.GridView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * date: 2017/5/9
 * author:陈茹
 * 类的用途:
 */

public class Xutils {

    private Context content;
    private GridView gridview;
    private static  List<GsonBean.StudentsBean.StudentBean> list;
    private String url="http://result.eolinker.com/j8rJ6Ege95959a5b61c166efaee5ae4d0d95fb37cd10db5?uri=zhou.data\n";
    public  Xutils(Context content,GridView gridview ){
        this.content=content;
        this.gridview=gridview;
    }
    public void getdata(String url){
        RequestParams params = new RequestParams(url);
//        params.addBodyParameter("username","abc");
//        params.addParameter("password","123");
        params.addHeader("head","android"); //为当前请求添加一个头
        x.http().post(params, new Callback.CommonCallback<String>() {



            @Override
            public void onSuccess(String result) {
                //解析result

                Gson gson=new Gson();
                GsonBean gsonBean = gson.fromJson(result, GsonBean.class);
                list = gsonBean.getStudents().getStudent();
                Log.d("xxxxxxxxxx",list.toString());

                Myadapter adapter=new Myadapter(content,list);
                gridview.setAdapter(adapter);

            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }
    public static List<GsonBean.StudentsBean.StudentBean> getlist(){

        return list;
    }

}
