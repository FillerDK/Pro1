package ex5.B1118;

import java.util.ArrayList;

public class ArrayToChars {
    public static void main(String[] args) {
        System.out.println(toCharacterArray("abc"));
    }

    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> toCharacter = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            toCharacter.add(character);
        }
        return toCharacter;
    }
}
