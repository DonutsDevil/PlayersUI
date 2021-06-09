/*
 * This Fragment has The viewpager needed to swipe between All ,IPL, Cricket , Football
 * this is the very first fragment visible when app is launched.
 */
package com.example.interviewui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.interviewui.Adapters.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import org.jetbrains.annotations.NotNull;


public class HomeFragment extends Fragment {

    private FragmentActivity activity;

    public HomeFragment() {
        // Required empty public constructor
    }

    public HomeFragment(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        setUpViewPager(view);
        return view;
    }
    // Set ViewPager2
    private void setUpViewPager(View view) {
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(activity);
        viewPager2.setAdapter(fragmentAdapter);
        setUpTabLayout(viewPager2, view);
    }

    // Set Tab Layout to sync with View Pager and Dynamically add Names to the Tab Layout
    private void setUpTabLayout(ViewPager2 viewPager2, View view) {
        TabLayout tabLayout = view.findViewById(R.id.tabLyout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0 : {
                        tab.setText(R.string.all);
                        break;
                    }
                    case 1 : {
                        tab.setText(R.string.ipl);
                        break;
                    }
                    case 2 : {
                        tab.setText(R.string.cricket);
                        break;
                    }
                    case 3 : {
                        tab.setText(R.string.football);
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();
    }
}