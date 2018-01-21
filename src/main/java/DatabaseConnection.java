import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseConnection {

        static Connection conn;

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

        static public void insertNews (News news) throws SQLException {

            Gson gson = new Gson();
            String jsonInString = gson.toJson(news);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO \"News\"(data) VALUES('" + jsonInString + "')");
        }

        static public ObservableList<News> getNews() throws SQLException{

            ObservableList<News> newsList = FXCollections.observableArrayList();
            PreparedStatement stmt = conn.prepareStatement("Select DATA from \"News\"");
            ResultSet set = stmt.executeQuery();
            while(set.next()){
                Gson gson = new Gson();
                String string = set.getString(1);
                News news  = gson.fromJson(string, News.class);
                newsList.add(news);
            }
            return newsList;
        }
    }

