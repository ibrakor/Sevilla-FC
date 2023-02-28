package com.ibrakor.sevillaFc.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibrakor.sevillaFc.domain.models.Referee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RefereeFileLocalDataSource {

    private static RefereeFileLocalDataSource instance = null;

    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Referee>>() {
    }.getType();

    private RefereeFileLocalDataSource() {
    }

    public void save(Referee referee) {
        List<Referee> referees = findAll();
        referees.add(referee);
        saveToFile(referees);
    }



    private void saveToFile(List<Referee> referees) {
        try {
            FileWriter myWriter = new FileWriter("referees.txt");
            myWriter.write(gson.toJson(referees));
            myWriter.close();
            System.out.println("Arbitro guardado correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public Referee findById(Integer refereeId) {
        List<Referee> referees = findAll();
        for (Referee referee : referees) {
            if (Objects.equals(referee.getId(), refereeId)) {
                return referee;
            }
        }
        return null;
    }

    public List<Referee> findAll() {
        try {
            File myObj = new File("referees.txt");
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
        return new ArrayList<Referee>();
    }

    public static RefereeFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new RefereeFileLocalDataSource();
        }
        return instance;
    }

}
