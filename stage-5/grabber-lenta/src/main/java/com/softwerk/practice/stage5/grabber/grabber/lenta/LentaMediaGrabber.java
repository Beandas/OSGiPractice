package com.softwerk.practice.stage5.grabber.grabber.lenta;

import com.softwerk.practice.stage5.AbstractMediaGrabber;
import com.softwerk.practice.stage5.MediaGrabber;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@Component(
        service = MediaGrabber.class,
        immediate = true
)
public class LentaMediaGrabber extends AbstractMediaGrabber implements MediaGrabber {

    private final String mediaName = "Lenta.ru";

    @Override
    public String getMediaName() {
        return this.mediaName;
    }

    @Override
    public List<String> getNewsNames() {
        ArrayList<String> res = new ArrayList<String>();
        try {
            JSONArray array = readJsonFromUrl("https://api.lenta.ru/lists/latest").getJSONArray("headlines");
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                if (o.get("type").equals("news")) {
                    res.add((String) o.getJSONObject("info").get("title"));
                }
            }
        } catch (IOException e) {
            System.err.println("Can't read news from lenta.ru: " + e.getMessage());
        }
        return res;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }
}
