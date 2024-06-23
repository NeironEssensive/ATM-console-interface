package JFramePractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button;
    public static int MainBalance = 0;
    public static Map<Integer,String> historyInfo = new HashMap<>();


    public static void main(String[] args) {
        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.setTitle("Банкомат");
        frame.setResizable(false); // Добавляем, чтобы предотвратить изменение размера окна
        frame.setVisible(true);
    }

    public Main() {
        super("Банкомат"); // Устанавливаем заголовок окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(false); // Предотвращаем изменение размера окна
        setLocationRelativeTo(null); // Центрируем окно
        getContentPane().setBackground(new Color(223, 177, 182));

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        button = new JButton("Войти");

        add(textField1);
        add(textField2);
        add(button);

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String value1 = textField1.getText();
            String value2 = textField2.getText();

            if (value1.equals("123") && value2.equals("123")) {
                JFrame newWindow = new JFrame("Сбербанк");
                newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newWindow.setSize(500, 500);
                newWindow.setVisible(true);
                newWindow.setResizable(false);
                newWindow.setLayout(new FlowLayout());

                newWindow.getContentPane().setBackground(new Color(223, 177, 182));
                JButton balance = new JButton("Ваш баланс");
                JButton addMoney = new JButton("Пополнить баланс");
                JButton minusMoney = new JButton("Снять средства");
                JButton history = new JButton("История операций");
                newWindow.add(balance);
                newWindow.add(addMoney);
                newWindow.add(minusMoney);
                newWindow.add(history);
              balance.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      JOptionPane.showMessageDialog( null, "Ваш баланс : " + MainBalance);
                  }
              });
              history.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                          JOptionPane.showMessageDialog(null, historyInfo);
                  }
              });
              minusMoney.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      JFrame minusBalanceWindow = new JFrame("Cнять средства");
                      minusBalanceWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      minusBalanceWindow.setSize(500, 500);
                      minusBalanceWindow.setVisible(true);
                      minusBalanceWindow.setResizable(false);
                      minusBalanceWindow.setLayout(new FlowLayout());
                      minusBalanceWindow.getContentPane().setBackground(new Color(223, 177, 182));
                      JTextField minusTextField = new JTextField();
                      JButton minusbutton = new JButton();
                      minusTextField.setPreferredSize(new Dimension(250, 25)); // Пример размеров
                      minusbutton.setPreferredSize(new Dimension(250, 25)); // Пример размеров
                      minusBalanceWindow.add(minusTextField);
                      minusBalanceWindow.add(minusbutton);
                      minusbutton.setText("Снять средства");
                      minusbutton.addActionListener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                              if(MainBalance>=Integer.parseInt(minusTextField.getText())){
                                  historyInfo.put(Integer.parseInt(minusTextField.getText()), "Снятие со счета");
                                  int newValue = MainBalance - Integer.parseInt(minusTextField.getText());
                                  MainBalance = newValue;
                                  JOptionPane.showMessageDialog(null, "Вы успешно сняли деньги со счета, теперь ваш баланс " + MainBalance);
                              }
                              else{
                                  JOptionPane.showMessageDialog(null, "Не хватает средств для списания");
                              }
                          }
                      });
                  }
              });
              addMoney.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      JFrame addBalanceWindow = new JFrame("Пополнение");
                      addBalanceWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      addBalanceWindow.setSize(500, 500);
                      addBalanceWindow.setVisible(true);
                      addBalanceWindow.setResizable(false);
                      addBalanceWindow.setLayout(new FlowLayout());
                      addBalanceWindow.getContentPane().setBackground(new Color(223, 177, 182));
                      JTextField addTextField = new JTextField();
                      JButton addbutton = new JButton();
                      addTextField.setPreferredSize(new Dimension(250, 25)); // Пример размеров
                      addbutton.setPreferredSize(new Dimension(250, 25)); // Пример размеров
                      addBalanceWindow.add(addTextField);
                      addBalanceWindow.add(addbutton);
                      addbutton.setText("Пополнить");
                      addbutton.addActionListener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                              int newValue = MainBalance + Integer.parseInt(addTextField.getText());
                              MainBalance = newValue; // Преобразуем обратно в строку для отображения
                              historyInfo.put(Integer.parseInt(addTextField.getText()), "Пополнение счета");
                              JOptionPane.showMessageDialog( null, "Баланс успешно пополнен, теперь у вас на счету : " + MainBalance);
                          }
                      });
                  }
              });

            } else {
                JOptionPane.showMessageDialog(null, "Данные не найдены!");
            }
        }
    }
}
