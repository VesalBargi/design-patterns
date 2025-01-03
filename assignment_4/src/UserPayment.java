import java.util.Random;

public class UserPayment {
    private int discountRate;
    private int basePaymentAmount;
    private PaymentUnit paymentUnit;

    public UserPayment(int discountRate, int basePaymentAmount, PaymentUnit paymentUnit) {
        this.discountRate = discountRate;
        this.basePaymentAmount = basePaymentAmount;
        this.paymentUnit = paymentUnit;
    }

    public String calculatePaymentAmount(String userEmail) {
        Random rand = new Random();
        int randInt = rand.nextInt(500);
        int paymentAmount = (basePaymentAmount + randInt) * (100 - discountRate) / 100;
        return paymentAmount + " " + paymentUnit;
    }
}
