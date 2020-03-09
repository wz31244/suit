package com.example.suit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.suit.UI.home_fragments.HomeFragment;
import com.example.suit.UI.home_fragments.ShoppingFragment;
import com.example.suit.UI.home_fragments.TopicFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        //设置标题
        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("仿网易严选");
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tb);
        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomView(R.drawable.selector_choice, "首页")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomView(R.drawable.selector_topic, "专题")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomView(R.drawable.selector_sort, "分类")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomView(R.drawable.selector_shopping, "购物车")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomView(R.drawable.selector_me, "我的")));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                selectFragment(position);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
        tabLayout.getTabAt(0).select();
    }

    private void selectFragment(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new HomeFragment();
        } else if (position == 1) {
            fragment = new TopicFragment();
        } else if (position == 3) {//判断登录状态，并跳转登录界面
            fragment = new ShoppingFragment();
        } else {
            fragment = new Fragment();
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private View getCustomView(int imageId, String text) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_tab, null);
        ImageView iv_icon = view.findViewById(R.id.iv_icon);
        TextView tv_text = view.findViewById(R.id.tv_text);
        iv_icon.setImageResource(imageId);
        tv_text.setText(text);
        return view;
    }



}



