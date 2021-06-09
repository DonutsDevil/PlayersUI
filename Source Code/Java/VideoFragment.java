package com.example.interviewui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewui.Adapters.VideoAdapter;
import com.example.interviewui.Utils.Utils;

import org.jetbrains.annotations.NotNull;

public class VideoFragment extends Fragment {
    /** isVideo : if true then display recycler view filed with videos
     *              else don't show anything */
    private boolean isVideo;
    private Context mContext;
    public VideoFragment() {
        // Required empty public constructor
    }

    public VideoFragment(boolean isVideo, Context context) {
        this.isVideo = isVideo;
        mContext = context;
    }

    /* inflate fragment_video if isVideo is true to show list of videos
    * else inflate fragment_dummy if isVideo is false*/
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        if (isVideo) {
            view = inflater.inflate(R.layout.fragment_video, container, false);
            setupRecyclerView(view);
        }
        else{
            view =inflater.inflate(R.layout.fragment_dummy, container, false);
        }
        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.videoRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                mContext,LinearLayoutManager.VERTICAL,false);
        VideoAdapter adapter = new VideoAdapter(mContext, Utils.getVideosList());
        DividerItemDecoration decoration = new DividerItemDecoration(
                mContext, DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setHasFixedSize(true);

    }

}