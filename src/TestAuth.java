public class TestAuth {


    public static void main(String args[])
    {


        Register.registerUser();


        User user =
                Login.loginUser();



        if(user != null)
        {

            System.out.println(
                    "Welcome "
                    +user.getUsername()
            );


            System.out.println(
                    "Role : "
                    +user.getRole()
            );

        }

    }

}