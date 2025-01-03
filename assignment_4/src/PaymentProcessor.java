import java.util.ArrayList;

public class PaymentProcessor {
    ArrayList<Iterable<String>> iterables = new ArrayList<>();
    private FileIO fileIO;
    private EmailCenter emailCenter;
    private UserPayment userPayment;

    public PaymentProcessor() {
        fileIO = new FileIO("logs.txt");
        emailCenter = new EmailCenter(EmailFormat.FORMAL, "sender@example.com");
        userPayment = new UserPayment(10, 100, PaymentUnit.DOLLAR);
    }

    public void addData(Iterable<String> iterable) {
        iterables.add(iterable);
    }

    public void processData() {
        for (Iterable<String> iterable : iterables) {
            for (String userEmail : iterable) {
                String paymentAmount = userPayment.calculatePaymentAmount(userEmail);
                String logEntry = emailCenter.sendPaymentEmail(userEmail, paymentAmount);
                fileIO.write(logEntry);
            }
        }
    }

    public void printLogs() {
        System.out.println(fileIO.read());
    }
}
