package test.bwie.com.zhoukaob;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * date: 2017/5/9
 * author:陈茹
 * 类的用途:
 */

public class Myadapter extends BaseAdapter {
    private Context content;
    private List<GsonBean.StudentsBean.StudentBean> list;
    public Myadapter(Context content,List<GsonBean.StudentsBean.StudentBean> list){
        this.content=content;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=View.inflate(content,R.layout.item,null);
            ImageView imageview = (ImageView) convertView.findViewById(R.id.imageview);
            TextView text_name = (TextView) convertView.findViewById(R.id.text_name);

            DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder().
                    showImageOnLoading(R.mipmap.ic_launcher)  // 设置图片在下载期间示的图片
                    .showImageOnFail(R.mipmap.ic_launcher).build();

            ImageLoader.getInstance().displayImage(list.get(position).getImg(), imageview, displayImageOptions);
            text_name.setText(list.get(position).getName());

        }
        return convertView;
    }
}
