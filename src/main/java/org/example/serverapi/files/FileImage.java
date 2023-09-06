package org.example.serverapi.files;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;

/***
 * Clase que se encarga de leer los archivos imágenes y enviarlas al cliente.
 */
public class FileImage extends File {

    private final String type;
    /***
     * Constructor de la clase
     * @param content_type (String) el MIME type del archivo a leer.
     */
    public FileImage(String type) {
        this.type = type;
    }

    /***
     * Leera el archivo correspondiente y lo enviará al cliente por el socket dado.
     * @param path (URI) el path donde se encuentra el archivo a leer.
     * @throws IOException En caso de que no se pueda escribir o leer el socket.
     */
    public byte[] readFile(URI path) throws IOException {
        java.io.File file = new java.io.File(path.getPath());
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, type.replace(".", ""), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public String toString() {
        return "File image";
    }
}
