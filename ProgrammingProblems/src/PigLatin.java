import java.util.Scanner;
public class PigLatin {
    public static void main(String [] args) {
        String vowels = "aeiou";
        Scanner scan = new Scanner(System.in);
        String sentenceStr = scan.nextLine();
        String [] sentenceArr = sentenceStr.trim().split(" ");

        for(int i=0; i < sentenceArr.length; i++) {
            String word = sentenceArr[i].trim();
            // If first word is a vowel
            if(vowels.indexOf(word.charAt(0)) != -1 ) {
                sentenceArr[i] = word + "yay";
            } else {
                sentenceArr[i] = word.substring(1) + word.substring(0,1) + "ay";
            }
        }

        for(int i=0; i < sentenceArr.length; i++) {
            System.out.print(sentenceArr[i] + (i == sentenceArr.length - 1 ? ".\n":"  "));
        }

    }
}
