package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class GoogleTranslateAPI {

    public static String googleTranslate(String langFrom, String langTo, String text) throws IOException {
        String urlScript = "https://script.google.com/macros/s/AKfycbz749_PWt_y406G9m7P_0f9_7BSPQICHO3kX3CNb2fheBF3g0g/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlScript);
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(inputLine);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Tu:");
        String text = sc.nextLine();
        System.out.println("Translated text: " + '\n' + googleTranslate("", "vi", text));
    }

}