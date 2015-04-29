package wq.gdky005.kaola.demo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import wq.gdky005.kaola.demo.util.UIHelp;
import wq.gdky005.kaola.demo.view.HorizontalListView;


public class MainActivity extends FragmentActivity implements
        AdapterView.OnItemClickListener, View.OnClickListener {

    /**
     * Tab标题
     */
    private static final String[] TITLE = new String[] { "头条", "房产", "另一面", "女人",
            "财经", "数码", "情感", "科技" };


    public static final int pageSize = 40;
    public static final int totalNum = 600;

    private HorizontalListView horizontal_list_view;
    private ViewPager view_pager;
    public List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<HBean> hList = TestData.getHBeanData(pageSize, totalNum);

        horizontal_list_view = (HorizontalListView) findViewById(R.id.horizontal_list_view);

        view_pager = (ViewPager) findViewById(R.id.view_pager);
        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);

        HAdapter adapter = new HAdapter(this);
        adapter.setData(hList);
        horizontal_list_view.setAdapter(adapter);
        horizontal_list_view.setOnItemClickListener(this);

        setHState(hList, adapter, 0);

        for (int i = 0; i < hList.size(); i++) {
            MyFragment fragment = new MyFragment();

            Bundle bundle = new Bundle();
            bundle.putString("text", hList.get(i).getText());
            bundle.putInt("position", i);
            fragment.setArguments(bundle);

            fragments.add(fragment);
        }



        FragmentViewPagerAdapter fragmentPagerAdapter = new FragmentViewPagerAdapter(
                this.getSupportFragmentManager(), horizontal_list_view, view_pager, fragments, hList);

        indicator.setViewPager(view_pager);

        //如果我们要对ViewPager设置监听，用indicator设置就行了
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                Toast.makeText(getApplicationContext(), hList.get(arg0).getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
//
//        view_pager.setAdapter(fragmentPagerAdapter);
    }

    private void setHState(List<HBean> lists, HAdapter adapter, int selectPosition) {
        if (lists != null && lists.size() > 0) {
            for (int i = 0; i < lists.size(); i++) {
                HBean hBean = lists.get(i);
                if (i == selectPosition) {
                    hBean.setState(true);
                } else {
                    hBean.setState(false);
                }
            }

            horizontal_list_view.setSelection(selectPosition);
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (parent == horizontal_list_view) {
            HAdapter adapter = (HAdapter)horizontal_list_view.getAdapter();
            List<HBean> list = adapter.getData();
            setHState(list, adapter, position);

            view_pager.setCurrentItem(position);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
//                Toast.makeText(this, "弹出通知了哦！", Toast.LENGTH_SHORT).show();

                UIHelp.showNotification(this, "测试标题", "测试内容", R.mipmap.ic_launcher, new Intent(this, MainActivity.class));
                break;
        }
    }
}
