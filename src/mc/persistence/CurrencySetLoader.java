package mc.persistence;

import java.sql.*;
import java.util.ArrayList;
import mc.model.Currency;

public class CurrencySetLoader implements CurrencySet {

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Currency> get() {
        ArrayList<Currency> list = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connect = DriverManager.getConnection("jdbc:sqlite:EXCHANGERATES");
            Statement statement = connect.createStatement();
            String query = "SELECT CURRENCY FROM EXCHANGERATES";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) 
                list.add(new Currency(rs.getString(1)));
            rs.close();
            statement.close();
            connect.close();
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
        return null;
    }
}
