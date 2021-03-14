package ru.sber.calculate;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class CalculatorProc {

    private String val1;
    private String val2;

    public String sumValues() {
      BigDecimal x = new BigDecimal(val1);
      x = x.add(new BigDecimal(val2));
      return x.toString();
    }
    public String divisionValues() {
      BigDecimal x = new BigDecimal(val1);
      x = x.divide(new BigDecimal(val2), RoundingMode.HALF_UP);
      return x.toString();
    }
    public String subtractionValues() {
        BigDecimal x = new BigDecimal(val1);
        x = x.subtract(new BigDecimal(val2));
        return x.toString();
    }
    public String multiplicationValues() {
        BigDecimal x = new BigDecimal(val1);
        x = x.multiply(new BigDecimal(val2));
        return x.toString();
    }
}
