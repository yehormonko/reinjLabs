package customers;


import account.Account;

public abstract class Customer {

    protected String name;
    protected String email;
    protected Account account;

    public void withdraw(double sum, String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String printCustomerDaysOverdrawn() {
        String fullName = name + " " + (this instanceof PrivateCustomer ? ((PrivateCustomer) this).surname : "") + " ";
        String accountDescription = "account.Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return fullName + accountDescription;
    }

    public String printCustomerMoney() {
        String fullName = name + " " + (this instanceof PrivateCustomer ? ((PrivateCustomer) this).surname : "") + " ";
        String accountDescription = "";
        accountDescription += "account.Account: IBAN: " + account.getIban() + ", Money: " + account.getMoney();
        return fullName + accountDescription;
    }

    public String printCustomerAccount() {
        return "account.Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoney() + ", account.Account type: " + (account.isPremium() ? "premium":"normal");
    }
}
