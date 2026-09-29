import java.io.*;
import java.net.*;


public class SenderClient {


public static void send(
        String filePath,
        int level
)
throws Exception {



Socket socket =
        new Socket(
                "localhost",
                5000
        );



System.out.println(
"Connected to Receiver"
);



DataOutputStream out =
        new DataOutputStream(
        socket.getOutputStream()
        );



File file =
        new File(filePath);




// Generate SHA

String hash =
        SHA256.generateHash(
                filePath
        );



// Send security level

out.writeInt(level);



// Send SHA hash

out.writeUTF(hash);



// Send filename

out.writeUTF(
        file.getName()
);



// Send file size

out.writeLong(
        file.length()
);



// Send image bytes


FileInputStream fis =
        new FileInputStream(file);



byte buffer[] =
        new byte[4096];


int bytes;


while((bytes=fis.read(buffer))!=-1)
{

    out.write(
            buffer,
            0,
            bytes
    );

}



fis.close();



System.out.println(
"Encrypted image sent"
);



socket.close();



}


}