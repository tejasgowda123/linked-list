
import java.io.*;
import java.util.*;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;



    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }


    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {


            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {

    	return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}




class Node
{
    int data;
    Node nextNode, prevNode;
 
    public Node()
    {
    	prevNode = null;
        nextNode = null;
        data = 0;
    }
    
    public Node(int data, Node nextNode, Node prevNode)
    {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }
   

}
 
public class DoublyLinkedList
{
    Node headNode;
    Node tailNode ;
    public int len;

    public DoublyLinkedList()
    {
        headNode = null;
        tailNode = null;
        len = 0;
    }
    
    public void insertAtStart(int data)
    {
        Node currentNode = new Node();
        currentNode.data = data;
        currentNode.nextNode = null;
        currentNode.prevNode = null;
        
        if(headNode == null)
        {
            headNode = currentNode;
            tailNode = headNode;
        }
        else
        {
            headNode.prevNode = currentNode;
            currentNode.nextNode = headNode;
            headNode = currentNode;
        }
        len++;
    }

    public void insertAtRear(int data)
    {
    	Node currentNode = new Node();
        currentNode.data = data;
        currentNode.nextNode = null;
        currentNode.prevNode = null;        
        if(headNode == null)
        {
            headNode = currentNode;
            tailNode = headNode;
        }
        else
        {
            currentNode.prevNode = tailNode;
            tailNode.nextNode = currentNode;
            tailNode = currentNode;
        }
        len++;
    }
 
    public static void main(String[] args) throws IOException {
    	DoublyLinkedList doubll = new DoublyLinkedList();
		Reader.init(System.in);
		int lsize = Reader.nextInt();
		for(int test1=0;test1<lsize;test1++) {
			doubll.insertAtRear(Reader.nextInt());
		}
		
		Node p1 = doubll.headNode;
		Node p2 = doubll.tailNode;
		
		if(doubll.len==1) {
			System.out.print(p1.data);
		}
		else {
			for (int i = 0; i<=(lsize - 1)/2; i++){
			  System.out.println(p1.data);
			  System.out.println(p2.data);
	
			  p1 = p1.nextNode;
			  p2 = p2.prevNode;
	
			  if (p1 == p2){
			    System.out.println(p1.data);
			    break;
			  }
			}
		}

    }
}
