/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Merve
 */
public class Tree {

    TreeNode root;
    static Set<String> ignoreList = new HashSet<>(Arrays.asList(
            "a", "ain't", "am", "an", "and", "are", "aren't", "as", "at", "be", "been", "by", "can", "cannot", "cant", "can't",
            "co", "co.", "com", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "don't", "eg", "eg", "else",
            "et", "etc", "ex", "for", "from", "going", "got", "had", "hadn't", "has", "hasn't", "have", "haven't", "he",
            "he'd", "he'll", "her", "hers", "he's", "hi", "him", "his", "how", "i", "i'd", "ie", "if", "i'll", "i'm", "in",
            "inc", "instead", "into", "is", "isn't", "it", "it'd", "it'll", "its", "it's", "i've", "let", "let's", "ltd",
            "may", "mayn't", "me", "might", "mightn't", "mine", "mr", "mrs", "ms", "must", "mustn't", "my", "nd", "needn't",
            "no", "non", "none", "nor", "not", "of", "off", "oh", "ok", "okay", "on", "one's", "onto", "or", "ought",
            "oughtn't", "our", "ours", "out", "over", "per", "que", "qv", "rd", "re", "shall", "shan't", "she", "she'd",
            "she'll", "she's", "should", "shouldn't", "so", "sub", "such", "sup", "th", "than", "that", "that'll", "thats",
            "that's", "that've", "the", "their", "theirs", "them", "then", "thence", "there", "there'd", "there'll",
            "there're", "theres", "there's", "there've", "these", "they", "they'd", "they'll", "they're", "they've", "thing",
            "things", "this", "those", "thus", "to", "too", "un", "up", "us", "via", "viz", "vs", "was", "wasn't", "we",
            "we'd", "we'll", "were", "we're", "weren't", "we've", "what'll", "what's", "what've", "where's", "who'd",
            "who'll", "who's", "will", "with", "won't", "would", "wouldn't", "yet", "you", "you'd", "you'll", "your",
            "you're", "yours", "you've", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20", ",", ".", "<", ">", ";", ":", "'", "\""));

    ;
    
    public Tree() {
        this.root = null;

    }

    // Ağaca kelime eklemek için yardımcı metot
    private TreeNode insert(TreeNode node, String data, String fileName) {
        if (ignoreList.contains(data) || data.contains("<")) {
            return node;
        }

        if (node == null) {
            return new TreeNode(data, fileName);
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            node.left = insert(node.left, data, fileName);
        } else if (compareResult > 0) {
            node.right = insert(node.right, data, fileName);
        } else {
            // Kelime zaten ağaçta var, dosya listesine ekle
            node.fileList.incrementOrAdd(fileName);
        }

        return node;
    }

    // Ağaca kelime ekleme
    public void insert(String data, String fileName) {
        root = insert(root, data, fileName);
    }

    // Ağaçta bir kelimenin geçtiği dosyaları ve frekanslarını yazdıran metot
    private TreeNode printFilesWithFrequency(TreeNode node, String data) {
        if (node == null) {
            return null;
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            return printFilesWithFrequency(node.left, data);
        } else if (compareResult > 0) {
            return printFilesWithFrequency(node.right, data);
        } else {
            System.out.println("Word: " + node.data);
            System.out.println("Files:");
            node.fileList.print();
            return node;
        }
    }

    // Bir kelimenin dosyalardaki frekanslarını yazdıran metot
    public TreeNode printFilesWithFrequency(String data) {
        return printFilesWithFrequency(root, data);
    }

    public void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "/" : "\\") + "-- " + node.data);
            printTree(node.left, prefix + (isLeft ? "|   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "|   " : "    "), false);
        }
    }

    // Ana metotta ağacı yazdırma
    public void printTree() {
        printTree(root, "", false);
    }
}
