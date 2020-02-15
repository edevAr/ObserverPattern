import java.util.ArrayList;
import java.util.List;

public class Server implements Subject {
    private List<Observer>clients;
    private String notification;
    private boolean changed;
    private final Object MUTEX = new Object();

    public Server(){
        this.clients = new ArrayList<Observer>();
    }
    public void register(Observer observer) {
        if(null == observer) throw new NullPointerException("Null Observer");
        synchronized (MUTEX){
            if(!clients.contains(observer))
                clients.add(observer);
        }
    }

    public void unregister(Observer observer) {
        synchronized (MUTEX){
            clients.remove(observer);
        }
    }

    public void notifyObservers() {
        List<Observer> clientsLocal = null;
        synchronized (MUTEX){
            if(!changed)
                return;
            clientsLocal = new ArrayList<Observer>(this.clients);
            this.changed = false;
        }
        for (Observer observer : clientsLocal) {
            observer.update();
        }
    }

    public Object getUpdate(Observer observer) {
        return this.notification;
    }
    public void sentNotification(String message){
        System.out.println("Message send to all clients");
        this.notification = message;
        this.changed = true;
        notifyObservers();
    }
}
