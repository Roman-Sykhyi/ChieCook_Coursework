package chiefcook.chiecook_coursework.controllers;

import chiefcook.chiecook_coursework.models.Vegetable;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VegetableController {
    private static final Logger LOG = Logger.getLogger(VegetableController.class.getSimpleName());

    private List<Vegetable> vegetables;

    public  VegetableController() {
        vegetables = new ArrayList<Vegetable>();
        init();
    }

    public VegetableController(String filePath) {
        vegetables = new ArrayList<Vegetable>();
        init(filePath);
    }

    private void init(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader inputFile = new BufferedReader(new FileReader(file));

            String line;
            while((line = inputFile.readLine()) != null) {
                List<String> params = Arrays.asList(line.split(" "));
                vegetables.add(new Vegetable(params.get(0), Double.parseDouble(params.get(1))));
            }
            LOG.info("List of vegetables successfully read from file");
        } catch (Exception e) {
            LOG.error("Error reading list of vegetables from file");
            LOG.error(e.getMessage());
            System.out.println("Error reading list of vegetables from file");
            System.out.println("Exiting program");
            System.exit(1);
        }
    }

    private void init() {
        String url = "jdbc:sqlserver://DESKTOP-2LCR83P;databaseName=ChiefCook;integratedSecurity=true;";

        try {
            Connection connection = DriverManager.getConnection(url);
            LOG.info("Successfully connected to database");

            String query = "SELECT * FROM Vegetables";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            LOG.info("Reading data from database");

            while(result.next()) {
                String name = result.getString("Name");
                double calories = result.getDouble("Calories");

                vegetables.add(new Vegetable(name, calories));
            }
            connection.close();

            LOG.info("Finished reading data from database. Closing the connection");
        } catch (Exception e) {
            LOG.error("Failed connect to database");
            LOG.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public Vegetable getVegetable(String name) {
        Vegetable vegetable = null;

        for (Vegetable veg: vegetables) {
            if(veg.getName().equals(name)) {
                vegetable = veg;
            }
        }

        return vegetable;
    }

    public String getVegetablesInfo() {
        String result = "";

        for(int i = 0; i < vegetables.size(); i++) {
            result += i+1 + ". ";
            result += vegetables.get(i).toString();
            result += "\n";
        }

        return result;
    }
}