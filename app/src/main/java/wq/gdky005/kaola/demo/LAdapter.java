package wq.gdky005.kaola.demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangqing on 15/4/14.
 */
public class LAdapter extends BaseAdapter {

    private Context context;
    private List<HBean> list;
    private int fragmentPosition;

    public LAdapter(Context context) {
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
        if (convertView == null) {
            holdView = new HoldView();
            convertView = View.inflate(context, R.layout.recylce_item_x, null);

            holdView.tv = (TextView) convertView.findViewById(R.id.mytext);

            convertView.setTag(holdView);
        } else {
            holdView = (HoldView) convertView.getTag();
        }

        HBean hBean = list.get(position);
        holdView.tv.setText((position + 1 + getFragmentPosition() * MainActivity.pageSize) + "");
        holdView.tv.setSelected(hBean.isState());

        return convertView;
    }

    public int getFragmentPosition() {
        return fragmentPosition;
    }

    public void setFragmentPosition(int fragmentPosition) {
        this.fragmentPosition = fragmentPosition;
    }

    class HoldView {
        private TextView tv;
    }

}
