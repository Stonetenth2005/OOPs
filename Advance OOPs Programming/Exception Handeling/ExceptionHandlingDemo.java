// ===============================
// CUSTOM CHECKED EXCEPTION
// ===============================

// Extending Exception makes it a CHECKED exception
// Compiler forces handling using try-catch or throws
class InsufficientBalanceException extends Exception {

    // Constructor for custom message
    InsufficientBalanceException(String message) {
        super(message);
    }
}



// ===============================
// CUSTOM UNCHECKED EXCEPTION
// ===============================

// Extending RuntimeException makes it an UNCHECKED exception
// Compiler does NOT force handling
class InvalidAmountException extends RuntimeException {

    InvalidAmountException(String message) {
        super(message);
    }
}



// ===============================
// BANK ACCOUNT CLASS
// ===============================

class BankAccount {

    private String accountHolder;
    private double balance;

    // Constructor
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }


    // Deposit method
    void deposit(double amount) {

        // Unchecked exception
        // Usually used for logical/programming mistakes
        if (amount <= 0) {

            // throw keyword manually creates exception
            throw new InvalidAmountException(
                "Deposit amount must be positive"
            );
        }

        balance += amount;

        System.out.println(
            amount + " deposited successfully"
        );
    }


    // throws keyword declares that this method
    // MAY throw checked exception
    void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {

            // Checked custom exception
            throw new InsufficientBalanceException(
                "Insufficient Balance"
            );
        }

        balance -= amount;

        System.out.println(
            amount + " withdrawn successfully"
        );
    }


    void displayBalance() {

        System.out.println(
            "Current Balance: " + balance
        );
    }
}




// ===============================
// MAIN CLASS
// ===============================

public class ExceptionHandlingDemo {

    public static void main(String[] args) {

        BankAccount user =
            new BankAccount("Tushar", 5000);


        // try block contains risky code
        try {

            user.displayBalance();

            // Valid deposit
            user.deposit(2000);

            // Uncomment to test unchecked exception
            // user.deposit(-100);

            // Checked exception example
            user.withdraw(10000);

            // This line will NOT execute
            // because exception occurs above
            System.out.println(
                "Transaction completed"
            );
        }


        // Specific catch block
        catch (InsufficientBalanceException e) {

            System.out.println(
                "Checked Exception Caught: "
                + e.getMessage()
            );
        }


        // Unchecked exception catch block
        catch (InvalidAmountException e) {

            System.out.println(
                "Unchecked Exception Caught: "
                + e.getMessage()
            );
        }


        // Generic catch block
        // Usually kept at the end
        catch (Exception e) {

            System.out.println(
                "Unexpected Exception: "
                + e.getMessage()
            );
        }


        // finally block always executes
        // Used for cleanup operations
        finally {

            System.out.println(
                "Finally block executed"
            );
        }


        // Program continues even after exception
        System.out.println(
            "Program continues normally"
        );
    }
}