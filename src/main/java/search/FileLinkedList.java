/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search;

/**
 *
 * @author Merve
 */
public class FileLinkedList {

     FileNode head;

    public FileLinkedList() {
        this.head = null;
    }

    // Dosya listesine dosya ekleme
    public void add(String fileName) {
        if (head == null) {
            head = new FileNode(fileName);
        } else {
            FileNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new FileNode(fileName);
        }
    }

    // Dosya listesinden bir dosyanın frekansını artırma veya yeni dosya ekleme
    public void incrementOrAdd(String fileName) {
        if (head == null) {
            head = new FileNode(fileName);
        } else {
            FileNode current = head;
            while (current != null) {
                if (current.fileName.equals(fileName)) {
                    current.count++;
                    return;
                }
                current = current.next;
            }
            // Dosya listede bulunamadı, yeni dosya ekle
            add(fileName);
        }
    }

    // Dosya listesini yazdırma
    public void print() {
        FileNode current = head;
        while (current != null) {
            System.out.println("File: " + current.fileName + " - Count: " + current.count);
            current = current.next;
        }
    }
}
