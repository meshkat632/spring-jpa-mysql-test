package com.wagawin.demo;
import java.sql.*;

public class Postgres {

    public static void main(String[] args) {    	
    	  
    	/*
    	System.setProperty("http.proxyUser", "anwer");
    	System.setProperty("http.proxyPassword", "671984Anujhumu12");    	
    	System.setProperty("http.proxyHost", "bluecoat.media-saturn.com");
    	System.setProperty("http.proxyPort", "80");
    	System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");
    	System.setProperty("https.proxyHost", "bluecoat.media-saturn.com");
    	System.setProperty("https.proxyPort", "80");
    	*/
    	
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        

        String url = "jdbc:postgresql://192.168.1.48:5432/slack";
        String username = "postgres";
        String password = "postgres";
        
        /*
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "admin";
        */

        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM actor");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(2));
                System.out.print("Column 2 returned ");
                System.out.println(rs.getString(3));
            }
            rs.close();
            st.close();
            }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}