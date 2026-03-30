import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Test {
    public static void main(String[] args) {
        BufferedImage img = null;
        int[][] imgData = new int[16][16];
        String output = "";
        FileWriter writer;
        String fileName = args[0];

        try {
            img = ImageIO.read(new File(fileName + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                imgData[i][j] = img.getRGB(i, j);
            }
        }

        output += "[";
        for (int i = 0; i < 16; i++) {
            output += "[";
            for (int j = 0; j < 16; j++) {
                output += "[";
                //writer.write((imgData[i][j]  >> 24) & 0X000000FF);
                //writer.write(", ");
                output += Integer.toString((imgData[i][j]  >> 16) & 0X000000FF);
                output += ", ";
                output += Integer.toString((imgData[i][j]  >> 8) & 0X000000FF);
                output += ", ";
                output += Integer.toString((imgData[i][j]  >> 0) & 0X000000FF);
                output += "]";
                if (j != 15) {
                    output += ", ";
                }
            }
            if (i != 15) {
                output += "],\n";
            }
        }
        output += "]]";

        System.out.println(output);

        
        try {
            writer = new FileWriter(new File(fileName + ".txt"));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
