package org.example.serverapi.minispark.handlers;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Clase que se encarga de armar la petición realizada por el cliente.
 */
public class Request {

    private HashMap<String, String> params = new LinkedHashMap<>();
    private String query;
    private String body;
    private String verb;

    /**
     * Constructor de la clase
     * @param rawData String datos sin procesar de la petición.
     * @param payload String body de la petición realizada.
     */
    public Request(String rawData, String payload) {
        String args = rawData.split("\n")[0];
        System.out.println(args);
        setVerb(args);
        setParams(args);
        setQuery(args);
        setBody(payload);
    }

    /**
     * Guarda el tipo de petición realizada.
     * @param args String que contiene el verbo HTTP.
     */
    private void setVerb(String args) {
        this.verb = args.split(" ")[0];
    }

    /**
     * Guarda los parámetros de la petición.
     * @param args String que contiene los parámetros enviados.
     */
    private void setParams(String args) {
        String path = args.split(" ")[1];
        String[] params = path.split("\\?");
        if(params.length > 1) {
            String[] paramsList = params[1].split("&");
            for (String param: paramsList) {
                String[] listParams = param.split("=");
                this.params.put(listParams[0], listParams[1]);
            }
        }
    }

    /**
     * Guarda el query del endpoint que solicita la petición del cliente.
     * @param args String que contiene el query.
     */
    private void setQuery(String args) {
        String path = args.split(" ")[1];
        String query = path.split("\\?")[0] + "?";
        if(!params.isEmpty()) {
            for (String param: params.keySet()) {
                query += "{"+param+"}&";
            }
        }
        this.query = query.replaceAll(".$", "");
    }

    /**
     * Método que guarda el body de la petición.
     * @param payload String que contiene el body.
     */
    public void setBody(String payload) {
        this.body = payload;
    }

    /**
     * Obtiene el query
     * @return String que es el query de la petición
     */
    public String getQuery() {
        return query;
    }

    /**
     * Obtiene los parámetros de la petición.
     * @return HashMap con los parámetros.
     */
    public HashMap<String, String> getParams() {
        return params;
    }

    /**
     * Obtiene el contenido de un parámetro en concreto.
     * @param nameParam String del nombre del parámetro.
     * @return String que es el contenido de dicho parámetro
     */
    public String getParam(String nameParam) {
        return params.get(nameParam);
    }

    /**
     * Obtiene el body de la petición.
     * @return JSONObject el body respectivo.
     */
    public JSONObject getBody() {
        return new JSONObject(body);
    }

    /**
     * Obtiene el verbo de la petición.
     * @return String con el verbo.
     */
    public String getVerb() {
        return verb;
    }
}
