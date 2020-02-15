public class ObserverPatternEmulator {
    public static void main(String[]args){
        Server server = new Server();

        Client marco = new Client("Marco");
        Client franklin = new Client("Franklin");
        Client maria = new Client("Maria");

        server.register(marco);
        server.register(franklin);
        server.register(maria);

        marco.setSubject(server);
        franklin.setSubject(server);
        maria.setSubject(server);

        //verify if exist any notification
        marco.update();

        server.sentNotification("Hola a todo el grupo, hoy comienza las clases");
    }
}
