package com.example.demo.Static;

import org.springframework.stereotype.Component;

@Component
public class Statics {

    private final String getCustomers="""
               SELECT * FROM customers
               WHERE username=?
            """;

    private final String fetchBalanceSQL=
            """
                SELECT balance FROM customers
                WHERE username = ?
            """;


    private final String addCustomer=
        """
            INSERT INTO customers VALUES (?,?,?)
        """;

    private final String deleteCustomer=
    """
        DELETE FROM customers
        WHERE username=?
    """;
    private final String updateBalance=
    """
        UPDATE customers
        SET balance = balance - ?
        WHERE username= ?
    """;

    private final String updateCustomerBalance=
    """
        UPDATE customers
        SET balance = ?
        WHERE username = ?
    """;

    private final String updateAssetPrice=
    """
        UPDATE asset_prices
        SET ask=? ,bid=?, last_updated=?
        WHERE asset = ? AND currency = ? AND weight_unit = ?
    """;

    private final String currentSilverPriceUrl="https://goldbroker.com/api/spot-price?metal=XAG&currency=INR&weight_unit=g";

    private final String currentGoldPriceUrl="https://goldbroker.com/api/spot-price?metal=XAU&currency=INR&weight_unit=g";

    private final String askValue=
    """
        SELECT ask FROM asset_prices
        WHERE asset=?
    """;

    private final String fetchCurrentRateSQL=
            """
               SELECT ask FROM asset_prices
               WHERE asset = ? AND currency = ? AND weight_unit = ?
            """;

    private final String updateUserDetailsSQL=
            """
                UPDATE asset_details
                SET quantity_in_gm = quantity_in_gm + ? ,asset_value = asset_value + ?
                where username = ? AND asset = ?
            """;

    private final String addCustomerToAssetDetails=
            """
                INSERT INTO asset_details
                VALUES(?,?,0,0)
            """;

    private final String addCustomerToAuthorities=
            """
                INSERT INTO authorities
                VALUES(?,"ROLE_EMPLOYEE")
            """;

    private final String fetchAvailableAssetQuantity=
            """
                SELECT quantity_in_gm FROM asset_details
                WHERE username = ? AND asset = ?
            """;

    public String getAskValue() {
        return askValue;
    }

    public String getFetchBalanceSQL() {
        return fetchBalanceSQL;
    }
    public String getCurrentGoldPriceUrl() {
        return currentGoldPriceUrl;
    }
    public String getCurrentSilverPriceUrl(){
        return currentSilverPriceUrl;
    }

    public String getUpdateAssetPrice() {
        return updateAssetPrice;
    }

    public String getUpdateBalance() {
        return updateBalance;
    }

    public String getAddCustomer() {
        return addCustomer;
    }

    public String getDeleteCustomer() {
        return deleteCustomer;
    }

    public String getCustomers(){
        return getCustomers;
    }

    public String getFetchCurrentRateSQL() {
        return fetchCurrentRateSQL;
    }

    public String getUpdateUserDetailsSQL() {
        return updateUserDetailsSQL;
    }

    public String getFetchAvailableAssetQuantity() {
        return fetchAvailableAssetQuantity;
    }

    public String getAddCustomerToAssetDetails() {
        return addCustomerToAssetDetails;
    }

    public String getAddCustomerToAuthorities() {
        return addCustomerToAuthorities;
    }

    public String getUpdateCustomerBalance() {
        return updateCustomerBalance;
    }
}
