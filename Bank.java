class Bank {
	public static void main(String[] args) {
		Account harry=new Account("Harry",25007);
		harry.deposit(0);
		harry.deposit(1000);
		harry.withDraw(1100);
		harry.withDraw(600);
	}
}

class InsufficientFundException extends Exception {

	InsufficientFundException() {
		super("Funds are insufficient");
	}

	InsufficientFundException(String message) {
		super(message);
	}

}

class Account extends InsufficientFundException {
	private String name;
	private int account;
	private double balance;

	Account() {
		this.name = null;
		this.account = 0;
		this.balance = 0;
	}

	Account(String name, int account) {
		this.name = name;
		this.account = account;
	}

	public String getName() {
		return this.name;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void deposit(double money) {
		try {
			if (money <= 0) {
				throw new InsufficientFundException(this.name + ", You need to deposit amount larger than 0");
			}
			this.balance += money;
			System.out.println(money+"$ added successfully");
		} catch (InsufficientFundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void withDraw(double amount) {
		try {
			if(amount>this.balance) {
				double shortAmount=amount-balance;
				System.out.printf("You are short of %.2f$ for withdrawl\n",shortAmount);
				throw new InsufficientFundException();
			}
			double remainingBalance=balance-amount;
			System.out.printf("You have withdrawl amount of %.2f$\nAvailable balance is %.2f",amount,remainingBalance);
		}
		catch(InsufficientFundException e) {
			System.out.println(e.getMessage());
		}
	}


}