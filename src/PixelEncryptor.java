import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class PixelEncryptor {


    public static void encrypt(
            String input,
            String output,
            int key
    ) throws Exception {


        BufferedImage image =
                ImageIO.read(new File(input));


        int width = image.getWidth();
        int height = image.getHeight();


        BufferedImage encrypted =
                new BufferedImage(
                        width,
                        height,
                        BufferedImage.TYPE_INT_RGB
                );


        ArrayList<Integer> pixels =
                new ArrayList<>();


        // Store all pixel values

        for(int x=0;x<width;x++)
        {
            for(int y=0;y<height;y++)
            {
                pixels.add(
                    image.getRGB(x,y)
                );
            }
        }



        // Shuffle pixels using key

        Collections.shuffle(
                pixels,
                new Random(key)
        );



        int index = 0;


        // Put shuffled pixels

        for(int x=0;x<width;x++)
        {
            for(int y=0;y<height;y++)
            {

                encrypted.setRGB(
                        x,
                        y,
                        pixels.get(index)
                );

                index++;

            }
        }



        ImageIO.write(
                encrypted,
                "png",
                new File(output)
        );


        System.out.println(
                "Pixel Encryption Completed"
        );


    }


}