package concurrent;

public class SmsService {
    public void sendSms(){
        System.out.println("Empecé a enviar el SMS");
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SMS enviado");
    }
}
