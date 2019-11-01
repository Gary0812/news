package com.example.taiwanxw;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
   定义UI组件
    */
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化界面组件
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        //获取初始化的适配器
        MyFragmentPagerAdapter myFragmentPagerAdapter = init();

        //添加适配器
        viewPager.setAdapter(myFragmentPagerAdapter);

        //设置tablayou和viewpage关联
        tabLayout.setupWithViewPager(viewPager);
    }
    /**
     * 初始化适配器
     *
     * @return：初始化后的适配器
     */
    public MyFragmentPagerAdapter init() {
        //菜单标题
        String[] title = {"新闻","视频"};

        //创建装载Fragment的列表
        List<Fragment> fragmentlist;

        /*
            初始化列表，并把创建的三个Fragment页面添加到列表中
         */
        fragmentlist = new ArrayList<>();
        fragmentlist.add(new FragmentOne());
        fragmentlist.add(new FragmentTwo());


        //创建Fragment适配器
        MyFragmentPagerAdapter myFragmentPagerAdapter;

        //适配器进行适配,传入列表与标题
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                fragmentlist, title);
        return myFragmentPagerAdapter;
    }
}
