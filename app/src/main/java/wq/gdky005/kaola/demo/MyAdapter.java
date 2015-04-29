package wq.gdky005.kaola.demo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wangqing on 15/4/13.
 */
public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private java.util.List<wq.gdky005.kaola.demo.Bean> beans;

    public MyAdapter(java.util.List<wq.gdky005.kaola.demo.Bean> beans) {
        super();
        this.beans = beans;
    }

    /**
     * 内部TextHoler
     *
     * @author edsheng
     *
     */
    public class TextHoler extends RecyclerView.ViewHolder {
        public TextView textView;

        public TextHoler(View textview) {
            super(textview);
            this.textView = (TextView) textview.findViewById(R.id.mytext);
        }
    }

    /**
     * iamgeHolder
     *
     * @author edsheng
     *
     */
    public class ImageHoler extends RecyclerView.ViewHolder {
        public android.widget.ImageView Imageview;

        public ImageHoler(View textview) {
            super(textview);
            this.Imageview = (android.widget.ImageView) textview.findViewById(R.id.myiamge);
        }
    }

    /**
     * 按钮的holder
     *
     * @author edsheng
     *
     */
    public class ButtonHolder extends RecyclerView.ViewHolder {
        public android.widget.Button button;

        public ButtonHolder(View textview) {
            super(textview);
            this.button = (android.widget.Button) textview.findViewById(R.id.mybutton);
        }
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    /**
     * 获取消息的类型
     */
    @Override
    public int getItemViewType(int position) {
        return beans.get(position).getType();
    }

    /**
     * 创建VIewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View v = null;
        ViewHolder holer = null;
        switch (viewtype) {
            case wq.gdky005.kaola.demo.Bean.X_TYPE:
                v = android.view.LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recylce_item_x, null);
                holer = new TextHoler(v);
                break;
            case wq.gdky005.kaola.demo.Bean.Y_TYPE:
                v = android.view.LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recylce_item_z, null);
                holer = new ButtonHolder(v);
                break;
            case wq.gdky005.kaola.demo.Bean.Z_TYPE:
                v = android.view.LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recylce_item_y, null);
                holer = new ImageHoler(v);
                break;
        }

        return holer;
    }

    /**
     * 绑定viewholder
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case wq.gdky005.kaola.demo.Bean.X_TYPE:
                TextHoler textholer = (TextHoler) holder;
                textholer.textView.setText(beans.get(position).getText());
                break;
            case wq.gdky005.kaola.demo.Bean.Y_TYPE:
                ButtonHolder buttonHolder = (ButtonHolder) holder;
                buttonHolder.button.setText(beans.get(position).getText());
                break;
            case wq.gdky005.kaola.demo.Bean.Z_TYPE:
                ImageHoler imageHoler = (ImageHoler) holder;
                imageHoler.Imageview.setImageResource(android.R.drawable.checkbox_on_background);
                break;
        }
    }
}
