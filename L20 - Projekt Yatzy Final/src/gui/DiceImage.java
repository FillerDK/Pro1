package gui;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DiceImage {

    private static ArrayList<Image> imageDiceDark = new ArrayList<>();
    private static ArrayList<Image> imageDiceClassic = new ArrayList<>();
    private static ArrayList<Image> imageDiceFunky = new ArrayList<>();
    private static ArrayList<Image> gifImageDark = new ArrayList<>();
    private static ArrayList<Image> gifImageClassic = new ArrayList<>();
    private static ArrayList<Image> gifImageFunky = new ArrayList<>();
    public static Image y1Image;
    public static Image aImage;
    public static Image tImage;
    public static Image zImage;
    public static Image y2Image;

    public DiceImage() throws FileNotFoundException {
        FileInputStream y1 = new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\y1.png");
        FileInputStream a = new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\a.png");
        FileInputStream t = new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\t.png");
        FileInputStream z = new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\z.png");
        FileInputStream y2 = new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\y2.png");
        y1Image = new Image(y1);
        aImage = new Image(a);
        tImage = new Image(t);
        zImage = new Image(z);
        y2Image = new Image(y2);

        // storing all darkmode images in "diceImageDark" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream dice = new FileInputStream(String.format("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\diceImages\\darkMode\\dice%d.png", i));
            imageDiceDark.add(new Image(dice));
        }
        // storing all darkmode gifs in "gifImagesDark" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream gif = new FileInputStream(String.format("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\gifs\\diceGifs\\darkmode\\gif%d.gif", i));
            gifImageDark.add(new Image(gif));
        }

        // storing all classic images in "diceImageClassic" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream dice = new FileInputStream(String.format("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\diceImages\\classic\\dice%d.png", i));
            imageDiceClassic.add(new Image(dice));
        }
        // storing all classic gifs in "gifImagesClassic" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream gif = new FileInputStream(String.format("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\gifs\\diceGifs\\classic\\gif%d.gif", i));
            gifImageClassic.add(new Image(gif));
        }

        // storing all funky images in "diceImageFunky" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream dice = new FileInputStream(String.format("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\diceImages\\funky\\dice%d.png", i));
            imageDiceFunky.add(new Image(dice));
        }
        // storing all funky gifs in "gifImagesFunky" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream gif = new FileInputStream(String.format("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\gifs\\diceGifs\\funky\\gif%d.gif", i));
            gifImageFunky.add(new Image(gif));
        }
    }

    public Image getImageDiceDark(int i) {
        return imageDiceDark.get(i);
    }

    public Image getGifImageDark(int i) {
        return gifImageDark.get(i);
    }

    public Image getImageDiceClassic(int i) {
        return imageDiceClassic.get(i);
    }

    public Image getGifImageClassic(int i) {
        return gifImageClassic.get(i);
    }

    public Image getImageDiceFunky(int i) {
        return imageDiceFunky.get(i);
    }

    public Image getGifImageFunky(int i) {
        return gifImageFunky.get(i);
    }
}
