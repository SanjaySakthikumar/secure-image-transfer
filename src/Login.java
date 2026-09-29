import java.util.Scanner;


public class Login {


    public static User loginUser()
    {

        Scanner sc =
                new Scanner(System.in);



        System.out.print(
                "Username : "
        );

        String username =
                sc.nextLine();



        System.out.print(
                "Password : "
        );

        String password =
                sc.nextLine();



        User user =
                UserManager.login(
                        username,
                        password
                );



        if(user != null)
        {

            System.out.println(
                    "Login Successful"
            );

        }
        else
        {

            System.out.println(
                    "Invalid Login"
            );

        }


        return user;

    }

}