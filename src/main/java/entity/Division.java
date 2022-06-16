package entity;

import java.io.Serializable;
import java.util.List;

public class Division implements Serializable {
    private Driver driver;
    private List<DivisionDetail> divisionDetails;



    public Division() {
    }

    public Division(Driver driver, List<DivisionDetail> divisionDetails) {
        this.driver = driver;
        this.divisionDetails = divisionDetails;
    }

    

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<DivisionDetail> getDivisionDetails() {
        return divisionDetails;
    }

    public void setDivisionDetails(List<DivisionDetail> divisionDetails) {
        this.divisionDetails = divisionDetails;
    }

    @Override
    public String toString() {
        return "Division{" +
                "driver=" + driver +
                ", divisionDetails=" + divisionDetails +
                '}';
    }
}
