package mc.persistence;

import mc.model.*;


public interface ExchangeRateReader {
    ExchangeRate get(Currency from, Currency to);
}
