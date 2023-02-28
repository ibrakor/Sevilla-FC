package com.ibrakor.sevillaFc.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibrakor.sevillaFc.domain.models.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PlayerFileLocalDataSource {


    private PlayerFileLocalDataSource(){

    }

    private static PlayerFileLocalDataSource instance=null;

    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Player>>() {
    }.getType();



    public void save(Player player) {
        List<Player> players = findAll();
        players.add(player);
        saveToFile(players);
    }



    private void saveToFile(List<Player> players) {
        try {
            FileWriter myWriter = new FileWriter("players.txt");
            myWriter.write(gson.toJson(players));
            myWriter.close();
            System.out.println("Jugador guardado correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public Player findById(Integer playerId) {
        List<Player> players = findAll();
        for (Player player : players) {
            if (Objects.equals(player.getId(), playerId)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> findAll() {
        try {
            File myObj = new File("players.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAlumnList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<Player>();
    }

    public static PlayerFileLocalDataSource getInstance(){
        if (instance==null){
            instance = new PlayerFileLocalDataSource();
        }
        return instance;
    }


}
