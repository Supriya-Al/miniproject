import java.io.*;
abstract class Account
{
public int accountid;
public int customerid;
public abstract double deposit(int accountid,double amount);
public  abstract double withdraw(int accountid,double amount);
}

class SavingsAccount extends Account 
{
double balance;
int accountid,cust_id;
int i,j=0;
int n[]=new int[5];
public SavingsAccount(int accountid, int cust_id, double balance) 
{
this.cust_id = cust_id;
this.balance = balance;
this.n[j]=accountid;
j++;
}
public double deposit(int accountid, double amount) 
{
System.out.println("Before Deposited Balance:"+balance);
for(int i=0;i<j;i++)
if(n[i]==accountid)
{
balance+=amount;
return balance;
} 
return -1;
}
public double withdraw(int accountid, double amount) 
{
System.out.println("Before Withdraw Balance:"+balance);
for(i=0;i<j;i++)
if ((n[i]== accountid)&&(balance>=amount))
{
balance=balance-amount;
return balance;
}
 return -1;
}
public double display()
{
return balance;
}
}


class BankDemo
{
static int Acc_num=1234;
public static void main(String arg[])throws IOException
{
int CID=0,ch;
int acc;
double amount;
SavingsAccount[] s=new SavingsAccount[5];
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
do
{
System.out.println("Enter 1----->Create SavingsAccount");
System.out.println("Enter 2----->Deposit");
System.out.println("Enter 3----->Withdraw");
System.out.println("Enter 4----->Display");
System.out.println("Enter 5----->Exit");
System.out.println("Enter your choice:");
ch=Integer.valueOf(br.readLine());
switch(ch)
{
case 1:
	
	System.out.println("Enter the Initial Amount");
	amount=Double.valueOf(br.readLine());
	s[CID]=new SavingsAccount(Acc_num,CID,amount);
	System.out.println("Create SavingsAccount Successfully with cust_id:"+CID+"\t"+"AccountNo:"+Acc_num);
	Acc_num++;
	CID++;
	break;
case 2:
	System.out.println("Enter the Amount for Deposit");
	amount=Double.valueOf(br.readLine());
	System.out.println("Enter your Cust_id");
	CID=Integer.valueOf(br.readLine());
                  System.out.println("Enter your accno");
                 	acc=Integer.valueOf(br.readLine());
	System.out.println("After Deposited Balance:"+s[CID].deposit(acc,amount));
	break;

case 3:

	System.out.println("Enter the Amount for Withdraw");
	amount=Double.valueOf(br.readLine());
	System.out.println("Enter your Cust_id");
	CID=Integer.valueOf(br.readLine());
	System.out.println("Enter your accno");
                 	acc=Integer.valueOf(br.readLine());
	System.out.println("After Withdraw Balance:"+s[CID].withdraw(acc,amount));
	break;
case 4:
	System.out.println("Enter your Cust_id");
	CID=Integer.valueOf(br.readLine());
	System.out.println("Minimum Balance amount is:"+s[CID].display());
	break;
case 5:
	
	System.out.println("Exit!!!!!");
	break;
default:
	
	System.out.println("Invalid choice!!");
}
}while(ch!=5);
}
}
