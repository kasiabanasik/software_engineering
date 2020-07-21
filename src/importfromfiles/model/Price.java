package importfromfiles.model;

import java.math.BigDecimal;
import java.util.Date;

public class Price {

    private BigDecimal value;
    private Date date;

    public Price(BigDecimal value, Date date) {
        this.value = value;
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Date: " + date + " value: " + value;
    }
}
