package org.example.imageviewer.swing;

import org.example.imageviewer.ImageDisplay;
import org.example.imageviewer.ImageDisplay.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Map;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Shift shitf = Shift.Null;
    private Released released = Released.Null;
    private int initShift;
    private List<Paint> paints = new ArrayList<>();

    public SwingImageDisplay(){
        this.addMouseListener(mouseListener());
        this.addMouseMotionListener(mouseMotionListener());
    }

    private MouseMotionListener mouseMotionListener() {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                shitf.offset(e.getX()-initShift);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        };
    }

    private MouseListener mouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e){}

            @Override
            public void mousePressed(MouseEvent e) {
                initShift = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                released.offset(e.getX() - initShift);
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) { }
        };

    }


    @Override
    public void paint(String id, int offset) {
        paints.add(new Paint(id, offset));
        repaint();
    }

    @Override
    public void clear() {
        paints.clear();
    }

    @Override
    public void on(Shift shift) {
        this.shift = shift != null ? shift : Shift.Null;
    }

    @Override
    public void on(Released released) {
        this.released = released != null ? released : Released.Null;
    }

    private record Paint(String id, int offset){
    }
    private static final Map<String, Color> colors=Map.of(
            "red", Color.RED,
            "green", Color.GREEN,
            "blue", Color.BLUE;
    )
}
