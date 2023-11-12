package work03;

import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 100000000L;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException();
        } else {
            this.owner = owner;
            this.balance = 0.0;
            long result = 0L;

            while(true) {
                result = Utilitor.computeIsbn10(nextNo);
                if (result != 10L) {
                    this.no = 10L * nextNo + result;
                    ++nextNo;
                    return;
                }

                ++nextNo;
            }
        }
    }

    public long getNo() {
        return this.no;
    }

    public Person getOwner() {
        return this.owner;
    }

    public double getBalance() {
        return this.balance;
    }

    public double deposit(double amount) {
        return this.balance += Utilitor.testPositive(amount);
    }

    public double withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException();
        } else {
            this.balance -= Utilitor.testPositive(amount);
            return this.balance;
        }
    }

    public void transfer(double amount, Account account) {
        if (account != null && !(amount > this.balance) && !(amount < 0.0)) {
            this.withdraw(amount);
            account.deposit(amount);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return "Account [no = " + this.no + ", balance = " + this.balance + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Account other = (Account)obj;
            if (this.no != other.no) {
                return false;
            } else {
                if (this.owner == null) {
                    if (other.owner != null) {
                        return false;
                    }
                } else if (!this.owner.equals(other.owner)) {
                    return false;
                }

                return Double.doubleToLongBits(this.balance) == Double.doubleToLongBits(other.balance);
            }
        }
    }
}

