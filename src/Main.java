public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Положить 15,000 сом на счет
        account.deposit(15000);

        // Бесконечный цикл для попыток снятия по 6,000 сом
        while (true) {
            try {
                account.withDraw(6000);
            } catch (LimitException e) {
                // Если недостаточно средств, снимаем только оставшуюся сумму и завершаем цикл
                System.out.println(e.getMessage());
                System.out.println("Снимаю оставшуюся сумму: " + e.getRemainingAmount() + " сом.");
                try {
                    account.withDraw((int) e.getRemainingAmount());
                } catch (LimitException ex) {
                    System.out.println("Ошибка: " + ex.getMessage());
                }
                break;
            }
        }
    }
}
