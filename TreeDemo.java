import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class MyFrame extends JFrame implements TreeSelectionListener{
    JTree tree;
    JLabel label;

    MyFrame() {
        super("Tree Demo");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("D://Program//Myjava");
        File f = new File("D://Program//Myjava");

        for (File x : f.listFiles()) {
            if (x.isDirectory()) {
                DefaultMutableTreeNode temp = new DefaultMutableTreeNode(x.getName());
                for (File y : x.listFiles()) {
                    temp.add(new DefaultMutableTreeNode(y.getName()));
                }
                root.add(temp);
            } else {
                root.add(new DefaultMutableTreeNode(x.getName()));
            }
        }
        tree = new JTree(root); // JTree created
        label = new JLabel("No Files Selected");

        tree.addTreeSelectionListener(this);

        //Adding scroll bar so lets see😍
        JScrollPane sp=new JScrollPane(tree);

        add(sp, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
       // To ignore This exception  i just comment it out🫤
        //throw new UnsupportedOperationException("Unimplemented method 'valueChanged'");
        label.setText(e.getPath().toString());
    }
}

public class TreeDemo {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


// Actually in previous code that file directory was not seen so that i made some if else condition and fix it so now see there is no scroll bar so lets add some scroll bar.let see.❤️
// now lets see for the tree selection listner so lets do program........hands are tight😂