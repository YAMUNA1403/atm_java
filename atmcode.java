import java.util.Scanner;
public class atmprocess {
	int acc_no[]= {101,102,103,104,105};
	String name[]= {"Suresh","Ganesh","Magesh","Naresh","Harish"};
	int pin[]= {411,422,455,644,788};
	int acc_bal[]= {72000,80000,26000,60000,45400};
	int two_thou,five_hun,hund;
	int tot_bal_in_ATM=0;
	public  void Loadcash() {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER TWO THOUSAND COUNT:");
		two_thou=sc.nextInt();
		System.out.println("ENTER FIVE HUNDRED COUNT:");
		five_hun=sc.nextInt();
		System.out.println("ENTER HUNDRED COUNT:");
		 hund = sc.nextInt();
		tot_bal_in_ATM+=(2000*two_thou)+(500*five_hun)+(100*hund);
		System.out.println("\n-------------------------------------------------------\n");
		System.out.println("Denomination\t\tNumber\t\tValue\n");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("2000\t\t\t"+two_thou+"\t\t"+(2000*two_thou)+"\n");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("500\t\t\t"+five_hun+"\t\t"+(500*five_hun)+"\n");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("100\t\t\t"+hund+"\t\t"+(100*hund)+"\n");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("Total available cash in the ATM is :"+tot_bal_in_ATM);

		}
	public void customer_detail() 
	{
		int i;
	    System.out.println("-----------------------------------------------------\n");
	    System.out.println("Acc_No\tAccount_Holder\tPin_Number\tAccount_Balance\n");
	    System.out.println("-----------------------------------------------------\n");
	    for(i=0;i<5;i++)
		    System.out.println(acc_no[i]+"\t "+name[i]+"\t \t"+pin[i]+"\t \t"+acc_bal[i]+"\n");
				System.out.println("---------------------------------------------------\n");     		
	}
    public  void operations() {
    	int choices,pin1,acc_no1,flag;
    	System.out.println("1. Check Balance\n");
    	System.out.println("2. Withdraw Money\n");
    	System.out.println("3. Transfer Money\n");
    	System.out.println("Enter the operation to be performed: ");
    	Scanner s=new Scanner (System.in);
    	choices=s.nextInt();
    	if(choices>0 & choices<4)
    	{
    		System.out.println("Enter your account number \n");
    		acc_no1=s.nextInt();
    		if(acc_no1 == acc_no[0])
    			flag = 0;
    		else if(acc_no1 == acc_no[1])
    			flag = 0;
    		else if(acc_no1 == acc_no[2])
    			flag = 0;
    		else if(acc_no1 == acc_no[3])
    			flag = 0;
    		else if(acc_no1 == acc_no[4])
    			flag = 0;
    		else 
    			flag = 1;
    			
    		
    		if(flag==0)
    		{
    			System.out.println("Enter you Pin\n");
    			pin1=s.nextInt();
    			if(isvalid(pin1))
    			{
    				switch(choices)
    				{
    					case 1:
    						Check_Balance(pin1);
    						break;
    					case 2:
    						Withdraw_Money(pin1);
    						break;
    					case 3:
    						Transfer_Money(pin1);
    						break;
    					default:
    						System.out.println("Invalid Entry");
    						break;
    				}
    			}
    		}
    	}
    }
    public  int user_account(int p)
    {
    	if(p == pin[0])
    		return 0;
    	else if(p == pin[1])
    		return 1;
    	else if(p == pin[2])
    		return 2;
    	else if(p == pin[3])
    		return 3;
    	else if(p == pin[4])
    		return 4;
    	else 
    		return -1;	
    }
    public boolean isvalid(int p)
    {
    	if(user_account(p) == -1)
    		return false;
    	
    	return true;
    }
    public int Check_Balance(int p)
    {
    	int i;
    	i = user_account(p);
    	//System.out.println(i);
    	System.out.println("---------------------------------------------------\n");
    	System.out.println("Your Account Balance is : "+acc_bal[i]);
    	System.out.println("\n---------------------------------------------------\n");	
    	return 0;
    }
   public void Withdraw_Money(int p)
    {
	   Scanner d=new Scanner(System.in);
    	int i,amt;
    	System.out.println("NOTE : Your withdrawal money should be above 100 and below 10000\n");
    	System.out.println("Enter the Amount to be Withdrawn : ");
    	amt=d.nextInt();
    	if((amt<100||amt>10000) && (amt%100 == 0))
    		System.out.println("Enter the valid amount\n");
    	else if(amt>tot_bal_in_ATM)
    		System.out.println("The ATM has insufficient funds");
    	else
    		{
    			i = user_account(p);
    			if(amt > acc_bal[i])
    				System.out.println("The account balance is lower than entered withdrawal amount");
    			else
    			{
    			  	acc_bal[i]-= amt;
    			  	two_thou -= amt/2000;
    			  	amt -= amt/2000;
    			  	five_hun-= amt/1000;
    			  	amt -= amt/1000;
    			  	hund -= amt/100;
    			  	amt -= 100;
    			  	tot_bal_in_ATM-= amt;
    				System.out.println("-----Please Collect the Cash-----Visit again------\n");
    			}
    		}
    }
  public int Transfer_Money(int p)
   {
	  Scanner f=new Scanner (System.in);
       int amt,i,j,acc;
	boolean valid = false;
       System.out.println("NOTE: Max transfer limit per transaction is above 1000 and below 10000\n");
    	System.out.println("Enter the Amount to be transfered : ");
    	amt=f.nextInt();
   	if ((amt<100 || amt >10000) && ((amt%100) == 0))
   		System.out.println("Enter the valid amount\n");
    	i = user_account(p);
    	if(amt > acc_bal[i])
   	   System.out.println("Account balance is lower than entered amount\n"); 
   	else
   	{
   		System.out.println("Enter the Account Number to which the money has to be transfered : ");
   	  	acc=f.nextInt();
   	  	for(j=0;j<5;j++)
   	  	{
   	  		if(acc_no[j] == acc)
   	  		   {
   				 valid = true;
   	  		     break;
   				} 
   		  }
   		if(valid)
   		{
   		  	acc_bal[i] -= amt;
   		  	acc_bal[j] += amt;
   		  	System.out.println("-------------TRANSACTION SUCCESSFULL-------------\n");
   		}
   		else
   		 System.out.println("Invalid Account number\n");
   	}
		return 0;	  
    }
  public void check_ATM_balance()
  {
  	int total=tot_bal_in_ATM;
  	System.out.println("\n-------------------------------------------------------\n");
  	System.out.println("Denomination\tNumber\t\tValue\n");
  	System.out.println("-------------------------------------------------------\n");
  	System.out.println("2000\t\t"+two_thou+"\t\t"+(2000*two_thou)+"\n");
  	System.out.println("-------------------------------------------------------\n");
  	System.out.println("500\t\t"+five_hun+"\t\t"+500*five_hun+"\n");
  	System.out.println("-------------------------------------------------------\n");
  	System.out.println("100\t\t"+hund+"\t\t"+100*hund+"\n");
  	System.out.println("-------------------------------------------------------\n");
  	System.out.print("Total available cash in the ATM is :\n"+total);
  }	
	public static void main(String[] args) {
		int choice;
		Scanner j=new Scanner(System.in);
		atmprocess bb=new atmprocess();
	    do{
	        System.out.println("\n-----------Welcome to the ATM service--------------\n");
			System.out.print("1. Load Cash Into ATM\n");
			System.out.println("2. Maintain Customer Details\n");
			System.out.println("3. ATM Operation\n");
			System.out.println("4. Check ATM Balance\n");
			System.out.println("5. Quit\n");
			System.out.println("---------------------------------------------------\n\n");
			System.out.println("Enter your choice: \n ");
			choice=j.nextInt();
	        switch(choice)
	        {
			case(1):
	            		bb.Loadcash();
	            		break;
			case(2):
		        	bb.customer_detail();
	                	break;
			case(3):
				     bb.operations();
	                	break;
			case(4):
						bb.check_ATM_balance();
	            		break;
			case(5):
				System.out.println("Exit\n");
			System.out.println(" \t\t\tThank you");
			break;
		}
	    }while(choice!=5);
       
	}

}
