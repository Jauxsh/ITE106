import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            analyzeFile();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to access the file: " + e.getMessage());
        }
    }

    public static void analyzeFile() throws IOException {
        File file = new File("JauxshFile.txt");

        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        int wordCount = 0;
        int sentenceCount = 0;
        int longestWordLength = 0;
        String longestWord = "";
        String[] uniqueWords = new String[100];
        int[] wordFrequencies = new int[100];  
        int uniqueWordCount = 0;
        int lineNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                System.out.println("Line " + lineNumber + ": " + line);

                String cleanLine = line.replaceAll("[^a-zA-Z0-9\\s]", "");

                String[] wordArray = cleanLine.split("\\s+");
                wordCount += wordArray.length;

                for (String word : wordArray) {
                    if (word.length() == 0) continue;


                    int wordLength = word.length();
                    if (wordLength > longestWordLength) {
                        longestWordLength = wordLength;
                        longestWord = word;
                    }

                    boolean found = false;
                    for (int i = 0; i < uniqueWordCount; i++) {
                        if (uniqueWords[i].equalsIgnoreCase(word)) {
                            wordFrequencies[i]++; 
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        uniqueWords[uniqueWordCount] = word;
                        wordFrequencies[uniqueWordCount] = 1;
                        uniqueWordCount++;
                    }
                }

                sentenceCount += countSentences(line);
            }
        }

        File newFile = new File("JauxshFiletoUpperCase.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line.toUpperCase());
                    writer.newLine();
                }
            }
        }

        printResults(wordCount, sentenceCount, longestWord, uniqueWords, wordFrequencies, uniqueWordCount);
    }

    public static int countSentences(String line) {
        int sentenceCount = 0;
        for (char c : line.toCharArray()) {
            if (c == '.' || c == '?' || c == '!') {
                sentenceCount++;
            }
        }
        return sentenceCount;
    }

    public static void printResults(int wordCount, int sentenceCount, String longestWord, String[] uniqueWords, int[] wordFrequencies, int uniqueWordCount) {
        System.out.printf("\n");
        System.out.printf("%-15s\t:  %d\n", "Word Count", wordCount);
        System.out.printf("%-15s\t:  %d\n", "Sentence Count", sentenceCount);
        System.out.printf("%-15s\t:  %s\n", "Longest Word", longestWord != null ? longestWord : "N/A");

        System.out.println("Word Frequencies:");
        for (int i = 0; i < uniqueWordCount; i++) {
            System.out.printf("%-15s\t:  %d\n", uniqueWords[i], wordFrequencies[i]);
        }
    }
}

