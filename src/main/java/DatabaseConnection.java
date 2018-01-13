import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseConnection {

        Connection conn;

        String dbHost;
        String dbPort;
        String dbName;
        String dbUser;
        String dbPassword;

        DatabaseConnection(String dbHost,String dbPort,String dbName,String dbUser,String dbPassword){
            this.dbHost = dbHost;
            this.dbPort = dbPort;
            this.dbName = dbName;
            this.dbUser = dbUser;
            this.dbPassword = dbPassword;
        }

        public void setupDBConnection() {

            try {

                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                //Main.logger.error(e);
                System.out.println(e);
            }

            try {
                conn = DriverManager.getConnection("jdbc:postgresql://"+dbHost+":"+dbPort+"/"+dbName, dbUser, dbPassword);
                System.out.println("succeed");
            } catch (SQLException e) {
                //Main.logger.error(e);
                System.out.println(e);
            }
        }

        public void insertNews (News news) throws SQLException {

            Gson gson = new Gson();
            String jsonInString = gson.toJson(news);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO \"News\"(data) VALUES('" + jsonInString + "')");



            // Transaktion beginnen
            /*

            announcement.setId("0");

            Gson gson = new Gson();
            String jsonInString = gson.toJson(announcement);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO announcements(data, pushed) VALUES('" + jsonInString + "', false)");

            // Auto increment wert abrufen
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT last_value FROM announcements_id_seq");
            rs2.next();
            String insertedId = rs2.getString(1);

            // id in Objekt anpassen
            announcement.setId(insertedId);
            jsonInString = gson.toJson(announcement);
            Statement stmt3 = conn.createStatement();
            stmt3.executeUpdate("UPDATE announcements SET data='" + jsonInString + "' WHERE id=" + insertedId);

            // Transaktion beenden
            */
        }
    }

