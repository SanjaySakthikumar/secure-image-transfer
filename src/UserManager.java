import java.util.ArrayList;


public class UserManager {


    private static ArrayList<User> users =
            new ArrayList<>();


    // Temporary default users

    static {

        users.add(
                new User(
                        "hospital",
                        "1234",
                        "HIGH",
                        "RECEIVER"
                )
        );


        users.add(
                new User(
                        "bank",
                        "5678",
                        "MEDIUM",
                        "RECEIVER"
                )
        );

    }



    // Register new user

    public static boolean register(
            String username,
            String password,
            String priority,
            String role
    )
    {


        for(User u : users)
        {

            if(u.getUsername()
                    .equals(username))
            {
                return false;
            }

        }



        users.add(
                new User(
                        username,
                        password,
                        priority,
                        role
                )
        );


        return true;

    }





    // Login verification

    public static User login(
            String username,
            String password
    )
    {


        for(User u : users)
        {

            if(u.getUsername()
                    .equals(username)
              &&
               u.getPassword()
                    .equals(password))
            {

                return u;

            }

        }


        return null;

    }




    // Display users

    public static void displayUsers()
    {

        System.out.println(
                "Available Users"
        );


        for(User u : users)
        {

            System.out.println(
                    u.getUsername()
                    +" - "
                    +u.getRole()
            );

        }

    }


}