package ua.khpi.oop.bondar01;

public class Main {
    // --- #1
    //число, що відповідає номеру залікової книжки за допомогою шістнадцяткового літералу;
    static long num1 = 0x1;
    //число, що відповідає номеру мобільного телефона (починаючи з 380...) за допомогою десяткового літералу;
    static long num2 = 380632017150L;
    //число, яке складається з останніх двох ненульових цифр номера мобільного телефону за допомогою двійкового літералу;
    static long num3 = 0b1111;
    //число, яке складається з останніх чотирьох ненульових цифр номера мобільного телефону за допомогою вісімкового літералу;
    static long num4 = 03263;
    //визначити збільшене на одиницю значення залишку від ділення на 26 зменшеного на одиницю номера студента в журналі групи;
    static long num5 = (1-1) % 26 + 1;
    //символ англійського алфавіту в верхньому регістрі, номер якого відповідає знайденому раніше значенню.
    static char num6 = (char)(num5+64);

    public static void main(String args[])
    {
        // --- #1
        System.out.println("#1");
        System.out.println(num1 + " | " + num2 + " | " + num3 + " | " + num4 + " | " + num5 + " | " + num6);

        // --- #2
        long arr[] = new long[6];
        arr[0] = num1;
        arr[1] = num2;
        arr[2] = num3;
        arr[3] = num4;
        arr[4] = num5;
        arr[5] = (long)num6;

        int counter = 0;
        for (int i = 0; i < arr.length; i ++)
            if (arr[i] % 2 == 0)
                counter++;

        System.out.println("#2");
        System.out.println("Count pairs number : " + counter);

        // --- #3
        counter = 0;
        for (int i = 0; i < arr.length; i ++)
            while (arr[i] != 0) {
                if (arr[i] % 2 != 0)
                    counter++;
                arr[i] /= 2;
            }

        System.out.println("#3");
        System.out.println("The number of units in the binary system of numbers : " + counter);
    }
}
