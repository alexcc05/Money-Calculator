package mc.persistence;

import java.sql.*;
import mc.model.*;


public class ExchangeRateLoader implements ExchangeRateReader {

    @Override
    public ExchangeRate get( Currency from, Currency to) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connect = DriverManager.getConnection("jdbc:sqlite:EXCHANGERATES");
            Statement statement = connect.createStatement();
            String fromQuery = "SELECT EXCHANGE_RATE_DOLLAR FROM EXCHANGERATES WHERE CURRENCY='"
                    + from.getCode()
                    + "'";
            System.out.println(fromQuery);
            String toQuery = "SELECT EXCHANGE_RATE_DOLLAR FROM EXCHANGERATES WHERE CURRENCY='" 
                    + to.getCode()
                    + "'";
            System.out.println(toQuery);
            ResultSet  fromRs = statement.executeQuery(fromQuery);
            double fromExchange = 0;
            while (fromRs.next()) 
                fromExchange = fromRs.getDouble(1);
            ResultSet  toRs = statement.executeQuery(toQuery);
            double toExchange = 0;
            while (toRs.next()) 
                toExchange = toRs.getDouble(1);
            fromRs.close();
            toRs.close();
            statement.close();
            connect.close();
            return new ExchangeRate(from, to, (float) (toExchange/fromExchange));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
        return null;
    }
}
