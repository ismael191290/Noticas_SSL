/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletNoticiasB;

import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.api.scripting.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author GS-Server
 */
public class Noticias {
    
    private String titulo;
    private String url;
    private String mensaje;
    private String fecha;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return toJSONObject().toString(); 
    }

    public JSONObject toJSONObject() {
        try {
            return new JSONObject().put("titulo", this.titulo).put("url", this.url).put("mensaje", mensaje).put("fecha", this.fecha);
        } catch (JSONException ex) {
            Logger.getLogger(Noticias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
