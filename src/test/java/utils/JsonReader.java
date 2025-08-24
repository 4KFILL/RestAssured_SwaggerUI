package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonReader {
    public static String jsonReader(String path) throws IOException {
        InputStream inputStream = null;

        try {
            inputStream = JsonReader.class.getClassLoader().getResourceAsStream(path);

            if (inputStream != null) {
                String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                inputStream.close();
                return content;
            } else {
                System.out.println("Файл не найден в resources");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
