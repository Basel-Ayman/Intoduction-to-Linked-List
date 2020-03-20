package eg.edu.alexu.csd.datastructure.linkedList.cs18_cs52;

import java.util.Scanner;

public class UIApplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PolynomialSolver poly = new PolynomialSolver();
            char var1, var2, choice;
            boolean error;
            while (true) {
                do {
                    System.out.println("Please choose an action\n" +
                            "----------------------\n" +
                            "1- Set a polynomial variable\n" +
                            "2- Print the value of a polynomial variable\n" +
                            "3- Add two polynomials\n" +
                            "4- Subtract two polynomials\n" +
                            "5- Multiply two polynomials\n" +
                            "6- Evaluate a polynomial at some point\n" +
                            "7- Clear a polynomial variable\n" +
                            "====================================================================");
                    choice = scanner.next().charAt(0);
                    error = false;
                    switch (choice) {
                        case '1': {
                            System.out.println("Insert the variable name: A, B or C");
                            SLinkedList sLinkedList = new SLinkedList();
                            String string;
                            var1 = scanner.next().charAt(0);
                            if ((var1 == 'A') || (var1 == 'B') || (var1 == 'C')) {
                                System.out.println("Insert the polynomial terms in the form:\n" +
                                        "(coeff1, exponent1), (coeff2, exponent2), ..");
                                scanner.nextLine();
                                string = scanner.nextLine();
                                int b;
                                for (int i=0; i<string.length(); i++) {
                                    char check = string.charAt(i);
                                    if (Character.isDigit(check)) {
                                        b = Integer.parseInt(String.valueOf(string.charAt(i)));
                                        while (Character.isDigit(string.charAt(i)) && Character.isDigit(string.charAt(i+1))) {
                                            b *= 10;
                                            i++;
                                            b += Integer.parseInt(String.valueOf(string.charAt(i)));
                                        }
                                        sLinkedList.add(b);
                                    }else if (check == '-') {
                                        i++;
                                        check = string.charAt(i);
                                        if (Character.isDigit(check)) {
                                            b = -1 * Integer.parseInt(String.valueOf(string.charAt(i)));
                                            while (Character.isDigit(string.charAt(i)) && Character.isDigit(string.charAt(i + 1))) {
                                                b *= 10;
                                                i++;
                                                b -= Integer.parseInt(String.valueOf(string.charAt(i)));
                                            }
                                            sLinkedList.add(b);
                                        }
                                    }
                                }
                                if (sLinkedList.isEmpty()) {
                                    System.out.println("Please enter polynomial terms.");
                                }else {
                                    poly.setPolynomial(var1, sLinkedList.ListToArray(sLinkedList));
                                    System.out.println("Polynomial " + var1 + " is set\n" +
                                            "====================================================================");
                                }
                                break;
                            }else {
                                System.out.println("Please enter valid character.");
                                break;
                            }
                        }
                        case '2': {
                            System.out.println("Insert the variable name: A, B, C or R");
                            var1 = scanner.next().charAt(0);
                            if ((var1 == 'A') || (var1 == 'B') || (var1 == 'C') || (var1 == 'R')) {
                                try {
                                    System.out.println("Value in " + var1 + ": " + poly.print(var1) +
                                            "\n====================================================================");
                                } catch (Exception b) {
                                    System.out.println("You must set the polynomial.");
                                    error = true;
                                }
                            }else {
                                System.out.println("Please enter a valid character.");
                            }
                            break;
                        }
                        case '3': {
                            System.out.println("Insert first operand variable name: A, B or C");
                            var1=scanner.next().charAt(0);
                            if ((var1 == 'A') || (var1 == 'B') || (var1 == 'C')) {
                                System.out.println("Insert second operand variable name: A, B or C");
                                var2=scanner.next().charAt(0);
                                if ((var2 == 'A') || (var2 == 'B') || (var2 == 'C')) {
                                    try {
                                        poly.setPolynomial('R',poly.add(var1, var2));
                                        System.out.println("Result set in R: " + poly.print('R') +
                                                "\n====================================================================");
                                    }catch(Exception e) {
                                        System.out.println("You must set polynomials.");
                                        error = true;
                                    }
                                }else {
                                    System.out.println("Please enter a valid character.");
                                }
                            }else {
                                System.out.println("Please enter a valid character.");
                            }
                            break;
                        }
                        case '4': {
                            System.out.println("Insert first operand variable name: A, B or C");
                            var1=scanner.next().charAt(0);
                            if ((var1 == 'A') || (var1 == 'B') || (var1 == 'C')) {
                                System.out.println("Insert second operand variable name: A, B or C");
                                var2=scanner.next().charAt(0);
                                if ((var2 == 'A') || (var2 == 'B') || (var2 == 'C')) {
                                    try {
                                        poly.setPolynomial('R',poly.subtract(var1, var2));
                                        System.out.println("Result set in R: " + poly.print('R') +
                                                "\n====================================================================");
                                    }catch(Exception e) {
                                        System.out.println("You must set polynomials.");
                                        error = true;
                                    }
                                }else {
                                    System.out.println("Please enter a valid character.");
                                }
                            }else {
                                System.out.println("Please enter a valid character.");
                            }
                            break;
                        }
                        case '5': {
                            System.out.println("Insert first operand variable name: A, B or C");
                            var1=scanner.next().charAt(0);
                            if ((var1 == 'A') || (var1 == 'B') || (var1 == 'C')) {
                                System.out.println("Insert second operand variable name: A, B or C");
                                var2=scanner.next().charAt(0);
                                if ((var2 == 'A') || (var2 == 'B') || (var2 == 'C')) {
                                    try {
                                        poly.setPolynomial('R',poly.multiply(var1, var2));
                                        System.out.println("Result set in R: " + poly.print('R') +
                                                "\n====================================================================");
                                    }catch(Exception e) {
                                        System.out.println("You must set polynomials.");
                                        error = true;
                                    }
                                }else {
                                    System.out.println("Please enter a valid character.");
                                }
                            }else {
                                System.out.println("Please enter a valid character.");
                            }
                            break;
                        }
                        case '6': {
                            System.out.println("Insert the variable name: A, B, C or R");
                            var1=scanner.next().charAt(0);
                            if ((var1 == 'A') || (var1 == 'B') || (var1 == 'C') || (var1 == 'R')) {
                                try {
                                    System.out.println("Enter a point to evaluate a polynomial at");
                                    float x = scanner.nextFloat();
                                    System.out.println("Value of " + var1 + " when x = " + x + " is : " + poly.evaluatePolynomial(var1,x) +
                                            "\n====================================================================");
                                }catch(Exception e) {
                                    System.out.println("You must set polynomial.");
                                    error = true;
                                }
                            }else {
                                System.out.println("Please enter a valid character.");
                            }
                            break;
                        }
                        case '7': {
                            System.out.println("Insert the variable name: A, B, C or R");
                            var1=scanner.next().charAt(0);
                            if ((var1 == 'A') || (var1 == 'B') || (var1 == 'C') || (var1 == 'R')) {
                                try {
                                    poly.clearPolynomial(var1);
                                    System.out.println("Done\n" +
                                            "====================================================================");
                                }catch(Exception e) {
                                    System.out.println("You must set polynomial.");
                                    error = true;
                                }
                            }else {
                                System.out.println("Please enter a valid character.");
                            }
                            break;
                        }
                        default: {
                            System.out.println("Please insert a valid number.");
                        }
                    }
                }while (error);
            }
        }
    }
}