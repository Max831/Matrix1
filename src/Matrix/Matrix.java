package Matrix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;



    public class Matrix {
        private Integer a = 0, b = 0;
        private Integer[][] d;
        Matrix(){}
        /*Matrix(Integer a1, Integer b1) {
            a=a1;
            b=b1;
         }*/
        private void size(Integer rows, Integer columns) {
            d = new Integer[rows][columns];
        }


        public static void main(String[] args) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Matrix matrix1 = new Matrix();
                matrix1.d = create(br, matrix1);
                Matrix matrix2 = new Matrix();
                matrix2.d = create(br, matrix2);
                //System.out.println(matrix1.d.length); количество строк
                //System.out.println(matrix1.d[0].length);количество столбцов
                transport(matrix1);
                transport(matrix2);
                Matrix matrix3 = new Matrix();
                matrix3.d = plus(matrix1, matrix2);
            } catch (Exception e) {
                e.getMessage();
            }

        }

        public static Integer[][] create(BufferedReader cd, Matrix m) {
            System.out.print("Введите размерность матрицы но не более 4х4\n");
            try {

                Random random = new Random();
                System.out.print("Количество столбцов \n");
                m.a = Integer.parseInt(cd.readLine());
                System.out.print("Количество строк \n");
                m.b = Integer.parseInt(cd.readLine());
                m.size(m.b, m.a);
                for (int i = 0; i < m.b; i++) {
                    for (int j = 0; j < m.a; j++) {
                        m.d[i][j] = random.nextInt(10);
                        System.out.print(m.d[i][j] + " ");
                    }
                    System.out.print("\n");
                }
                return m.d;
            } catch (Exception e) {
                e.getMessage();
            }
            return null;
        }

        public static Integer[][] transport(Matrix m) {
            Integer[][] a = new Integer[m.d[0].length][m.d.length];
            for (int i = 0; i < m.d.length; i++) {//количество строк
                for (int j = 0; j < m.d[0].length; j++) {//количество столбцов
                    a[j][i] = m.d[i][j];
                }
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();

            }
            return m.d;
        }

        public static Integer[][] plus(Matrix m, Matrix n) {
            if ((m.d.length == n.d.length) && (m.d[0].length == n.d[0].length)) {
                Integer[][] a = new Integer[m.d.length][m.d[0].length];
                for (int i = 0; i < m.d.length; i++) {
                    for (int j = 0; j < m.d[0].length; j++) {
                        a[i][j] = m.d[i][j] + n.d[i][j];
                    }
                }
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println();

                }
                return a;
            } else {
                System.out.println("Невозможно сложить матрицы");
                return null;
            }

        }

    }



}
