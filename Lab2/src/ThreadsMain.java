
public class ThreadsMain {
    public static void main(String args[]){
       Thread firstThread = new ThreadOne("Thread One");
       firstThread.start();
       Thread secondThread = new ThreadTwo("Thread Two");
       secondThread.start();
    }
}
