package org.hgwards;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин:");
        String login = scanner.nextLine();

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        boolean isValid = checkLoginAndPassword(login, password);
        if (isValid) {
            System.out.println("Регистрация прошла успешно");
        } else {
            System.out.println("Ошибка регистрации. Проверьте введенные данные.");
        }
    }

    public static boolean checkLoginAndPassword(String login, String password) {
        if (!checkLogin(login)) {
            return false;
        }
        if (!checkPassword(password)) {
            return false;
        }
        return true;
    }

    public static boolean checkLogin(String login) {
        if (login.length() < 4 || login.length() > 16) {
            System.out.println("Кол-во символов, от 4 до 16");
            return false;
        }
        if (!login.matches("[a-zA-Z0-9_\\-]+")) {
            System.out.println("Логин может содержать: Латинские буквы, цифры, .подчеркивание и дефис.");
            return false;
        }
        if (login.contains(" ")) {
            System.out.println("Логин не может содержать пробелы");
            return false;
        }
        return true;
    }

    public static boolean checkPassword(String password) {
        int score = 0;
        if (password.length() >= 8) {
            score += 2;
        } else {
            System.out.println("Пароль слишком короткий (минимум 8 символов)");
        }
        if (password.matches(".*[A-Z].*")) {
            score += 2;
        }
        if (password.matches(".*[a-z].*")) {
            score += 2;
        }
        if (password.matches(".*[0-9].*")) {
            score += 2;
        }
        if (score >= 8) {
            System.out.println("Сильный");
            return true;
        } else if (score >= 4) {
            System.out.println("Средний");
            return true;
        } else {
            System.out.println("Слабый");
            return false;
        }
    }
}