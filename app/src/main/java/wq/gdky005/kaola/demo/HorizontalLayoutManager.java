package wq.gdky005.kaola.demo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wangqing on 15/4/13.
 */
public class HorizontalLayoutManager extends LinearLayoutManager {

    public HorizontalLayoutManager(Context context) {
        super(context);
    }

    public HorizontalLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        View view = recycler.getViewForPosition(0);
        if(view != null){
            measureChild(view, widthSpec, heightSpec);

            int measuredWidth = View.MeasureSpec.getSize(widthSpec);
            int measuredHeight = view.getMeasuredHeight() ;
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }
}
