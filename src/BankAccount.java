public class BankAccount {
    private double amount;

    // Возвращает текущий остаток на счете
    public double getAmount() {
        return amount;
    }

    // Кладет деньги на счет
    public void deposit(double sum) {
        amount += sum;
        System.out.println("На счет зачислено: " + sum + " сом. Текущий баланс: " + amount + " сом.");
    }

    // Снимает деньги со счета
    public void withDraw(int sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Запрашиваемая сумма превышает остаток на счете.", amount);
        }
        amount -= sum;
        System.out.println("Со счета снято: " + sum + " сом. Остаток на счете: " + amount + " сом.");
    }
}
