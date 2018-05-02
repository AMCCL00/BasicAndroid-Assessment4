package com.example.rodneytressler.week4assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private List<Player> playerList;

    private PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);
        populateRecyclerView();
        playerList = this.getIntent().getParcelableArrayListExtra(MainActivity.TAG);
    }

    private void populateRecyclerView() {
        PlayerAdapter playerAdapter = new PlayerAdapter(playerList);
        playerAdapter.onBindViewHolder((PlayerAdapter.PlayerViewholder) playerList,playerList.size());
        RecyclerView.LayoutManager layoutManager = LinearLayoutManager.;
        recyclerView.setLayoutManager(layoutManager);
        playerList.notify();
    }
}
