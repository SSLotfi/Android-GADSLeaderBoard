package com.salmashamel.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LearningLeaderRecycleAdapter extends RecyclerView.Adapter<LearningLeaderRecycleAdapter.MainViewHolder>{

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<LearningLeader> mLearningLeaders;

    public LearningLeaderRecycleAdapter(Context context, List<LearningLeader> learningLeaders) {
        mContext = context;
        mLearningLeaders = learningLeaders;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.leaderitem, parent, false);

        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        LearningLeader learningLeader = mLearningLeaders.get(position);
        LoadImage(learningLeader.getBadgeUrl(),holder.mBadgeImage);
        holder.mLeaderName.setText(learningLeader.getName());
        holder.mLeaderDataCountry.setText(new StringBuilder().append(learningLeader.getHours()).append(" learning hours, ").append(learningLeader.getCountry()).toString());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mLearningLeaders.size();
    }

    public void setList(List<LearningLeader> learningLeaders){
        this.mLearningLeaders = learningLeaders;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        public final TextView mLeaderName;
        public final ImageView mBadgeImage;
        public final TextView mLeaderDataCountry;
        public int mCurrentPosition;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            mLeaderName = itemView.findViewById(R.id.tvLeaderName);
            mBadgeImage = itemView.findViewById(R.id.ivBadge);
            mLeaderDataCountry = itemView.findViewById(R.id.tvDataCountry);
        }
    }

    public static void LoadImage(String imageURL, View view){
        Picasso.get().load(imageURL).placeholder(R.drawable.ic_baseline_broken_image_24).into((ImageView) view);
    }
}
