package wq.gdky005.kaola.demo;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangqing on 15/4/13.
 */
public class MyAdapterStr extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> beans;

    public MyAdapterStr(List<String> beans) {
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
     * 创建VIewHolder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View v = android.view.LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recylce_item_x, null);
        RecyclerView.ViewHolder holer = new TextHoler(v);


        return holer;
    }

    /**
     * 绑定viewholder
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextHoler textholer = (TextHoler) holder;
        textholer.textView.setText(beans.get(position));
    }

}
