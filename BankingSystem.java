import java.util.Scanner;
abstract class BankAccount{
    final int rateSA =4;
    final int rateCA =6;
    int accNo,balance;
    String name ,city;
    Scanner sc = new Scanner(System.in);
    public BankAccount(){
        balance = 1000;
    }
    abstract public void deposit();
    abstract public void withdraw();
    
    public void addCustData(){
        System.out.println("Enter customer A/C :");
        accNo = sc.nextInt();
        System.out.println("Enter customer name : ");
        name = sc.next();
        System.out.println("Enter customer city : ");
        city = sc.next();
    }
    public void showCustData(){
        System.out.println("Customer A/C : "+ accNo);
        System.out.println("Customer name : " + name);
        System.out.println("Customer city : " + city);
        System.out.println("Account Balance : " + balance);
    }
    
   
}

class SavingAccount extends BankAccount{
    public void deposit(){
        System.out.println("Enter amount to deposit : ");
        int amt = sc.nextInt();
        balance += amt;
    }
    public void withdraw(){
        System.out.println("Enter amount to withdraw : ");
        int amt = sc.nextInt();
        if(balance-amt>= 1000){
            balance -= amt;
        }
        else{
            System.out.println("Insufficient balance");
        }
        
    }
}
class Interest2 extends SavingAccount{
    public void interest(){
        int amt = (balance*(rateSA/100));
        System.out.println("Total interest is : " + amt);
    }
}


class CurrentAccount extends BankAccount{
    public void deposit(){
        System.out.println("Enter amount to deposit : ");
        int amt = sc.nextInt();
        balance += amt;
        System.out.println("updated amt is :" + balance);
    }
    public void withdraw(){
        System.out.println("Enter amount to withdraw : ");
        int amt = sc.nextInt();
        if(balance-amt>= 1000){
            balance -= amt;
            System.out.println("updated amt is :" + balance);
        }
        else{
            System.out.println("Insufficient balance");
        }
        
    }
}
class Interest1 extends CurrentAccount{
    public void interest(){
        int amt = (balance*(rateCA/100));
        System.out.println("Total interest is : " + amt);
    }
}


class BankingSystem{
   
    public static void main(String[] args){
        //BankAccount obj = new BankAccount();
        SavingAccount sa = new SavingAccount();
        CurrentAccount ca = new CurrentAccount();
        Scanner sc1 = new Scanner(System.in);
        while(true){
            System.out.println("1. For Current Account");
            System.out.println("2. For Saving Account");
            System.out.println("3.exit ");
            int n1 = sc1.nextInt();
            if(n1 ==1){

            System.out.println("\t * For Current Account");
            System.out.println("\n1. Add Customer data ");
            System.out.println("2. Show Customer data ");
            System.out.println("3. Deposit  ");
            System.out.println("4. Withdraw ");
            System.out.println("5. Interest ");
            System.out.println("0.Exit");
            int n = sc1.nextInt();
            switch(n){
                case 1: ca.addCustData();break;
                case 2: ca.showCustData();break;
                case 3: ca.deposit();break;
                case 4: ca.withdraw();break;
                case 5: new Interest1().interest(); break;
                case 0: sc1.close();System.exit(0);break;
                
            }
        }
        else if(n1 == 2){
            // SavingAccount sa = new SavingAccount();
            System.out.println("\t * For Saving Account");
            System.out.println("\n1. Add Customer data ");
            System.out.println("2. Show Customer data ");
            System.out.println("3. Deposit  ");
            System.out.println("4. Withdraw ");
            System.out.println("5. Interest ");
            System.out.println("0.Exit");
            int n = sc1.nextInt();
            switch(n){
                case 1: sa.addCustData();break;
                case 2: sa.showCustData();break;
                case 3: sa.deposit();break;
                case 4: sa.withdraw();break;
                case 5: new Interest2().interest(); break;
                case 0: sc1.close();System.exit(0);break;
                
            }
        }
        else{
            System.exit(0);
        }
      
    }
}
}