package com.salmashamel.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SkillIQLeaderRecycleAdapter extends RecyclerView.Adapter<SkillIQLeaderRecycleAdapter.MainViewHolder>{

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<SkillIQLeader> mSkillIQLeaders;

    public SkillIQLeaderRecycleAdapter(Context context, List<SkillIQLeader> SkillIQLeaders) {
        mContext = context;
        mSkillIQLeaders = SkillIQLeaders;
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
        SkillIQLeader skillIQLeader = mSkillIQLeaders.get(position);
        LoadImage(skillIQLeader.getBadgeUrl(),holder.mBadgeImage);
        holder.mLeaderName.setText(skillIQLeader.getName());
        holder.mLeaderDataCountry.setText(new StringBuilder().append(skillIQLeader.getScore()).append(" skill IQ score, ").append(skillIQLeader.getCountry()).toString());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mSkillIQLeaders.size();
    }

    public void setList(List<SkillIQLeader> skillIQLeaders){
        this.mSkillIQLeaders = skillIQLeaders;
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
