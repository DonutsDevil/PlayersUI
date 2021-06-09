package com.example.interviewui.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.interviewui.AllFragment;
import com.example.interviewui.VideoFragment;
import org.jetbrains.annotations.NotNull;
/**View Pager2 Adapter for All Fragment */
public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 : fragment = new AllFragment(); break;
            case 1 :
            case 2 :
            case 3 : fragment = new VideoFragment(); break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
