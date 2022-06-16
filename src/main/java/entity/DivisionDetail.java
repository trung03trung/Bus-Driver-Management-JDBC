package entity;

import java.io.Serializable;

public class DivisionDetail implements Serializable {
    private Route routes;
    private int numTurn;

    public DivisionDetail() {
    }

    public DivisionDetail(Route routes, int numTurn) {
        this.routes = routes;
        this.numTurn = numTurn;
    }


    public Route getRoutes() {
        return routes;
    }

    public void setRoutes(Route routes) {
        this.routes = routes;
    }

    public int getNumTurn() {
        return numTurn;
    }

    public void setNumTurn(int numTurn) {
        this.numTurn = numTurn;
    }

    @Override
    public String toString() {
        return "DivisionDetail{" +
                "routes=" + routes +
                ", numTurn=" + numTurn +
                '}';
    }
}
