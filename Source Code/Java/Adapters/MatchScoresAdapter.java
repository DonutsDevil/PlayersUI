package com.example.interviewui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.interviewui.R;
import com.example.interviewui.RecyclerHolders.MatchScores;
import org.jetbrains.annotations.NotNull;
import java.util.List;
/**Horizontal Recycler View Adapter for All Fragment*/
public class MatchScoresAdapter extends RecyclerView.Adapter<MatchScoresAdapter.Holder> {
    private final Context mContext;
    private final List<MatchScores> mMatchScoresList;

    public MatchScoresAdapter (Context context, List<MatchScores> scoresList) {
        mContext = context;
        mMatchScoresList = scoresList;
    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        int layoutId = R.layout.horizontal_item_layout;
        View view = LayoutInflater.from(mContext).inflate(layoutId,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MatchScoresAdapter.Holder holder, int position) {
        MatchScores currentMatch = mMatchScoresList.get(position);
        holder.setData(currentMatch.getTeamAName(),currentMatch.getTeamBName());
    }

    @Override
    public int getItemCount() {
        return mMatchScoresList.size();
    }

    protected static class Holder extends RecyclerView.ViewHolder {
        private final TextView tvTeamA;
        private final TextView tvTeamB;

        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTeamA = itemView.findViewById(R.id.tv_teamA);
            tvTeamB = itemView.findViewById(R.id.tv_teamB);
        }

        protected void setData(String teamA, String teamB) {
            tvTeamA.setText(teamA);
            tvTeamB.setText(teamB);
        }
    }
}
