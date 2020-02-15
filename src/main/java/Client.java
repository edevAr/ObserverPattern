public class Client implements Observer {
    private String name;
    private Subject server;

    public Client(String name){
        this.name = name;
    }
    public void update() {
        String notification= (String)server.getUpdate(this);
        if(null == notification)
            System.out.println("No hay nuevas notificaciones");
        else
            System.out.println("Notificacion para: "+name+ " - "+notification);
    }

    public void setSubject(Subject subject) {
        this.server = subject;
    }
}
