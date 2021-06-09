package com.example.interviewui.Utils;

import android.content.Context;
import android.content.res.Resources;
import com.example.interviewui.R;
import com.example.interviewui.RecyclerHolders.MatchInformation;
import com.example.interviewui.RecyclerHolders.MatchScores;
import com.example.interviewui.RecyclerHolders.Videos;
import java.util.ArrayList;
import java.util.List;

/**This class is used to provide list data */
public class Utils {
    // We don't want to create any object of this class
    private Utils(){}

    // Returns a list with match info data for vertical Recycler View
    public static List<MatchInformation> getMatchInformationList(Context context){
        // Stores Data for vertical recycler view
        List<MatchInformation> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++) {
            list.add(new MatchInformation("3 minutes ago",
                    context.getResources().getString(R.string.verticalRV_title)));
        }
        return list;
    }
    // Returns a list with match score data for horizontal Recycler View
    public static List<MatchScores> getMatchScoreList(Context context) {
        List<MatchScores> list = new ArrayList<>();
        Resources res = context.getResources();
        for(int i = 0 ; i < 10 ;i++) {
            list.add(new MatchScores(res.getString(R.string.teamA), res.getString(R.string.teamB)));
        }
        return list;
    }

    // Returns list of videos
    public static List<Videos> getVideosList() {
        List<Videos> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new Videos("i"));
        }
        return list;
    }

}
