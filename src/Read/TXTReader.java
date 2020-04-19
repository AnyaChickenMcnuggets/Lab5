package Read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TXTReader {
    public static int txtReader(String fileName){
        File f = new File(fileName);
        String line;

        try (FileInputStream stream = new FileInputStream(f)) {
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0) {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
