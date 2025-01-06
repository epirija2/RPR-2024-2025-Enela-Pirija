package com.example.lv09_2.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PredmetModel {
    private ObservableList<Predmet> predmeti;
    private static final String DB_URL = "jdbc:sqlite:baza.db";
    private static PredmetModel instance = null;

    private PredmetModel() {
        predmeti = FXCollections.observableArrayList();
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void kreirajTabeluAkoNePostoji() {
        String upit = """
                CREATE TABLE IF NOT EXISTS Predmet(
                id INTEGER,
                naziv TEXT,
                ECTS REAL);
                """;
        try (Connection conn = connect(); Statement stmt = conn.createStatement())  {
            stmt.execute(upit);
            System.out.println("Tabela je kreirana ili vec postoji!");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void napuniInicijalnimPodacima() {
        String upit = """
                INSERT INTO Predmet
                VALUES (?, ?, ?);""";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(upit)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Osnove baza podataka");
            pstmt.setDouble(3, 5.0);
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setString(2, "Razvoj programskih rjesenja");
            pstmt.setDouble(3, 5.0);
            pstmt.executeUpdate();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Inzenjerska matematika");
            pstmt.setDouble(3, 7.0);
            pstmt.executeUpdate();

            System.out.println("Ubaceni inicijalni podaci");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Predmet> dajSvePredmete() {
        List<Predmet> predmeti = new ArrayList<>();
        String upit = "SELECT * FROM Predmet";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(upit);)
        {
            while (rs.next()) {
                Predmet predmet = new Predmet(rs.getInt("id"), rs.getString("naziv"),
                        rs.getDouble("ECTS"));
                predmeti.add(predmet);
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return predmeti;
    }

    public static Predmet dajPredmetPoId(Integer id) {
        Predmet predmet = null;
        String upit = "SELECT * FROM Predmet WHERE id = ?;";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(upit))
        {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                predmet = new Predmet (rs.getInt("id"),
                                        rs.getString("naziv"),
                                        rs.getDouble("ECTS"));
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return predmet;
    }

    public static String azurirajPredmet(Integer id, String naziv, Double ECTS) {
        StringBuilder upit = new StringBuilder("UPDATE Predmet SET ");
        boolean imaPromjene = false;
        List<Object> parametri = new ArrayList<>();

        if (naziv != null && !naziv.isEmpty()) {
            upit.append("naziv = ?, ");
            parametri.add(naziv);
            imaPromjene = true;
        }

        if (ECTS != null) {
            upit.append("ECTS = ?, ");
            parametri.add(ECTS);
            imaPromjene = true;
        }

        if (!imaPromjene) return "Sva polja su ista kao i prije!";

        upit.delete(upit.length() - 2, upit.length());
        upit.append(" WHERE id = ?;");

        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(upit.toString()))
        {
            for (int i = 0; i < parametri.size(); i++)
                pstmt.setObject(i + 1, parametri.get(i));

            int promijenjeniRedovi = pstmt.executeUpdate();
            if (promijenjeniRedovi > 0) return "Predmet je uspjesno azuriran!";
            return "Ne postoji predmet sa datim id-em!";
        }
        catch (SQLException e) {
            return e.getMessage();
        }
    }

    public static void obrisiPredmet(Integer id) {
        String upit = "DELETE FROM Predmet WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(upit))
        {
            pstmt.setInt(1, id);
            int izbrisaniRedovi = pstmt.executeUpdate();
            if (izbrisaniRedovi > 0) System.out.println("Predmet je obrisan!");
            System.out.println("Predmet sa datim id-em nije pronadjen!");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void isprazniTabeluPredmeta() {
        String upit = "DELETE FROM Predmet";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            int brojObrisanihRedova = stmt.executeUpdate(upit);
            System.out.println("Obrisani redovi tabele. Broj obrisanih " +
                    "redova: " + brojObrisanihRedova);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static PredmetModel getInstance() {
        if (instance == null)
            instance =  new PredmetModel();
        return instance;
    }

    public static void removeInstance() {
        instance = null;
    }
}