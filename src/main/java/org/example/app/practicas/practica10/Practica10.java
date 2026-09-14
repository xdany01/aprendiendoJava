package org.example.app.practicas.practica10;

public class Practica10 {
    private final char charPrinted;

    public Practica10() {
        charPrinted = '*';
    }

    public Practica10(char charPrinted) {
        this.charPrinted = charPrinted;
    }

    public void printTriangle() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangle(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleInverse() {
        int rows = 5;
        for (int row = rows; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleInverse(int rows) {
        for (int row = rows; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateral() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateral(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateralInverse() {
        int rows = 5;
        for (int row = rows; row >= 1; row--) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleEquilateralInverse(int rows) {
        for (int row = rows; row >= 1; row--) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleRight() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
        for (int row = rows - 1; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleRight(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
        for (int row = rows - 1; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleLeft() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = rows; col > row; col--) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
        for (int row = rows - 1; row >= 1; row--) {
            for (int col = rows; col > row; col--) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleLeft(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = rows; col > row; col--) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
        for (int row = rows - 1; row >= 1; row--) {
            for (int col = rows; col > row; col--) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printTriangleEmpty() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                if (col == 1 || col == (2 * row - 1) || row == rows) {
                    System.out.print(this.charPrinted);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printTriangleEmpty(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                if (col == 1 || col == (2 * row - 1) || row == rows) {
                    System.out.print(this.charPrinted);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printRectangle() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= rows; col++) {
                if (row == 1 || row == rows || col == 1 || col == rows) {
                    System.out.print(this.charPrinted);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printRectangle(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= rows; col++) {
                if (row == 1 || row == rows || col == 1 || col == rows) {
                    System.out.print(this.charPrinted);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printDiamond() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }

        for (int row = rows - 1; row >= 1; row--) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printDiamond(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }

        for (int row = rows - 1; row >= 1; row--) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2 * row - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }

    public void printCross() {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= rows; col++) {
                if (col == row || col == (rows - row + 1)) {
                    System.out.print(this.charPrinted);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printCross(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= rows; col++) {
                if (col == row || col == (rows - row + 1)) {
                    System.out.print(this.charPrinted);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printHeart() {
        int rows = 6;
        for (int row = (rows / 2); row <= rows; row += 2) {

            for (int col = 1; col < (rows - row); col += 2) {
                System.out.print(" ");
            }

            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }

            for (int col = 1; col <= (rows - row); col++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= row; col++) {
                System.out.print(this.charPrinted);
            }

            System.out.println();
        }

        for (int row = rows; row >= 1; row--) {
            for (int col = row; col < rows; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= ((row * 2) - 1); col++) {
                System.out.print(this.charPrinted);
            }
            System.out.println();
        }
    }
}
