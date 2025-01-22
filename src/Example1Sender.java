import java.net.*;

/**
 * This example illustrates the basic method calls for connectionless
 * datagram socket.
 * @author M. L. Liu
 */
public class Example1Sender {
    // An application which sends a message using connectionless
// datagram socket.
// Three command line arguments are expected, in order:
// <domain name or IP address of the receiver>
// <port number of the receiver's socket>
// <message, a string, to sed>
    public static void main(String[] args) {
        if (args.length != 3)
            System.out.println
                    ("This program requires three command line arguments");
        else {
            try {
                InetAddress receiverHost = InetAddress.getByName(args[0]);
                System.out.println("Host Name: " + receiverHost.getHostName());
                System.out.println("Host Address: " +receiverHost.getHostAddress());
//System.out.println("canonical: " +receiverHost.getCanonicalHostName());
                System.out.println("to String: " +receiverHost.toString());
                int receiverPort = Integer.parseInt(args[1]);
                String message = args[2];
// instantiates a datagram socket for sending the data
                DatagramSocket mySocket = new DatagramSocket(); // bound to any available port
                System.out.println("Bound to port: " + mySocket.getLocalPort());
                byte[ ] buffer = message.getBytes( );
                DatagramPacket datagram =
                        new DatagramPacket(buffer, buffer.length,
                                receiverHost, receiverPort);
                mySocket.send(datagram);
                mySocket.close( );
            } // end try
            catch (Exception ex) {
                ex.printStackTrace( );
            }
        } // end else
    } // end main
} // end class