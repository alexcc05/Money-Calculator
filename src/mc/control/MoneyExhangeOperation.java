package mc.control;

import mc.model.*;

public class MoneyExhangeOperation {
    public Money exchange(Money money, ExchangeRate exchangeRate) {
        return new Money(money.getAmount() * exchangeRate.getRate(), exchangeRate.getTo());
    }
    
}
