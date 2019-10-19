package com.anderson.testco;

import com.anderson.testco.entities.Product;

public class CarInsurance {
    private Product[] products;

    public CarInsurance(Product[] products) {
        this.products = products;
    }

    public Product[] updatePrice() {
        for (Product product: this.products) {
            if ("Mega Coverage".equals(product.getName())) {
                continue;
            }

            product.decreaseSellIn();

            if ("Special Full Coverage".equals(product.getName())) {
                if (product.getSellIn() < 0) {
                    product.invalidateProduct();
                    continue;
                }

                product.increasePrice();

                if (product.getSellIn() < 10 && product.getSellIn() >= 5) {
                    product.increasePrice();
                } else if (product.getSellIn() < 5){
                    product.increasePrice();
                    product.increasePrice();
                }
                continue;
            }


            if ("Full Coverage".equals(product.getName())) {
                product.increasePrice();
                continue;
            }

            product.decreasePrice();

            if (product.sellByDateHasPassed()) {
                product.decreasePrice();
            }
        }
        return products;
    }

    public Product[] getProducts() {
        return products;
    }
}
