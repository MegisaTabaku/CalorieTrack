package inxhinierisofti;
public class ExpenditureTracker {
    private List<Double> expenditures = new ArrayList<>();
    private static final double MONTHLY_SPENDING_LIMIT = 1000.0;

    // Metoda per te shtuar cmimet e ushqimeve
    public void addExpenditure(double price) {
        expenditures.add(price);
    }

    public boolean isSpendingLimitExceeded() {
        double totalExpenditure = expenditures.stream().mapToDouble(Double::doubleValue).sum();
        return totalExpenditure > MONTHLY_SPENDING_LIMIT;
    }

    // Metoda per shpenzimeet totale
    public double getTotalExpenditure() {
        return expenditures.stream().mapToDouble(Double::doubleValue).sum();
}
}