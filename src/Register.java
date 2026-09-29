import java.util.Scanner;


public class Register {


    public static void registerUser()
    {

        Scanner sc =
                new Scanner(System.in);



        System.out.print(
                "Enter Username : "
        );

        String username =
                sc.nextLine();



        System.out.print(
                "Enter Password : "
        );

        String password =
                sc.nextLine();



        System.out.print(
                "Priority (LOW/MEDIUM/HIGH) : "
        );

        String priority =
                sc.nextLine();



        System.out.print(
                "Role (SENDER/RECEIVER) : "
        );

        String role =
                sc.nextLine();




        boolean result =
                UserManager.register(
                        username,
                        password,
                        priority,
                        role
                );



        if(result)
        {
            System.out.println(
                    "Registration Successful"
            );
        }
        else
        {
            System.out.println(
                    "Username Already Exists"
            );
        }

    }

}