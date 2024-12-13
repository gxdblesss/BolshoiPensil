package prac13;

//В методе main считай с консоли имя файла, который
//        содержит слова, разделенные пробелом. В методе getLine() используя
//        StringBuilder расставьте все слова в таком порядке, чтобы последняя буква
//        данного слова совпадала с первой буквой следующего не учитывая регистр.
//        Каждое слово должно участвовать 1 раз.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 class WordChain {

    public static void main(String[] args) {
        String fileName = "words.txt"; //  Имя файла задано напрямую

        try {
            String line = readFile(fileName);
            String result = getLine(line);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("Цепочку составить невозможно.");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }


    public static String getLine(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] words = input.trim().split("\\s+");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        return findChain(wordList);
    }

    private static String findChain(List<String> words) {
        if (words.isEmpty()) {
            return "";
        }

        if (words.size() == 1) {
            return words.get(0);
        }

        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            List<String> remainingWords = new ArrayList<>(words);
            remainingWords.remove(i);

            String chain = findChainRecursive(currentWord, remainingWords);
            if (chain != null) {
                return chain;
            }
        }

        return null; // Цепочку составить невозможно
    }


    private static String findChainRecursive(String currentChain, List<String> remainingWords) {
        if (remainingWords.isEmpty()) {
            return currentChain;
        }

        char lastChar = Character.toLowerCase(currentChain.charAt(currentChain.length() - 1));

        for (int i = 0; i < remainingWords.size(); i++) {
            String nextWord = remainingWords.get(i);
            char firstChar = Character.toLowerCase(nextWord.charAt(0));

            if (lastChar == firstChar) {
                List<String> nextRemainingWords = new ArrayList<>(remainingWords);
                nextRemainingWords.remove(i);
                String result = findChainRecursive(currentChain + " " + nextWord, nextRemainingWords);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}