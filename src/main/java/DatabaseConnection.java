import java.sql.*;


    public class DatabaseConnection {

        Connection conn;

        String dbHost;
        String dbPort;
        String dbName;
        String dbUser;
        String dbPassword;

        /*DatabaseConnection(){
            config = new Config();

            dbHost = config.getDbHost();
            dbPort = config.getDbPort();
            dbName = config.getDbName();
            dbUser = config.getDbUser();
            dbPassword = config.getDbPassword();
        }*/

        public void setupDBConnection() {

            try {

                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                //Main.logger.error(e);
            }

            try {
                conn = DriverManager.getConnection("jdbc:postgresql://"+dbHost+":"+dbPort+"/"+dbName, dbUser, dbPassword);
            } catch (SQLException e) {
                //Main.logger.error(e);
            }
        }

        public void insertNews () throws SQLException {
            // Transaktion beginnen
            /*conn.setAutoCommit(false);

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
            conn.commit();
            conn.setAutoCommit(true);*/
        }
    }

