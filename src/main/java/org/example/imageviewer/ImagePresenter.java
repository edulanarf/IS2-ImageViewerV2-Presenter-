package org.example.imageviewer;
import org.example.imageviewer.ImageDisplay.*;

public class ImagePresenter {
    private final ImageDisplay display;
    private Image image;


    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.display.on((Shift) this::shift);
        this.display.on((Released) this::released);
    }

    private void released(int offset) {
        if(Math.abs(offset)>=display.getWidth()/2){
            image = offset > 0 ? image.prev() : image.next();
        }
        repaint();
    }

    private void repaint() {
        this.display.clear();
        this.display.paint(image.id(),0);
    }

    private void shift(int offset) {
        display.clear();
        if(offset>0) {
            display.paint(image.prev().id(), offset - display.getWidth());
        } else {
            display.paint(image.next().id(), display.getWidth()+offset);
        }
    }
}
