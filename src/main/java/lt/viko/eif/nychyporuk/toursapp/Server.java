package lt.viko.eif.nychyporuk.toursapp;

import lt.viko.eif.nychyporuk.toursapp.db.*;
import lt.viko.eif.nychyporuk.toursapp.util.JaxbUtilGeneric;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implements a server that can handle client connections and requests.
 * The server listens on a specified port and uses a separate thread (ClientHandler)
 * to process client requests. It supports sending XML file to the client.
 */
public class Server {

    private ServerSocket serverSocket;

    /**
     * Starts the server on a specified port. It continuously listens for client connections
     * and handles each connection in a separate thread.
     *
     * @param port The port number on which the server will listen for connections.
     */
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            stop();
        }
    }

    /**
     * A private inner class that handles client connections. Each client connection
     * is managed in a separate thread. This handler reads client requests and
     * responds accordingly, including sending XML file to the client.
     */
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        /**
         * Constructs a ClientHandler for handling client-server communication.
         *
         * @param socket The client socket.
         */
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        /**
         * The main execution method for the ClientHandler thread.
         * It sets up streams for communication and processes incoming messages
         * from the client, performing actions based on those messages.
         */
        @Override
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String receivedMessage;
                while ((receivedMessage = in.readLine()) != null) {
                    switch (receivedMessage) {
                        case "xml":
                            sendXML(clientSocket, "generated.xml");
                            break;
                        default:
                            System.out.println("Received unknown query: " + receivedMessage);
                            out.println("Unknown query");
                            break;
                    }
                }

            } catch (IOException e) {
                System.out.println("Exception in ClientHandler: " + e.getMessage());
            } finally {
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                    if (clientSocket != null) clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Exception while closing resources: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Sends a file over a socket connection to a client.
     * This method reads a file by its name, converts it into a byte array,
     * and then sends the byte array over the socket connection to the client.
     *
     * @param clientSocket The socket connection to the client.
     * @param fileName The name of the file to send.
     * @throws IOException If an I/O error occurs while reading the file or sending data over the socket.
     */
    private static void sendFile(Socket clientSocket, String fileName) throws IOException {
        File file = new File(fileName);
        byte[] fileData = new byte[(int)file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(fileData, 0, fileData.length);

        OutputStream os = clientSocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(fileData.length);

        os.write(fileData, 0, fileData.length);
        os.flush();
    }

    /**
     * Sends XML data to a client. This method first converts tour data from the database
     * into XML format and writes it to a file. Then, it sends this file to the client over
     * a socket connection.
     *
     * @param clientSocket The socket connection to the client.
     * @param fileName The name of the XML file that is generated and sent.
     */
    private static void sendXML(Socket clientSocket, String fileName) {
        TourData tourData = new TourData();
        tourData.setTours(DBLoader.loadTours());
        tourData.getTours()
                .forEach(tour -> JaxbUtilGeneric.convertPOJOToXML(tour, fileName));
        try {
            sendFile(clientSocket, fileName);
            System.out.printf("File %s was sent\n", fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stops the server and closes the server socket, releasing any system resources associated with it.
     */
    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    /**
     * Main entry point for the server application. This method initializes and starts the server
     * on a specified port.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.start(1337);
    }
}