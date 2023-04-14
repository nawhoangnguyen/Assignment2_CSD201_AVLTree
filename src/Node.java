

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class Node {

    Phone info;
    int height;
    public Node left;
    public Node right;

    public Node(Phone x) {
        height = 1;
        this.info = x;
        this.left = null;
        this.right = null;
    }

    public Phone getInfo() {
        return info;
    }

    public void setInfo(Phone info) {
        this.info = info;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    

    @Override
    public String toString() {
        return "Node{" + "info=" + info + '}';
    }
}
