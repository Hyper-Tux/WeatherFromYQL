package be.hypertux.mavenbook.WeatherFromYQL.utils;

import org.apache.commons.io.IOUtils;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class UtilsTest {

    public static boolean isEqual1(InputStream is1, InputStream is2)
            throws IOException
    {
        ReadableByteChannel ch1 = Channels.newChannel(is1);
        ReadableByteChannel ch2 = Channels.newChannel(is2);

        ByteBuffer buf1 = ByteBuffer.allocateDirect(1024);
        ByteBuffer buf2 = ByteBuffer.allocateDirect(1024);

        try {
            while (true) {

                int n1 = ch1.read(buf1);
                int n2 = ch2.read(buf2);

                if (n1 == -1 || n2 == -1) return n1 == n2;

                buf1.flip();
                buf2.flip();

                for (int i = 0; i < Math.min(n1, n2); i++)
                    if (buf1.get() != buf2.get())
                        return false;

                buf1.compact();
                buf2.compact();
            }

        } finally {
            if (is1 != null) is1.close();
            if (is2 != null) is2.close();
        }
    }

    public static boolean isEqual2(InputStream is1, InputStream is2)
            throws IOException
    {
        return IOUtils.contentEquals( is1, is2 );
    }

    public static  boolean isEqual3(InputStream is1, InputStream is2)
            throws IOException
    {
        byte[] buf1 = new byte[64 *1024];
        byte[] buf2 = new byte[64 *1024];
        try {
            DataInputStream d2 = new DataInputStream(is2);
            int len;
            while ((len = is1.read(buf1)) > 0) {
                d2.readFully(buf2,0,len);
                for(int i=0;i<len;i++)
                    if(buf1[i] != buf2[i]) return false;
            }
            return d2.read() < 0; // is the end of the second file also.
        } catch(EOFException ioe) {
            return false;
        } finally {
            is1.close();
            is2.close();
        }
    }
}
