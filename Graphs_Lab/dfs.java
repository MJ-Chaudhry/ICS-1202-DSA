// GRAPHS LAB - QUESTION 2

class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    // -----------------------------------------------------------
    public StackX() // constructor
    {
        st = new int[SIZE]; // make array
        top = -1;
    }

    // -----------------------------------------------------------
    public void push(int j) // put item on stack
    {
        st[++top] = j;
    }

    // -----------------------------------------------------------
    public int pop() // take item off stack
    {
        return st[top--];
    }

    // ------------------------------------------------------------
    public int peek() // peek at top of stack
    {
        return st[top];
    }

    // ------------------------------------------------------------
    public boolean isEmpty() // true if nothing on stack-
    {
        return (top == -1);
    }
    // ------------------------------------------------------------
}

class Vertex {
    public char label; // label (e.g. ‘A’)
    public boolean wasVisited;

    // ------------------------------------------------------------
    public Vertex(char lab) // constructor
    {
        label = lab;
        wasVisited = false;
    }
    // ------------------------------------------------------------
}

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private LinkList adjList[]; // array of adjacency lists
    private int nVerts; // current number of vertices
    private StackX theStack;

    // constructor
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjList = new LinkList[MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            adjList[j] = new LinkList(); // initialize each list
        }
        theStack = new StackX();
    }

    // add vertex
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // add edge
    public void addEdge(int start, int end) {
        adjList[start].insertFirst(vertexList[end].label); // add end to start's list
        adjList[end].insertFirst(vertexList[start].label); // add start to end's list (undirected)
    }

    // display vertex
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    // depth-first search
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        // reset flags
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    // get adjacent unvisited vertex
    public int getAdjUnvisitedVertex(int v) {
        Link current = adjList[v].first;
        while (current != null) {
            int neighbor = findVertexIndex(current.iData.label);
            if (neighbor != -1 && !vertexList[neighbor].wasVisited) {
                return neighbor;
            }
            current = current.next;
        }
        return -1;
    }

    // find vertex index by label
    private int findVertexIndex(char label) {
        for (int i = 0; i < nVerts; i++) {
            if (vertexList[i].label == label) {
                return i;
            }
        }
        return -1; // vertex not found
    }
}

class Link {
    public Vertex iData; // data item (key)
    public Link next; // next link in list
    // -------------------------------------------------------------

    public Link(char id) // constructor
    {
        iData = new Vertex(id);
    }

    // -------------------------------------------------------------
    public void displayLink() // display ourself
    {
        System.out.print('{' + iData.label + '}');
    }
} // end class Link

class LinkList {
    public Link first; // ref to first link on list
    // -------------------------------------------------------------

    public LinkList() // constructor
    {
        first = null; // no links on list yet
    }

    // -------------------------------------------------------------
    public void insertFirst(char id) { // make new link
        Link newLink = new Link(id);
        newLink.next = first; // it points to old first link
        first = newLink; // now first points to this
    }

    // -------------------------------------------------------------
    public Link findUnvisited() {
        Link current = first; // start at beginning of list
        while (current != null) { // until end of list
            if (!current.next.iData.wasVisited) { // check if next vertex is unvisited
                return current.next; // return current link if next is unvisited
            }
            current = current.next; // move to next link
        }
        return null; // no unvisited vertex found
    }

    // -------------------------------------------------------------
    public Link delete(char key) // delete link with given key
    { // (assumes non-empty list)
        Link current = first; // search for link
        Link previous = first;
        while (current.iData.label != key) {
            if (current.next == null)
                return null; // didn’t find it
            else {
                previous = current; // go to next link
            }
        } // found it
        if (current == first) // if first link,
            first = first.next; // change first
        else // otherwise,
            previous.next = current.next; // bypass it
        return current;
    }

    // -------------------------------------------------------------
    public void displayList() // display the list
    {
        System.out.print("list (first " + "-->" + " last)");
        Link current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
}

class DFSApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5
        theGraph.addVertex('G'); // 6
        theGraph.addVertex('H'); // 7
        theGraph.addVertex('I'); // 8

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(0, 2); // AC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(1, 5); // BF
        theGraph.addEdge(2, 6); // CG
        theGraph.addEdge(3, 7); // DH
        theGraph.addEdge(4, 8); // EI
        theGraph.addEdge(5, 8); // FI
        theGraph.addEdge(6, 7); // GH
        theGraph.addEdge(7, 8); // HI
        theGraph.addEdge(6, 8); // GI
        theGraph.dfs();
    }
}