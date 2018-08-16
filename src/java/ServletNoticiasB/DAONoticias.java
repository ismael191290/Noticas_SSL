/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletNoticiasB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author GS-Server
 */
public class DAONoticias {

    JSONArray aux = new JSONArray();

    public String noticias(String urlFedd) throws ParseException, JSONException {
        boolean add = false;
        JSONArray arra = new JSONArray();
        JSONArray au = new JSONArray();
        JSONArray aux = new JSONArray();

        try {
            URL url = new URL(urlFedd);

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String source = "";
            String line = "";

            Noticias noti = null;
            JSONObject obj = new JSONObject();
            while ((line = br.readLine()) != null) {

                if (line.contains("<item>")) {
                    obj = new JSONObject();
                }

                add = false;
                if (line.contains("<title>")) {
                    int first = line.indexOf("<title>");
                    String temp = line.substring(first);
                    temp = temp.replace("<title>", "");
                    int last = temp.indexOf("</title>");
                    temp = temp.substring(0, last);
                    obj.put("title", temp);
                }
                if (line.contains("<link>")) {
                    int first2 = line.indexOf("<link>");
                    String temp2 = line.substring(first2);
                    temp2 = temp2.replace("<link>", "");
                    int last2 = temp2.indexOf("</link>");
                    temp2 = temp2.substring(0, last2);
                    obj.put("link", temp2);
                }

                if (line.contains("<pubDate>")) {

                    int first4 = line.indexOf("<pubDate>");
                    String temp4 = line.substring(first4);
                    temp4 = temp4.replace("<pubDate>", "");
                    int last4 = temp4.indexOf("</pubDate>");
                    temp4 = temp4.substring(0, last4);
                    String dateStr = temp4.substring(5, 16).toLowerCase();
                    Date dNow = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("dd MMM yyyy");

                    if (dateStr.equals(ft.format(dNow).toLowerCase())) {
                        // noti.setFecha(dateStr);
                        obj.put("fecha", dateStr);
                        add = true;
                    }

                }

                if (line.contains("</item>")) {
                    arra.put(obj);
                }
            }
            br.close();
            for (int i = 0; i < arra.length(); i++) {
                if (arra.getJSONObject(i).has("title")) {
                    au.put(arra.getJSONObject(i));
                }
            }
            for (int i = 0; i < arra.length(); i++) {
                if (au.getJSONObject(i).has("fecha")) {
                    aux.put(arra.getJSONObject(i));
                }
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return aux.toString();
    }
    
    // Trata la estructura de del SSL asignado

    public JSONArray noticias2(String urlFedd) throws ParseException, JSONException {
        boolean add = false;
        JSONArray arra = new JSONArray();
        try {
            URL url = new URL(urlFedd);

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String source = "";
            String line = "";

            Noticias noti = null;
            JSONObject obj = new JSONObject();
            while ((line = br.readLine()) != null) {

                if (line.contains("<item>")) {
                    obj = new JSONObject();
                }

                add = false;
                if (line.contains("<title>")) {
                    int first = line.indexOf("<title>");
                    String temp = line.substring(first);
                    temp = temp.replace("<title>", "");
                    int last = temp.indexOf("</title>");
                    temp = temp.substring(0, last);
                    obj.put("title", temp);
                }
                if (line.contains("<link>")) {
                    int first2 = line.indexOf("<link>");
                    String temp2 = line.substring(first2);
                    temp2 = temp2.replace("<link>", "");
                    int last2 = temp2.indexOf("</link>");
                    temp2 = temp2.substring(0, last2);
                    obj.put("link", temp2);
                }

                if (line.contains("<pubDate>")) {

                    int first4 = line.indexOf("<pubDate>");
                    String temp4 = line.substring(first4);
                    temp4 = temp4.replace("<pubDate>", "");
                    int last4 = temp4.indexOf("</pubDate>");
                    temp4 = temp4.substring(0, last4);
                    String dateStr = temp4.substring(5, 7).toLowerCase();
                   
                    Date dNow = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("dd MMM yyyy");
                     String dataStrComplete =ft.format(dNow).toLowerCase();
                     // valida que las noticias sean del dia y mes en curso
                    if (dateStr.equals(dataStrComplete.substring(0,2))) {
                        obj.put("fecha", dataStrComplete);
                        add = true;
                    }
                }
                if (line.contains("</item>")) {
                    arra.put(obj);
                }
            }
            br.close();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arra;
    }

    
    // obtiene solo los objetos necesarios para mostrar la informacion
    public JSONArray emptys(JSONArray arra) {
        JSONArray au = new JSONArray();
        
        // recore el json[] y busca los titulos para agregarlo en un Json a mostrar
        for (int i = 0; i < arra.length(); i++) {
            try {
                if (arra.getJSONObject(i).has("title")) {
                    au.put(arra.getJSONObject(i));
                }
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
          // de todo el Json con titulos agregados.. busca los que tenga fecha para agregarlos al json a mostrar
        for (int j = 0; j < au.length(); j++) {
            try {
                if (au.getJSONObject(j).has("fecha")) {
                    aux.put(arra.getJSONObject(j));
                }
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return aux;
    }
}
