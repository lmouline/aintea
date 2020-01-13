package duc.aintea.lib.poissonbinomial;

import java.io.*;

public class Computer {

    static {
        String osName = System.getProperty("os.name");
        String target;
        if(osName.equals("Mac OS X")) {
            target = "lib/libpoissonbinomial.dylib";
        } else {
            throw new RuntimeException("No library version for " + osName + ". Sorry :)");
        }

        try {
            File extractedFile = File.createTempFile("aintea_", ".dylib", null);
            extractedFile.deleteOnExit();
            InputStream isLib = Computer.class.getClassLoader().getResourceAsStream(target);
            if(isLib == null) {
                isLib = ClassLoader.getSystemResourceAsStream(target);
            }
            if(isLib == null) {
                throw new RuntimeException("Library not found at " + target);
            }

            OutputStream outLib = new FileOutputStream(extractedFile);
            byte[] buf = new byte[1024];
            int len;
            while((len = isLib.read(buf)) > 0) {
                outLib.write(buf, 0, len);
            }
            outLib.close();
            isLib.close();

            System.load(extractedFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static native double[] compute(double[] probs);

}
