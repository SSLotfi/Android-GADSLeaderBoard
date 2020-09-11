package com.salmashamel.gadsleaderboard.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.salmashamel.gadsleaderboard.LearningLeadersFragment;
import com.salmashamel.gadsleaderboard.R;
import com.salmashamel.gadsleaderboard.SkillIQLeadersFragment;
import com.salmashamel.gadsleaderboard.SubmitActivity;
import com.salmashamel.gadsleaderboard.settings.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.vpContainer);
        btnSubmit = findViewById(R.id.btnSubmit);

        setupViewPager();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupViewPager(){
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        LearningLeadersFragment learningLeadersFragment = new LearningLeadersFragment();
        SkillIQLeadersFragment skillIQLeadersFragment = new SkillIQLeadersFragment();
        pagerAdapter.addFragment(learningLeadersFragment);
        pagerAdapter.addFragment(skillIQLeadersFragment);

        mViewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs_top);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(getResources().getInteger(R.integer.LEARNING_FRAGMENT)).setText(getString(R.string.tag_learning_fragment));
        tabLayout.getTabAt(getResources().getInteger(R.integer.SKILL_FRAGMENT)).setText(getString(R.string.tag_skill_fragment));
    }
}