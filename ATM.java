import org.w3c.dom.ls.LSOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    public static int balance = 0;
    private int accountNumber = 123;
    private int pin = 123;

    public int getAccountNumber() {
        return accountNumber;
    }
    public int getPin() {
        return pin;
    }
   static Map<Integer,String> history = new HashMap<>();


    public static void main(String[] args) throws IOException {
        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в банкомат");
        System.out.println("Введите номер аккаунта");
        int inputAccountNumber = sc.nextInt();
        System.out.println("Введите пин код");
        int inputPin = sc.nextInt();
        if ((inputAccountNumber == atm.getAccountNumber() ) && (inputPin == atm.getPin())) {
            while (true) {
                System.out.println("1.Просмотр доступного баланса\n2.Снять средства\n3.Пополнить средства\n4.История операций\n5.Выход");
                System.out.println("Сделайте выбор : ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("Ваш баланс : " + balance);
                    System.out.println("-------------------------------------------");

                } else if (choice == 2) {
                    System.out.println("Укажите сколько вы хотите списать со счета");
                    int spisanie = sc.nextInt();
                    if (spisanie > balance) {
                        System.out.println("Не хватает средств для списания");
                        System.out.println("-------------------------------------------");

                    } else {
                        MinusBalance(spisanie);
                        System.out.println("Вы успешно списали деньги со счета, теперь ваш баланс : " + balance);
                        System.out.println("-------------------------------------------");
                    }
                } else if (choice == 3) {
                    System.out.println("Укажите на сколько вы хотите пополнить счет");
                    int addBalance = sc.nextInt();
                    AddBalance(addBalance);
                    System.out.println("Вы успешно пополнили счет, теперь ваш баланс : " + balance);
                    System.out.println("-------------------------------------------");


                } else if (choice == 4) {
                    for(Map.Entry<Integer,String> entry : history.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    System.out.println("-------------------------------------------");

                }
                else if (choice == 5) {
                    System.exit(0);
                }
                else {
                    System.out.println("Неверно введено число");
                    System.exit(0);
                }
            }

        }
        else{
            System.out.println("Неверно введены данные");
        }
    }
        public static void MinusBalance (int a){
         history.put(a,"Cнятие со счета");
            balance = balance - a;
        }
        public static void AddBalance(int a){
        history.put(a,"Пополнение счета");
            balance = balance + a;
        }
}
