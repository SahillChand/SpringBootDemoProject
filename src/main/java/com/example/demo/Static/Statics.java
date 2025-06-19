package com.example.demo.Static;

import org.springframework.stereotype.Component;

@Component
public class Statics {

    private final String getCustomers="""
               SELECT * FROM customers
               WHERE username=?
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
        SET balance = ?
        WHERE username=?
    """;

    private final String updateAssetPrice=
    """
        UPDATE asset_prices
        SET ask=? ,bid=?, last_updated=?
        WHERE asset=?
    """;

    private final String currentSilverPriceUrl="https://goldbroker.com/api/spot-price?metal=XAG&currency=INR&weight_unit=g";

    private final String currentGoldPriceUrl="https://goldbroker.com/api/spot-price?metal=XAU&currency=INR&weight_unit=g";

    private final String askValue=
    """
        SELECT ask FROM asset_prices
        WHERE asset=?
    """;

    public String getAskValue() {
        return askValue;
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
}
