package concurrent;

public class EmailService {
    public void sendEmail(){
        System.out.println("Empecé a enviar el Correo");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Correo enviado");
    }
}
