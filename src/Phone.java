/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Phone {

    int ID;
    String name;
    int price;
    int year;
    int amount;

    public Phone(int Id, String name, int price, int year, int amount) {
        this.ID = Id;
        this.name = name;
        this.price = price;
        this.year = year;
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Phone{" + "ID=" + ID + ", name=" + name + ", price=" + price + ", year=" + year + ", amount=" + amount + '}';
    }

}
