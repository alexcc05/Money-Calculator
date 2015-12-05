package mc.control;

import application.*;
import mc.model.*;
import mc.persistence.ExchangeRateLoader;
import mc.view.*;

public class ExchangeCommand implements Command {
    private final MoneyDialog fromMoneyDialog;
    private final MoneyDisplay toMoneyDisplay;
    private final CurrencyDialog toCurrencyDialog;

    public ExchangeCommand(MoneyDialog fromMoneyDialog, MoneyDisplay toMoneyDisplay, CurrencyDialog toCurrencyDialog) {
        this.fromMoneyDialog = fromMoneyDialog;
        this.toMoneyDisplay = toMoneyDisplay;
        this.toCurrencyDialog = toCurrencyDialog;
    }

    public ExchangeCommand(FromMoneyPanel fromMoneyPanel, ToMoneyPanel toMoneyPanel, ToCurrencyPanel toCurrencyPanel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void execute() {
        Money money = fromMoneyDialog.get();
        Currency currency = toCurrencyDialog.get();
        ExchangeRate exchangeRate = new ExchangeRateLoader().get(money.getCurrency(), currency);
        Money result = new MoneyExhangeOperation().exchange(money, exchangeRate);
        toMoneyDisplay.show(result);
    }
    
    
    
}
