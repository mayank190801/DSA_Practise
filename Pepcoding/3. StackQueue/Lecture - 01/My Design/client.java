import javax.rmi.ssl.SslRMIClientSocketFactory;

public class client {
    public static void main(String[] args) {

        //functioning of stack array for this code
        //this work perfectly for sure

        //and hence this works
        //now i have to implement circular queue for god sake
        // var sta = new dynamicStack(5);

        // System.out.println(sta.isEmpty());
        // sta.push(4);
        // sta.push(5);
        // sta.push(3);

        // System.out.println(sta.pop());
        // sta.push(4);
        // sta.push(5);
        // sta.push(3);
    
        // sta.display();
        // sta.push(3);
        // sta.push(100);
        // sta.display();

        var que = new dynamicQueue(5);
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6);
        // System.out.println(que.poll());
        // System.out.println(que.poll());
        // System.out.println(que.poll());
        // System.out.println(que.poll());
        
        
        que.add(6);
        que.add(7);
        // System.out.println("eyo");
        que.display();        

    }
}
