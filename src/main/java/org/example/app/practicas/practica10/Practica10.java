package org.example.app.practicas.practica10;

public class Practica10 {
    final char CHAR_PRINTED = '*';

    public void printTriangle() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleInverse() {
        int rows = 5;
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleInverse(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateral() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateral(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateralInverse() {
        int rows = 5;
        for (int i = rows; i >= 1; i--) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateralInverse(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleRight() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleRight(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleLeft() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleLeft(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printTriangleEmpty() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == rows) {
                    System.out.print(CHAR_PRINTED);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printTriangleEmpty(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == rows) {
                    System.out.print(CHAR_PRINTED);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printRectangle() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (i == 1 || i == rows || j == 1 || j == rows) {
                    System.out.print(CHAR_PRINTED);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printRectangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (i == 1 || i == rows || j == 1 || j == rows) {
                    System.out.print(CHAR_PRINTED);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printDiamond() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }

        for (int i = rows - 1; i >= 1; i--) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printDiamond(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }

        for (int i = rows - 1; i >= 1; i--) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }

    public void printCross() {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (j == i || j == (rows - i + 1)) {
                    System.out.print(CHAR_PRINTED);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printCross(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (j == i || j == (rows - i + 1)) {
                    System.out.print(CHAR_PRINTED);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printHeart() {
        int rows = 6;
        for (int i = (rows / 2); i <= rows; i += 2) {

            for (int j = 1; j < (rows - i); j += 2) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }

            for (int j = 1; j <= (rows - i); j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(CHAR_PRINTED);
            }

            System.out.println();
        }

        for (int i = rows; i >= 1; i--) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i * 2) - 1); j++) {
                System.out.print(CHAR_PRINTED);
            }
            System.out.println();
        }
    }
}
