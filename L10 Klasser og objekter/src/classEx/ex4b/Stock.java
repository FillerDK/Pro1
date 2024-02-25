package classEx.ex4b;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getChangePercent() {
        double percentageChange = (currentPrice / previousClosingPrice - 1) * 100;
        return percentageChange;
    }

    public String toString() {
        return String.format("%.2f", getChangePercent());
    }
}
