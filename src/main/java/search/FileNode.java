/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search;

/**
 *
 * @author Merve
 */
public class FileNode {

    String fileName;
    int count; // Dosyadaki kelimenin geçme sayısı
    FileNode next;

    public FileNode(String fileName) {
        this.fileName = fileName;
        this.count = 1;
        this.next = null;

    }
}
