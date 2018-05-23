package generalFrame;

import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("https://www.facebook.com/groups/openjobs.co.il/search/?query=%D7%AA%D7%95%D7%9B%D7%A0%D7%94&filters_rp_chrono_sort=%7B%22name%22%3A%22chronosort%22%2C%22args%22%3A%22%22%7D");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}