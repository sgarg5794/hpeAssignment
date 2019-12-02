
import domain.*;
import util.DomainHelper;
import util.PrintHelper;
import util.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final Map<String,String> employeeData= Stream.of(
            new AbstractMap.SimpleImmutableEntry<>("1234","password1"),
            new AbstractMap.SimpleImmutableEntry<>("5678","password2"),
            new AbstractMap.SimpleImmutableEntry<>("1001","password3"),
            new AbstractMap.SimpleImmutableEntry<>("2911","password4")
    ).collect(Collectors.toMap(AbstractMap.SimpleImmutableEntry::getKey, AbstractMap.SimpleImmutableEntry::getValue));

    public static void main(String[] args) {
        String loginUser=null;
        RecentOrders recentOrders=new RecentOrders();
        Validator validator=new Validator();
        DomainHelper domainHelper=new DomainHelper();
        PrintHelper printHelper=new PrintHelper();

        try(BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))){
            loginUser=validator.validateCredetials(inputReader,employeeData);
            while(true) {
                System.out.println("New Order or Report?(press 'O' for order and 'R' for Report)");
                String input = inputReader.readLine();
                if (input.replaceAll("\\s", "").equalsIgnoreCase("o")) {
                    Customer customer=domainHelper.createCustomer(inputReader);
                    Order order=domainHelper.createOrder(inputReader,customer,new Waiter(Integer.parseInt(loginUser)));
                    addToOrders(order,recentOrders);
                    printHelper.printOrderDetails(order);
                } else if (input.replaceAll("\\s", "").equalsIgnoreCase("r")) {
                    printHelper.printRecentOrders(recentOrders);
                }else{
                    System.out.println("Invalid Input ,Please Try Again!");
                    continue;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public static void addToOrders(Order order,RecentOrders recentOrders){
        recentOrders.placeOrder(order);
    }


}
