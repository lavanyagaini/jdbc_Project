package jdbc_prc_ass;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) {
		UserCRUD crud=new UserCRUD();
	    boolean flag=true;
	do {
		Scanner scanner=new Scanner(System.in);
		  System.out.println("enter 1 for sign up");
		  System.out.println("enter 2 for login");
		  System.out.println("enter 3 to go out");
		  int choice =scanner.nextInt();
		  User user=new User();
//		  U1Crud crud1=new U1Crud();
		 
		  switch(choice) {
		  case 1:{
			  
			 
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the username");
				String username=scanner.next();
				System.out.println("enter the email");
				String email=scanner.next();
				System.out.println("enter the password");
				String password=scanner.next();
				System.out.println("enter the adress");
				String address=scanner.next();	
				user.setId(id);
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);	 
			    try {
					crud.signUser(user);
				} catch (Exception e) {
					System.out.println("handled in signned in");
				}
		  }break;//end of case1
		  case 2:{
			 
			   System.out.println("enter the email");
			   String email=scanner.next();
			   System.out.println("enter the password");
			   String password=scanner.next();
			   user.setEmail(email);
			   user.setPassword(password);
			   try {
				boolean logic=crud.loginUser(user);
				if(logic==true) {
					System.out.println("loginned success");
					System.out.println("press 1 if you are logging for first time");
					System.out.println("press 2 if you are already logged in earlier");
					int choice1=scanner.nextInt();
					switch(choice1) {
					case 1:{
						 System.out.println("enter the facebookpwd");
		            	   String facebookpwd=scanner.next();
		            	   System.out.println("enter the instagram password");
		            	   String instapwd=scanner.next();
		            	   System.out.println("enter the snappwd");
		            	   String snappwd=scanner.next();
		            	   System.out.println("enter the whatsapppwd");
		            	   String whatsappwd=scanner.next();
		            	   System.out.println("enter the twitterpwd");
		            	   String twitterpwd=scanner.next();
		            	   user.setFacebookpwd(facebookpwd);
		            	   user.setInstapwd(instapwd);
		            	   user.setSnappwd(snappwd);
		            	   user.setWhatsapppwd(whatsappwd);
		            	   user.setTwitterpwd(twitterpwd);
		            	   crud.setPwd(user);
					}break;
					case 2:{
						 System.out.println("you are already visited our app");
						   System.out.println("your details are");
						    crud.displayPwd(user);
						   System.out.println("press 1 for changes in passwords");
						   System.out.println("press 2 for no changes  ");
						   int change=scanner.nextInt();
						   switch(change) {
						   case 1:{
							   System.out.println("press 1 to change facebookpwd ");
							   System.out.println("press 2 to change instapassword");
							   System.out.println("press 3 to change snappassword");
							   System.out.println("press 4 to change whatsapppassword");
							   System.out.println("press 5 to change twitterpassword");
							   System.out.println("press 6 if you dont want to change  ");
							   System.out.println("please enter your choice");
							   int passchoice=scanner.nextInt();
							   switch(passchoice) {
							   case 1:{
								   System.out.println("enter new facebook password");
								   String facebookpassword=scanner.next();
								   user.setFacebookpwd(facebookpassword);
								   crud.updateFacebookPwd(user);
							   }break;
							   case 2:{
								   System.out.println("enter new instagram password");
								   String instapassword=scanner.next();
								   user.setInstapwd(instapassword);
								   crud.updateInstagramPwd(user);
							   }break;
							   case 3: {
								   System.out.println("enter new snapchatpassword");
								   String snappassword=scanner.next();
								   user.setSnappwd(snappassword);
								   crud.updateSnapPwd(user);
							   }break;
							   case 4:{
								   System.out.println("enter new Whatsapppassword");
								   String whatsapppassword=scanner.next();
								   user.setSnappwd(whatsapppassword);
								   crud.updateWhatsappPwd(user);
							   }break;
							   case 5:{
								   System.out.println("enter new twitter password");
								   String twitterpassword=scanner.next();
								   user.setSnappwd(twitterpassword);
								   crud.updateTwitterPwd(user);
							   }break;
							   case 6:{
								   System.out.println("thank you for updateting");
							   }break;
					
							   }//switch passchoice
						   }
						   case 2:{
							   System.out.println("thank you");
						   }break;
						   }
					}
					}
				}else {
					System.out.println("invalid password");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }break;
		  case 3:{
			  System.out.println("thank you");
			  flag=false;
		  }
			
		  }//end of switch
	}//end of do
	while(flag);
	}
}
