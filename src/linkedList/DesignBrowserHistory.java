// Problem: https://leetcode.com/problems/design-browser-history/
// Defining a double linked list data structure
// SC - O(n) where N is the number of URLs visited
class Node {
    Node next;
    Node prev;
    String data;

    Node() {

    }

    Node(String data) {
        this.data = data;
        this.next = null;
    }

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
        this.prev = null;
    }

    Node(String data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class BrowserHistory {
    Node current;

    public BrowserHistory(String homepage) { // O(1)
        this.current = new Node(homepage); // Initializing the first node
    }

    public void visit(String url) { // O(1)
        // For subsequent nodes 
        Node newNode = new Node(url);
        this.current.next = newNode;
        newNode.prev = this.current;
        this.current = this.current.next;
    }

    public String back(int steps) { // O(steps)
        while (steps > 0 && this.current.prev != null) {
            this.current = this.current.prev;
            steps--;
        }
        return this.current.data;
    }

    public String forward(int steps) { // O(steps)
        while (steps > 0 && this.current.next!=null) {
            this.current = this.current.next;
            steps--;
        }
        return this.current.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */