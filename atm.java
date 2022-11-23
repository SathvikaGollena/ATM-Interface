import java.util.*;

class bank
{
          String username,password,accno,transhistory="";
          float balance=0f;
           
          public void register()
          {
                 Scanner sc = new Scanner(System.in);
                 System.out.println("Enter your Username :");
                 this.username=sc.nextLine();
                 System.out.println("Enter your Account Number :");
                 this.accno=sc.nextLine();
                 System.out.println("Enter your Password :");
                 this.password=sc.nextLine();
                 System.out.println("You have successfully completed your Registration !!");
           }
           
           public boolean login()
           {
                 Scanner sc = new Scanner(System.in);
                 boolean islogin=false;
                 int count=0;
                 while(!islogin)
                 {
                     System.out.println("Enter User Name : ");
                     String username1=sc.nextLine();
                     if(username1.equals(username))
                     {
                        System.out.println("Enter your Password : ");
                        String password1=sc.nextLine();
                        if(password1.equals(password) && count<2)
                        {
                              System.out.println("Login Successful!!");
                              islogin=true;
                        }
                        else if(count==2)
                        {
                              System.out.println("Exhausted the attempt to login");
                              return islogin;
                        }
                        else
                        {
                              System.out.println("Incorrect Password !! Please try again.!!");
                              count++;
                        }
                      }
                      else
                      {
                              System.out.println("User not found!!");
                      }  
                 }
                 return islogin;
           }

           public void deposit()
           {
                  Scanner sc = new Scanner(System.in);
                  System.out.println("Enter amount to be deposited : ");
                  float amount=sc.nextFloat();
                  try{
                       balance=balance+amount;
                       System.out.println("Successfull Deposited");
                       String s=" Deposited amount "+amount+"\n";
                       transhistory=transhistory.concat(s); 
                  }    
                  catch(Exception e)
                  {

                  }
           }

           public void withdraw()
           {
                  Scanner sc = new Scanner(System.in);
                  System.out.println("Enter amount to be withdraw : ");
                  float amount=sc.nextFloat();
                  try
                  {
                        if(balance >= amount)
                        {
                          balance=balance-amount;
                          System.out.println("Successfull Withdraw");
                          String s=" Withdraw amount "+amount+"\n";
                          transhistory=transhistory.concat(s);
                        }
                        else{
                          System.out.println("Sorry !! Insufficient Balance");
                        }
                  }
                  catch(Exception e)
                  {
                        
                  }
           }

           public void transfer()
           {
                  Scanner sc = new Scanner(System.in);
                  System.out.println("Enter Receipent's Name : ");
                  String receipent =sc.nextLine();
                  System.out.println("Enter amout to be transfer :");
                  float amount=sc.nextFloat();
                  try{
                        if(balance >= amount)
                        {
                           balance=balance-amount;
                           System.out.println("Successfull Transfered");
                           String s=" Transfered amount "+amount+" to " +receipent+"\n";
                           transhistory=transhistory.concat(s);
                        }
                        else{
                           System.out.println("Sorry !! Insufficient Balance");
                        }   
                  }
                  catch(Exception e)
                  {
                        
                  }
           }

           public void checkbalance()
           {
                  System.out.println("Balance : "+balance);
           }

           public void transHistory()
           {
                  if(transhistory=="")
                  {
                        System.out.println("Empty");
                  }
                  else{
                        System.out.println(transhistory);
                  }
           }
}
class atm
{
           public static void main(String args [])
           {
                  bank b=new bank();
                  Scanner sc = new Scanner(System.in);
                  System.out.println("Welcome");
                  System.out.println("Enter 1 for Register ");
                  System.out.println("Enter 2 for Exit");
                  int choice =sc.nextInt();
                  if(choice==1)
                  {
                       b.register();
                       System.out.println("Enter 1 for login ");
                       System.out.println("Enter 2 for Exit");
                       choice=sc.nextInt();
                       if(choice ==1)
                       {
                            if(b.login())
                            {
                                 while(true)  
                                 {  
                                         System.out.println("Automated Teller Machine");  
                                         System.out.println("Choose 1 for Deposit");  
                                         System.out.println("Choose 2 for Withdraw");  
                                         System.out.println("Choose 3 for Transfer");
                                         System.out.println("Choose 4 for Check Balance"); 
                                         System.out.println("Choose 5 for Transaction History");
                                         System.out.println("Choose 6 for EXIT");  
                                         System.out.print("Choose the operation you want to perform:"); 
                                         choice=sc.nextInt();
                                         switch(choice)
                                         {
                                                   case 1:b.deposit();
                                                   break;
                                                   case 2:b.withdraw();
                                                   break;
                                                   case 3:b.transfer();
                                                   break;
                                                   case 4:b.checkbalance();
                                                   break;
                                                   case 5:b.transHistory();
                                                   break;
                                                   case 6:return;
                                         }
                                 }
                            }
                            else{
                              System.out.println("Login fails");
                            }
                       }
                       else
                       {
                            return;
                       }
                  }
                  else
                  {
                        return;
                  }
           }
}
                  