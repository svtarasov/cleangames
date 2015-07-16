package com.example.katerina.mapsex.Game;

import com.example.katerina.mapsex.datamodels.Game;

/**
 * Created by 1 on 10.07.2015.
 */
public class GameProvider {

    private static GameProvider instance;
    private static Game game;
    private GameProvider(Game game){
        this.game=game;
    }
    public static GameProvider Initialize() {
        return instance;
    }

    public static GameProvider Initialize(Game game, Boolean change){
         if(!change)
               return instance;
            else { instance = new GameProvider(game);return instance;}
    }

    public static GameProvider Initialize(Game game){
            return instance;
    }
    public Game getGame(){
        return this.game;
    }

}
