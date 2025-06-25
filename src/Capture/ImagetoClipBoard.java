package Capture;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;

public class ImagetoClipBoard implements ClipboardOwner {

    public void copyImage(BufferedImage image) {
        TransferableImage trans_img = new TransferableImage(image);
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents( trans_img, this );
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        System.out.println("Clipboard lost Ownership");
    }
}


