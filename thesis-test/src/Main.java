import javax.management.ObjectName;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
//        var buffer = new byte[256];
//        var socket = new Socket("", 1);
//        var bytesRead = socket.getInputStream().read(buffer);
//        System.out.printf("%d Bytes wurden gelesen", bytesRead);
//        System.out.println("Abgeschlossen");

        var buffer = ByteBuffer.allocate(256);
        AsynchronousSocketChannel socket = AsynchronousSocketChannel.open();
        socket.read(buffer, buffer, new CompletionHandler<>() {
            @Override
            public void completed(Integer bytesRead, ByteBuffer attachment) {
                System.out.printf("%d Bytes wurden gelesen", bytesRead);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) { }
        });
        System.out.println("Abgeschlossen");
    }
}
