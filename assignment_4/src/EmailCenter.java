public class EmailCenter {
    private EmailFormat format;
    private String senderEmail;

    public EmailCenter(EmailFormat format, String senderEmail) {
        this.format = format;
        this.senderEmail = senderEmail;
    }

    public String sendPaymentEmail(String receiverEmail, String paymentAmount) {
        String log = "The payment email has been sent to " + receiverEmail + " from "
                + senderEmail + " in " + format + " format. The payment amount is " + paymentAmount + ".";
        return log;
    }
}
