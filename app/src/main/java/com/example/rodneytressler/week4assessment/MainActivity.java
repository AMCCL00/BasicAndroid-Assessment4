package com.example.rodneytressler.week4assessment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_team)
    protected EditText teamInput;

    @BindView(R.id.input_number)
    protected EditText numberInput;

    @BindView(R.id.input_name)
    protected EditText nameInput;

    private Player player;

    private List<Player> playerList;

    public static final String TAG = "PLAYER_LIST_TAG";

    @OnClick(R.id.button_add_player)
    protected void onAddPlayerButtonClicked() {
        if (teamInput.getText().toString().isEmpty() || nameInput.getText().toString().isEmpty() || numberInput.getText().toString().isEmpty()){
            Toast.makeText(this, "All Fields Required.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Player Added.", Toast.LENGTH_SHORT).show();
            player = player.newInstance();
            playerList.add(player);
            Bundle bundle = new Bundle();
            bundle.putString(TAG,"PLAYER_LIST_TAG");
            player.setArguments(bundle);
        }

    }

    @OnClick(R.id.button_view_players)
    protected void onViewPlayersButtonClicked() {

        if(playerList.isEmpty()){
            Toast.makeText(this, "Requires Player to View.", Toast.LENGTH_LONG).show();
        }else{
            Intent playersActivity = new Intent(this,PlayersActivity.class);
            playersActivity.putParcelableArrayListExtra(TAG, (ArrayList<? extends Parcelable>) playerList);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        playerList = new ArrayList<>();
    }


    
}
