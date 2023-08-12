package io.github.skaveesh.util;

import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.Base64;
import java.util.zip.InflaterInputStream;

public class ZLibUtil {
    public static String decompressWithBase64(String str) throws IOException {

        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Empty ZLib data provided");
        }

        str = str.replace("\n", "").replace("\r", "").replace("\\n", "").replace("\\r", "");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try(InputStream byteArrayInput = new ByteArrayInputStream(Base64.getDecoder().decode(str));
            InputStream fin = new InflaterInputStream(byteArrayInput);
            InputStream in = new BufferedInputStream(fin)) {

            IOUtils.copy(in, out, 256);
            out.close();

        } catch (IOException e) {
            out.close();
        }

        return out.toString();
    }
}
