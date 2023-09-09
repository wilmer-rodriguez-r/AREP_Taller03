package org.example.miniSpark;

import org.example.files.exception.ExceptionFile;
import org.example.handlers.Request;
import org.example.handlers.Response;

/**
 * Functional Interface para Spark
 */
public interface ServiceControllerInterface {

    /**
     * Se encarga de manejar las peticiones y enviar sus respectivas respuestas.
     * @param request Request que tiene todo lo relacionado con la petición realizada.
     * @param response Responde que se encargara de devolver la respuesta solicitada.
     * @return Object que es el contenido de la respuesta a enviar.
     * @throws ExceptionFile Cuando el archivo no se encuentra.
     */
    Object handle(Request request, Response response) throws ExceptionFile;

}
