/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search;

/**
 *
 * @author Merve
 */
public class TreeNode {

    String data;
    FileLinkedList fileList;
    TreeNode left;
    TreeNode right;
    String key;

    public TreeNode(String data, String fileName) {
        this.data = data;
        this.fileList = new FileLinkedList();
        this.fileList.add(fileName);
        this.left = null;
        this.right = null;
    }
}
