package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;

    private boolean extraCheese=false;
    private boolean isExtraToppinsVeg=false;
    private boolean isExtraToppinsNonVeg=false;
    private boolean paperBag=false;

    final int vegPizza = 300;
    final int nonVegPizza = 400;
    final int extraCheesePrice = 80;
    final int extraToppinsVeg = 70;
    final int extraToppinsNonVeg = 120;
    final int bag = 20;

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        if(isVeg){
            this.price=300;
        }
        else{
            this.price=400;
        }
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        if(!extraCheese){
            this.price=this.price+extraCheesePrice;
            extraCheese=true;
        }
    }

    public void addExtraToppings(){
        if(!isExtraToppinsVeg && isVeg){
            this.price=this.price+extraToppinsVeg;
            isExtraToppinsVeg=true;
            extraCheese=true;
        }
        else if(!isExtraToppinsNonVeg && !isVeg){
            this.price=this.price+extraToppinsNonVeg;
            isExtraToppinsNonVeg=true;
            extraCheese=true;
        }
    }

    public void addTakeaway(){
        if(!paperBag){
            paperBag=true;
            this.price=this.price+bag;
        }
    }

    public String getBill(){
        if (isVeg) {
            this.bill = "Base Price Of The Pizza: " + vegPizza + "\n";
        } else {
            this.bill = "Base Price Of The Pizza: " + nonVegPizza + "\n";

        }

        if (extraCheese) {
            this.bill = this.bill + "Extra Cheese Added: " + extraCheesePrice + "\n";
        }

        if (isVeg && isExtraToppinsVeg) {
            this.bill = this.bill + "Extra Toppings Added: " + extraToppinsVeg + "\n";
        } else if (!isVeg && isExtraToppinsVeg) {
            this.bill = this.bill + "Extra Toppings Added: " + extraToppinsNonVeg + "\n";

        }

        if (paperBag) {
            this.bill = this.bill + "Paperbag Added: " + bag + "\n";
        }

        this.bill = this.bill + "Total Price: " + this.price + "\n";
        return this.bill;
    }
}
