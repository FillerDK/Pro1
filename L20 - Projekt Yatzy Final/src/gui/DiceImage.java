package gui;

import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DiceImage {

    private static ArrayList<Image> imageDice = new ArrayList<>();
    private static ArrayList<Image> gifImage = new ArrayList<>();
    public static Image y1Image;
    public static Image aImage;
    public static Image tImage;
    public static Image zImage;
    public static Image y2Image;

    public DiceImage() throws FileNotFoundException {
        FileInputStream y1 = new FileInputStream("D:\\IdeaProjects\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\y1.png");
        FileInputStream a = new FileInputStream("D:\\IdeaProjects\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\a.png");
        FileInputStream t = new FileInputStream("D:\\IdeaProjects\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\t.png");
        FileInputStream z = new FileInputStream("D:\\IdeaProjects\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\z.png");
        FileInputStream y2 = new FileInputStream("D:\\IdeaProjects\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\y2.png");
        y1Image = new Image(y1);
        aImage = new Image(a);
        tImage = new Image(t);
        zImage = new Image(z);
        y2Image = new Image(y2);

        // storing all dice images in "diceImage" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream dice = new FileInputStream(String.format("D:\\IdeaProjects\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\images\\dice%d.png", i));
            imageDice.add(new Image(dice));
        }

        // storing all gifs in "gifImages" field
        for (int i = 1; i <= 6; i++) {
            FileInputStream gif = new FileInputStream(String.format("D:\\IdeaProjects\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\gifs\\gif%d.gif", i));
            gifImage.add(new Image(gif));
        }
    }

    public Image getImageDice(int i) {
        return imageDice.get(i);
    }

    public Image getGifImage(int i) {
        return gifImage.get(i);
    }
}
