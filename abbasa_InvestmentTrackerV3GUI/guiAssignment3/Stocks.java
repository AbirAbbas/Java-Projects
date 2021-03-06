/*
 * Name : Abir Abbas
 * Date : 2017 - 10 - 16
 * Student ID : 0955448
 * Email : abbasa@mail.uoguelph.ca
 */
package guiAssignment3;

import java.text.DecimalFormat;

/**
 *
 * @author Abir Abbas
 */
public class Stocks extends Investment {

    final private double userFee = 9.99;
    final private String userType = "stock";
    private static DecimalFormat df2 = new DecimalFormat(".##"); //format for 2 decimal places

    /**
     * @param symbol, name, quantity, price, bookValue : are all sent into the
     * super function where they are used as values for the current object
     * @param name name of stock
     * @param quantity quantity of stock
     * @param price price of stock
     * @param bookValue bookValue of stock
     * 
    *
     */
    public Stocks(String symbol, String name, int quantity, double price, double bookValue) throws PortfolioException {
        super(symbol, name, quantity, price, bookValue);
    }

    /**
     * @param quantity and price Sells the shares based on user input and user
     * price
     * @param price price of sold stock
     * @return payment made on stock
     * 
    *
     */
    public double sellShares(int quantity, double price) throws PortfolioException {

        double payment = ((quantity * price) - userFee);
        setBookValue(getbookValue() * (double) ((double) (getQuantity() - quantity) / (double) getQuantity()));
        setQuantity(getQuantity() - quantity);
        return payment;

    }

    /**
     * @param quantity and price add shares based on user input at user price
     * Overriden function
     * @param price price of added shares
     * 
    *
     */
    public void addShares(int quantity, double price) throws PortfolioException {
        setQuantity(getQuantity() + quantity);
        setBookValue(getbookValue() + quantity * price + userFee);
        setPrice(price);
    }

    /**
     *
     * @return returns fee for type of investment
     */
    public double getFee() {
        double temp = userFee;
        return temp;
    }

    /**
     *
     * @return returns type of investment
     */
    public String getType() {
        String temp = userType;
        return temp;
    }

    public String toString() {

        return ("Type : Stock" + ", Symbol : " + getSymbol() + ", Name : " + getName() + ", Quantity : " + getQuantity() + ", Price : " + df2.format(getPrice()) + ", Book Value : " + df2.format(getbookValue()));
    }

}
