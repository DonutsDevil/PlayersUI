package com.example.interviewui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.interviewui.R;
import com.example.interviewui.RecyclerHolders.Videos;
import org.jetbrains.annotations.NotNull;
import java.util.List;

/**Vertical video Adapter for VideoFragment*/
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.Holder> {

    private final Context mContext;
    private final List<Videos> videosList;
    public VideoAdapter(Context context, List<Videos> videosList) {
        mContext = context;
        this.videosList = videosList;
    }
    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        int layout = R.layout.video_recycler_item_layout;
        View view = LayoutInflater.from(mContext).inflate(layout,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VideoAdapter.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
