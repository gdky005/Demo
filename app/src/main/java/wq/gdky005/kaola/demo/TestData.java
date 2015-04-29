package wq.gdky005.kaola.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqing on 15/4/13.
 */
public class TestData {

    public static List<String> getData() {
        List<String> list = new java.util.ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("这是数据：" + i);
        }
        return list;
    }

    public static List<String> getGroupData() {
        int groupNumber = 40;
        List<String> list = new java.util.ArrayList<String>();
        for (int i = 0; i < groupNumber; i++) {
            list.add(i * groupNumber + "-" + (i * groupNumber + groupNumber));
        }
        return list;
    }

    public static List<HBean> getHBeanData(int pageSize, int totalNum) {
        List<HBean> list = new ArrayList<HBean>();

        int consult = totalNum / pageSize;

        int fragmentPageCount = totalNum % pageSize == 0 ?  consult : consult + 1;

        // 120个数据，40个一组，分三组
        for (int i = 0; i <= fragmentPageCount - 1; i++) {

            int currentData = i * pageSize + 1;

            HBean hBean = new HBean();

            if (i < fragmentPageCount - 1) {
                hBean.setText(currentData + "-" + (i + 1) * pageSize);
            } else {
                if (currentData == totalNum) {
                    hBean.setText(totalNum + "");
                } else {
                    hBean.setText(currentData+ "-" + totalNum);
                }
            }
            list.add(hBean);
        }
        return list;

    }

    public static List<HBean> getGroupBeanData(int pageSize, int totalNum) {
        List<HBean> list = new ArrayList<HBean>();

        int consult = totalNum / pageSize;
        int fragmentPageCount = totalNum % pageSize == 0 ?  consult : consult + 1;

        for (int i = 0; i < fragmentPageCount; i++) {

            HBean hBean = new HBean();
            hBean.setText((i * pageSize + 1) + "-" + (i * pageSize + pageSize));
            list.add(hBean);
        }
        return list;
    }

    public static List<HBean> getBeanData(int pageSize, int totalNum, int fragmentPosition) {
        List<HBean> list = new ArrayList<HBean>();

        for (int i = 0; i < pageSize; i++) {

            if ((pageSize * fragmentPosition + i) < totalNum) {
                HBean hBean = new HBean();
                hBean.setText((i * pageSize + 1) + "-" + (i * pageSize + pageSize));
                hBean.setMaxNum((i * pageSize + pageSize));
                hBean.setMinNum(i * pageSize);
                list.add(hBean);
            }
        }

        return list;
    }

    public static List<Bean> getTestData() {

        //初始化数据
        List<Bean> myDataset = new java.util.ArrayList<wq.gdky005.kaola.demo.Bean>();

        for (int i = 0; i < 5; i++) {
            myDataset.add(new Bean(Bean.Z_TYPE, "图片"));
            myDataset.add(new Bean(Bean.X_TYPE, "文字"));
            myDataset.add(new Bean(Bean.Y_TYPE, "按钮"));
            myDataset.add(new Bean(Bean.Z_TYPE, "图片"));
            myDataset.add(new Bean(Bean.X_TYPE, "shit"));
            myDataset.add(new Bean(Bean.X_TYPE, "我擦"));
            myDataset.add(new Bean(Bean.Z_TYPE, "图片"));
            myDataset.add(new Bean(Bean.Y_TYPE, "按钮"));
            myDataset.add(new Bean(Bean.Y_TYPE, "按钮"));
            myDataset.add(new Bean(Bean.X_TYPE, "文字"));
        }
        return myDataset;
    }
}
