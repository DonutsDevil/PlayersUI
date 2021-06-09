package com.example.interviewui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.interviewui.R;
import com.example.interviewui.RecyclerHolders.MatchInformation;
import org.jetbrains.annotations.NotNull;
import java.util.List;

/** Vertical Recycler View Adapter All Fragment*/
public class MatchInformationAdapter extends RecyclerView.Adapter<MatchInformationAdapter.Holder> {

    private final Context mContext;
    private final List<MatchInformation> mMatchInformationList;
    private final OnItemClickListener clickListener;

    public MatchInformationAdapter (Context context, List<MatchInformation> informationList, OnItemClickListener clickListener ) {
        mContext = context;
        mMatchInformationList = informationList;
        this.clickListener = clickListener;
    }

    /** Implement this to get clicked view position from recycler view*/
    public interface OnItemClickListener {
        void recyclerItemClickListener(int position);
    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        int layout = R.layout.vertical_item_layout;
        View view = LayoutInflater.from(mContext).inflate(layout,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MatchInformationAdapter.Holder holder, int position) {
        MatchInformation currentInformation = mMatchInformationList.get(position);
        holder.setData(currentInformation.getTime(),currentInformation.getTitle());
    }

    @Override
    public int getItemCount() {
        return mMatchInformationList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private final TextView mTimeTv;
        private final TextView mTitleTv;
        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
            mTimeTv = itemView.findViewById(R.id.vertical_rv_timeTextView);
            mTitleTv = itemView.findViewById(R.id.vertical_rv_infoTextView);
            // Listener to listen when recycler view item is clicked
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    clickListener.recyclerItemClickListener(position);
                }
            });
        }

        protected void setData(String time, String title) {
            mTimeTv.setText(time);
            mTitleTv.setText(title);
        }


    }
}
