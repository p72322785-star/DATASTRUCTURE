import java.util.*;

class p1 {

    static class Node {
        @SuppressWarnings("unused")
        String name;
        int size; // file size (0 for directory)
        boolean isFile;
        List<Node> children;

        Node(String name, int size, boolean isFile) {
            this.name = name;
            this.size = size;
            this.isFile = isFile;
            this.children = new ArrayList<>();
        }
    }

    // Recursive function
    static int getSize(Node node) {
        if (node.isFile) return node.size; // base case

        int total = 0;
        for (Node child : node.children) {
            total += getSize(child);
        }
        return total;
    }

    public static void main(String[] args) {
        // Build directory structure
        Node project = new Node("project", 0, false);

        Node src = new Node("src", 0, false);
        src.children.add(new Node("main.java", 100, true));
        src.children.add(new Node("utils.java", 50, true));

        Node docs = new Node("docs", 0, false);
        docs.children.add(new Node("readme.txt", 10, true));

        Node guides = new Node("guides", 0, false);
        guides.children.add(new Node("setup.pdf", 200, true));

        docs.children.add(guides);

        project.children.add(src);
        project.children.add(docs);
        project.children.add(new Node("config.xml", 20, true));

        System.out.println("Total Size = " + getSize(project) + " KB");
    }
}