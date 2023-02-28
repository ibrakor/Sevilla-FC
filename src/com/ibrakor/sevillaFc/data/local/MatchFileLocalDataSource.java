package com.ibrakor.sevillaFc.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibrakor.sevillaFc.domain.models.Match;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MatchFileLocalDataSource {

    private MatchFileLocalDataSource(){

    }

    private static MatchFileLocalDataSource instance = null;
    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Match>>() {
    }.getType();



    public void save(Match match) {
        List<Match> matchs = findAll();
        matchs.add(match);
        saveToFile(matchs);
    }



    private void saveToFile(List<Match> matchs) {
        try {
            FileWriter myWriter = new FileWriter("matchs.txt");
            myWriter.write(gson.toJson(matchs));
            myWriter.close();
            System.out.println("Arbitro guardado correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public Match findById(Integer matchId) {
        List<Match> matchs = findAll();
        for (Match match : matchs) {
            if (Objects.equals(match.getId(), matchId)) {
                return match;
            }
        }
        return null;
    }

    public List<Match> findAll() {
        try {
            File myObj = new File("matchs.txt");
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
        return new ArrayList<Match>();
    }

    public static MatchFileLocalDataSource getInstance(){
        if (instance==null){
            instance = new MatchFileLocalDataSource();
        }
        return instance;
    }
    

}
