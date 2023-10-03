/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package work4;

import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author Admins
 */
public class BankAccount {

    private int number;
    private Person owner;
    private double balance;

    public BankAccount(int number, Person owner) {
        this.number = number;
        this.owner = owner;

    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double Deposit(double amount) {
        return this.balance +=  amount;
    }

    public double Withdraw(double amount) {
        return this.balance -= amount;
    }
    public void Transfer(double amount,BankAccount account){
        this.balance -= amount;
        account.balance += amount;
    }
    
    @Override
    public String toString(){

        return "BankAccount(id:"+this.owner+" number:"+this.number+")";
    }

}
