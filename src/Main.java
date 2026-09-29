import java.util.Scanner;


public class Main {


    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);


        System.out.println("Select Security Level");
        System.out.println("1. LOW");
        System.out.println("2. MEDIUM");
        System.out.println("3. HIGH");


        System.out.print("Enter Choice : ");

        int securityLevel = sc.nextInt();



        String original =
                "images/original/sample.png";


        String encrypted =
                "images/encrypted/encrypted.png";



        System.out.println("Encryption Started");



        ImageEncryptor.encrypt(
                original,
                encrypted,
                securityLevel
        );



        System.out.println(
                "Encryption Completed"
        );



        SenderClient.send(
                encrypted,
                securityLevel
        );



    }

}