package test;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.messaging.Message;
import java.util.List;
import java.util.stream.Collectors;

public class AggregatorService {

    // The @Aggregator annotation is not strictly required unless we are using annotation-based configuration.
    // This method assumes we are passing a list of MyAccount objects to be aggregated.
    @Aggregator
    public MyAccount aggregate(List<Message<MyAccount>> messages) {
        // Here we're simply summing the amounts of all accounts and creating a new 'total' account.
        // In a real scenario, you would perform more complex aggregation logic.
        int totalAmount = messages.stream()
                .mapToInt(message -> message.getPayload().getAmount())
                .sum();

        // Creating a new aggregated account object with the total amount
        MyAccount aggregatedAccount = new MyAccount();
        aggregatedAccount.setName("Aggregated Account");
        aggregatedAccount.setNumber(0); // Assuming 0 for a 'summary' account
        aggregatedAccount.setAmount(totalAmount);

        return aggregatedAccount;
    }
}
