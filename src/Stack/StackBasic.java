package Stack;

import java.util.Stack;

public class StackBasic {

    public static void main(String[] args) {
        // Integer tipinde bir stack oluştur
        Stack<Integer> stack = new Stack<>();

        // Eleman ekleme (push)
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack); // [10, 20, 30]

        // En üstteki elemanı görüntüleme (peek)
        System.out.println("En üst eleman: " + stack.peek()); // 30

        // En üstteki elemanı çıkarma (pop)
        System.out.println("Çıkarıldı: " + stack.pop()); // 30 çıkarılır

        // Kalan stack'i göster
        System.out.println("Kalan Stack: " + stack); // [10, 20]

        // Stack boş mu?
        System.out.println("Boş mu?: " + stack.isEmpty()); // false

        // Son iki elemanı da çıkaralım
        stack.pop();
        stack.pop();

        // Artık boş
        System.out.println("Boş mu?: " + stack.isEmpty()); // true


        reverseString("Merhaba");
    }


    public static void reverseString(String input) {
        Stack<Character> stack = new Stack<>();

        // Karakterleri stack'e ekle
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Stack'ten çıkararak ters çevir
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Orijinal: " + input);
        System.out.println("Ters: " + reversed);
    }


}