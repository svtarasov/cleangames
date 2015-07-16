package com.example.katerina.mapsex;

import com.example.katerina.mapsex.datamodels.Team;

/**
 * Created by Katerina on 16.07.2015.
 */
public class TeamProvider {
    private static TeamProvider instance;
    private static Team team;
    private TeamProvider(Team team){
        this.team=team;
    }
    public static TeamProvider Initialize() {
        return instance;
    }

    public static TeamProvider Initialize(Team team, Boolean change){
        if(!change)
            return instance;
        else { instance = new TeamProvider(team);return instance;}

    }

    public Team getGame(){
        return this.team;
    }

}
