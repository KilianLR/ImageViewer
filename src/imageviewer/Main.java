package imageviewer;

import imageviewer.persistence.ImageLoader;
import imageviewer.persistence.files.FileImageLoader;

public class Main {

    public static void main(String[] args) {
        ImageLoader imageLoader = new FileImageLoader("");
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().display(imageLoader.load());
    }
    
}
