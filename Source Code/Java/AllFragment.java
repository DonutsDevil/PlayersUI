package com.example.interviewui;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.interviewui.Adapters.MatchInformationAdapter;
import com.example.interviewui.Adapters.MatchScoresAdapter;
import com.example.interviewui.Utils.Utils;
import org.jetbrains.annotations.NotNull;

public class AllFragment extends Fragment implements MatchInformationAdapter.OnItemClickListener {

    private  Context mContext;
    private ClickedItemResult mCallBack;

    public AllFragment() {
        // Required empty public constructor
    }
    /** This is to handle the click event from the recycler view , Implement this method in
     *  order to get clicked View from recycler view */
    public interface ClickedItemResult {
        void recyclerSelectedView();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        // Activity should implement @ClickItemResult else throw  an exception
        try {
            mCallBack = (ClickedItemResult) context;
            mContext = context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " Must implement ClickedItemResult ");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        setUpVerticalRecyclerView(view);
        setUpHorizontalRecyclerView(view);
        return view;
    }

    // Set Vertical Recycler View
    private void setUpVerticalRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.verticalRecyclerView);
        LinearLayoutManager layoutManager  =  new LinearLayoutManager(
                mContext,
                LinearLayoutManager.VERTICAL,
                false
        );
        MatchInformationAdapter adapter =new MatchInformationAdapter(mContext,
                Utils.getMatchInformationList(mContext),this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL); // Divider Decoration line
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
    // Set Horizontal Recycler View
    private void setUpHorizontalRecyclerView (View view) {
        RecyclerView recyclerView = view.findViewById(R.id.horizontalRecyclerView);
        LinearLayoutManager layoutManager  =  new LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL,
                false
        );
        MatchScoresAdapter adapter =new MatchScoresAdapter(mContext,
                Utils.getMatchScoreList(mContext));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    // This method returns the selected view position from vertical Recycler View
    @Override
    public void recyclerItemClickListener(int position) {
        mCallBack.recyclerSelectedView();
    }
}