import java.time.LocalDateTime;

public record Transaction(
        LocalDateTime timestamp,
        String type,          // e.g., "OPEN", "DEPOSIT", "WITHDRAW", "WITHDRAW_DECLINED", "INTEREST_CREDIT", "OVERDRAFT_FEE"
        double amount,        // positive numbers; you can choose to store withdraws as positive
        double balanceAfter,  // balance AFTER applying this txn
        String note           // optional details
) {}