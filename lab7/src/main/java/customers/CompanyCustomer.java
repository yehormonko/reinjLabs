package customers;


import account.Account;

public class CompanyCustomer extends Customer{

    protected double companyOverdraftDiscount = 1;
    public CompanyCustomer(String name, String email, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public void withdraw(double sum, String currency){
        super.withdraw(sum,currency);
        double c = companyOverdraftDiscount;
        if(account.isPremium()) c = companyOverdraftDiscount / 2;
        if (account.getMoney() < 0) {
            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * c);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }
}
