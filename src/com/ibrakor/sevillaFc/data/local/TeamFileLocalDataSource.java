package com.ibrakor.sevillaFc.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibrakor.sevillaFc.domain.models.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TeamFileLocalDataSource {

    private TeamFileLocalDataSource(){

    }

    private static TeamFileLocalDataSource instance = null;
    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Team>>() {
    }.getType();



    public void save(Team team) {
        List<Team> teams = findAll();
        teams.add(team);
        saveToFile(teams);
    }



    private void saveToFile(List<Team> teams) {
        try {
            FileWriter myWriter = new FileWriter("teams.txt");
            myWriter.write(gson.toJson(teams));
            myWriter.close();
            System.out.println("Equipo guardado correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public Team findById(Integer teamId) {
        List<Team> teams = findAll();
        for (Team team : teams) {
            if (Objects.equals(team.getId(), teamId)) {
                return team;
            }
        }
        return null;
    }

    public List<Team> findAll() {
        try {
            File myObj = new File("teams.txt");
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
        return new ArrayList<Team>();
    }

      public static TeamFileLocalDataSource getInstance(){
        if (instance==null){
            instance = new TeamFileLocalDataSource();
        }
        return instance;
      }

}