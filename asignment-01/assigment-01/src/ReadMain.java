import java.io.*;
import java.nio.Buffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReadMain {

    private static RandomAccessFile raf;
    private static MappedByteBuffer mappedByteBuffer;
    private static int readMode = -1;

    public static void main(String... args) {

        try {


            RandomAccessFile raf = new RandomAccessFile("file", "rw");
            FileChannel channel = raf.getChannel();


            mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 16);


            int on,tw,tr = 0;

            while (mappedByteBuffer.hasRemaining()) {

                on = mappedByteBuffer.getInt();

                if (on == 1) {
                    tw = mappedByteBuffer.getInt();
                    tr = mappedByteBuffer.getInt();
                    System.out.println( tw + " + " + tr + " = " + (tw+tr));


                    mappedByteBuffer.rewind();

                    mappedByteBuffer.putInt(readMode);


                    mappedByteBuffer.rewind();



                }else if(on==-1){
                    Thread.sleep(1000);
                    System.out.println("waiting...");
                    mappedByteBuffer.rewind();

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

    /*static void say(String s) {
        System.out.println(s);
    }

    static void showParms(String msg, Buffer b) {
        say("Buffer properties - " + msg);
        say("capacity  :" + b.capacity());
        say("limit     :" + b.limit());
        say("position  :" + b.position());
        say("remaining :" + b.remaining());
    }*/

}
