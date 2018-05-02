package com.example.rodneytressler.week4assessment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodneytressler on 12/17/17.
 */

public class Player implements Parcelable{

    private String playerName;
    private String playerNum;
    private String playerTeam;
    private Bundle arguments;

    public Player() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerNum() {
        return playerNum;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    protected Player(Parcel in) {
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playerName);
        dest.writeString(playerNum);
        dest.writeString(playerTeam);
    }

    public static Player newInstance() {

        Bundle args = new Bundle();

        Player fragment = new Player();
        fragment.setArguments(args);
        return fragment;
    }

    public void setArguments(Bundle arguments) {
        this.arguments = arguments;
    }
}
