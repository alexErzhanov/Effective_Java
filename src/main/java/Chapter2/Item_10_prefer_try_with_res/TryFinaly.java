package Chapter2.Item_10_prefer_try_with_res;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryFinaly {

    private static final int BUFFER_SIZE = 1024;

    static void firstLineOfFile() {
        try {
            throw new IllegalAccessException();
        } finally {
            throw new IllegalArgumentException();

            /*There is no record of the first exception (IllegalAccessException)
            in the exception stack trace*/

            /*****with try-with resources you can see all exceptions
             using getSuppressed method**********/
        }
    }

    // try-finally - No longer the best way to close resources!
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // try-finally is ugly when used with more than one resource!
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }}
        finally {
            in.close();
        }
    }
}
