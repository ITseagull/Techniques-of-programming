import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

public class WriteMain {

    private static RandomAccessFile raf;
    private static MappedByteBuffer mappedByteBuffer;
    private static int writeMode = 1;


    public static void main(String... args) {
        try {

            RandomAccessFile raf = new RandomAccessFile("file", "rw");

            FileChannel channel = raf.getChannel();
            System.out.println(channel.size());
            mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 12);



            int a = (int) (Math.random() * 10) + 1;
            int b = (int) (Math.random() * 10) + 1;

            mappedByteBuffer.putInt(writeMode);
            mappedByteBuffer.putInt(a);
            mappedByteBuffer.putInt(b);
            System.out.println(a+", "+b );
            mappedByteBuffer.rewind();

            while (true) {

                int first = mappedByteBuffer.getInt();
                mappedByteBuffer.rewind();


                if(first==1){
                    Thread.sleep(1000);
                    System.out.println("waiting...");

                }else if(first==-1) {


                     a = (int) (Math.random() * 10) + 1;
                     b = (int) (Math.random() * 10) + 1;

                    System.out.println(a + ", " + b);

                    mappedByteBuffer.putInt(writeMode);
                    mappedByteBuffer.putInt(a);
                    mappedByteBuffer.putInt(b);

                    mappedByteBuffer.rewind();

                    channel.close();

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("exception file not found");
        } catch (IOException e) {
            System.out.println("exception io");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /*static void say(String s) { System.out.println(s); }
    static void showParms(String msg, MappedByteBuffer b) {
        say("Buffer properties - " + msg);
        say("capacity  :" + b.capacity());
        say("limit     :" + b.limit());
        say("position  :" + b.position());
        say("remaining :" + b.remaining());
    }*/
}
