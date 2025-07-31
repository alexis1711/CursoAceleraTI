import concurrent.EmailService;
import concurrent.SmsService;
import concurrent.TransactionsService;

public class Main {


    //public static EmailService emailService = new EmailService();

    public static void main(String[] args) throws InterruptedException {
        TransactionsService transactionsService = new TransactionsService();
        transactionsService.doTransaction2();
    }
}