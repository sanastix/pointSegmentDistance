package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long x0 = scanner.nextInt();
        long y0 = scanner.nextInt();
        long x1 = scanner.nextInt();
        long y1 = scanner.nextInt();
        long x2 = scanner.nextInt();
        long y2 = scanner.nextInt();

        double distance = calculateDistance(x0, y0, x1, y1, x2, y2);

        System.out.printf("%.5f", distance);

    }

    public static double calculateDistance(long x0, long y0, long x1, long y1, long x2, long y2) {
        // Вектори від точки до кінців відрізка
        double v1x = x2 - x1;
        double v1y = y2 - y1;
        double v2x = x0 - x1;
        double v2y = y0 - y1;
        double v3x = x0 - x2;
        double v3y = y0 - y2;

        // Визначення скалярних і векторних добутків
        double dotProduct1 = v1x * v2x + v1y * v2y;
        double dotProduct2 = -(v1x * v3x + v1y * v3y);
        double crossProduct = v1x * v2y - v1y * v2x;

        // Обчислення відстані
        if (dotProduct1 >= 0 && dotProduct2 >= 0) {
            return Math.abs(crossProduct) / Math.sqrt(v1x * v1x + v1y * v1y);
        } else {
            // Відстань до найближчого кінця відрізка
            double distanceToEndpoint1 = Math.sqrt(v2x * v2x + v2y * v2y);
            double distanceToEndpoint2 = Math.sqrt(v3x * v3x + v3y * v3y);
            return Math.min(distanceToEndpoint1, distanceToEndpoint2);
        }
    }

}