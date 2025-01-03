import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        ArrayList<String> userEmailList = new ArrayList<>();
        userEmailList.add("arrayListEmail1@gmail.com");
        userEmailList.add("arrayListEmail2@gmail.com");
        userEmailList.add("arrayListEmail3@gmail.com");

        String[] userEmailArray = { "arrayEmail1@gmail.com", "arrayEmail2@gmail.com", "arrayEmail3@gmail.com" };

        HashMap<String, String> userEmailMap = new HashMap<>();
        userEmailMap.put("hashMapEmail1@gmail.com", "User1");
        userEmailMap.put("hashMapEmail2@gmail.com", "User2");
        userEmailMap.put("hashMapEmail3@gmail.com", "User3");

        PaymentProcessor processor = new PaymentProcessor();
        processor.addData(new StringArrayAdapter(userEmailArray));
        processor.addData(new HashMapAdapter(userEmailMap));
        processor.addData(userEmailList);
        processor.processData();
        processor.printLogs();
    }
}
