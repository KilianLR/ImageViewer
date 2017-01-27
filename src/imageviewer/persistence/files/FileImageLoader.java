package imageviewer.persistence.files;

import imageviewer.model.Image;
import imageviewer.persistence.ImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileImageLoader implements ImageLoader {
    
    private final String filename;

    public FileImageLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public Image load() {
        return new Image() {
            @Override
            public byte[] bitmap() {
                try {
                    FileInputStream is = new FileInputStream(filename);
                    return read(is);
                } catch (IOException ex) {
                    return new byte[0];
                }
            }

            private byte[] read(FileInputStream is) throws IOException {
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                while(true) {
                    int length = is.read(buffer);
                    if(length<1) break;
                    os.write(buffer, 0, length);
                }
                return os.toByteArray();
            }

            @Override
            public Image next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Image prev() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }
    
}