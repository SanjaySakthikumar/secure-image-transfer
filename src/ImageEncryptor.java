import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;


public class ImageEncryptor {


    public static void encrypt(
            String input,
            String output,
            int level
    ) throws Exception {


        if(level == 1)
        {
            rgbEncrypt(input, output, level);
        }


        else if(level == 2)
        {
            pixelEncrypt(input, output, level);
        }


        else if(level == 3)
        {

            String temp="temp.png";


            rgbEncrypt(
                    input,
                    temp,
                    level
            );


            pixelEncrypt(
                    temp,
                    output,
                    level
            );


            new File(temp).delete();

        }


    }





    private static void rgbEncrypt(
            String input,
            String output,
            int key
    ) throws Exception {



        BufferedImage image =
                ImageIO.read(
                new File(input));



        for(int x=0;x<image.getWidth();x++)
        {

            for(int y=0;y<image.getHeight();y++)
            {


                int pixel =
                        image.getRGB(x,y);



                int a =
                        (pixel>>24)&255;


                int r =
                        (pixel>>16)&255;


                int g =
                        (pixel>>8)&255;


                int b =
                        pixel&255;



                r = (r + key*80) & 255;

                g = (g + key*120) & 255;

                b = (b + key*160) & 255;




                image.setRGB(
                        x,
                        y,
                        (a<<24)
                        |
                        (r<<16)
                        |
                        (g<<8)
                        |
                        b
                );

            }

        }



        ImageIO.write(
                image,
                "png",
                new File(output)
        );


    }








    private static void pixelEncrypt(
            String input,
            String output,
            int key
    ) throws Exception {



        BufferedImage image =
                ImageIO.read(
                new File(input));



        int width =
                image.getWidth();


        int height =
                image.getHeight();



        BufferedImage encrypted =
                new BufferedImage(
                        width,
                        height,
                        BufferedImage.TYPE_INT_ARGB
                );



        ArrayList<Integer> map =
                new ArrayList<>();



        for(int i=0;i<width*height;i++)
        {
            map.add(i);
        }



        Collections.shuffle(
                map,
                new Random(key)
        );




        for(int i=0;i<map.size();i++)
        {


            int newPosition =
                    map.get(i);



            int newX =
                    newPosition % width;


            int newY =
                    newPosition / width;



            int oldX =
                    i % width;


            int oldY =
                    i / width;



            encrypted.setRGB(
                    newX,
                    newY,
                    image.getRGB(
                            oldX,
                            oldY
                    )
            );

        }



        ImageIO.write(
                encrypted,
                "png",
                new File(output)
        );


    }

}