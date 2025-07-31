package concurrent;

public class TransactionsService {
    public void doTransaction1(){
        System.out.println("Inicie el proceso");

        EmailService emailService = new EmailService();
        SmsService smsService = new SmsService();

        Thread t1 = new Thread(
                () -> emailService.sendEmail()
        );
        Thread t2 = new Thread(
                () -> smsService.sendSms()
        );

        t1.start();
        t2.start();

        System.out.println("Empecé a notificar");
    }

    public void doTransaction2() throws InterruptedException {
        CounterService counterService = new CounterService();
        CounterService counterService2 = new CounterService();
        CounterService counterService3 = new CounterService();
        CounterService counterService4 = new CounterService();

        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 500; i++) {
                        counterService.aumentar();
                    }
                }
        );
        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 500; i++) {
                        counterService2.aumentar();
                    }
                }
        );
        Thread t3 = new Thread(
                () -> {
                    for (int i = 0; i < 500; i++) {
                        counterService3.aumentar();
                    }
                }
        );
        Thread t4 = new Thread(
                () -> {
                    for (int i = 0; i < 500; i++) {
                        counterService4.aumentar();
                    }
                }
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(2000);
        System.out.println(CounterService.cont);
    }
}
