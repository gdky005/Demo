package wq.gdky005.kaola.demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangqing on 15/4/13.
 */
public class HAdapter extends BaseAdapter {

    private Context context;
    private List<HBean> list;

    public HAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<HBean> list) {
        this.list = list;
    }

    public List<HBean> getData() {
        return list;
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
        HoldView holdView = null;
        if(convertView == null) {
            holdView = new HoldView();
            convertView = View.inflate(context, R.layout.recylce_item_x, null);

            holdView.tv = (TextView) convertView.findViewById(R.id.mytext);

            convertView.setTag(holdView);
        } else {
            holdView = (HoldView) convertView.getTag();
        }

        HBean hBean = list.get(position);

        holdView.tv.setText(hBean.getText());
        holdView.tv.setSelected(hBean.isState());

        return convertView;
    }

    class HoldView {
        private TextView tv;
    }
}
