package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;

    private boolean exChees = false;
    private boolean exTopingVeg = false;
    private boolean exTopingNonVeg = false;
    private boolean bagData = false;

    final int vegPizza = 300;
    final int nonVegPizza = 400;
    final int extraCheesePrice = 80;
    final int exTopingsPriceVeg = 70;
    final int exTopingsPriceNonVeg = 120;
    final int bag = 20;

    public Pizza(Boolean isVeg) {

        this.isVeg = isVeg;
        if (isVeg) {
            this.price = 300;
        } else {
            this.price = 400;

        }

    }

    public int getPrice() {

        return this.price;
    }

    public void addExtraCheese() {

        if (!exChees) {
            this.price = this.price + extraCheesePrice;
            exChees = true;

        }

    }

    public void addExtraToppings() {

        if (!exTopingVeg && isVeg) {
            this.price = this.price + exTopingsPriceVeg;
            exTopingVeg = true;
            exChees = true;

        } else if (!exTopingNonVeg && !isVeg) {
            this.price = this.price + exTopingsPriceNonVeg;
            exTopingNonVeg = true;
            exChees = true;

        }

    }

    public void addTakeaway() {

        if (!bagData) {
            bagData = true;
            this.price = this.price + bag;
        }
    }

    public String getBill() {

        if (isVeg) {
            this.bill = "Base Price Of The Pizza: " + vegPizza + "\n";
        } else {
            this.bill = "Base Price Of The Pizza: " + nonVegPizza + "\n";

        }

        if (exChees) {
            this.bill = this.bill + "Extra Cheese Added: " + extraCheesePrice + "\n";
        }

        if (isVeg && exTopingVeg) {
            this.bill = this.bill + "Extra Toppings Added: " + exTopingsPriceVeg + "\n";
        } else if (!isVeg && exTopingNonVeg) {
            this.bill = this.bill + "Extra Toppings Added: " + exTopingsPriceNonVeg + "\n";

        }

        if (bagData) {
            this.bill = this.bill + "Paperbag Added: " + bag + "\n";
        }

        this.bill = this.bill + "Total Price: " + this.price + "\n";

        return this.bill;
    }
}