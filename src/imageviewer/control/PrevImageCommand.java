package imageviewer.control;

import imageviewer.ui.ImageDisplay;

public class PrevImageCommand implements Command {

    private ImageDisplay imageDisplay;

    @Override
    public String name() {
        return "prev";
    }

    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.currentImage().prev());
    }
    
}