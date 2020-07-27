package java2.lesson2;



public class Main {

    static class MySizeArrayException extends Exception {
        MySizeArrayException(String msg) {
            super(msg);
        }
    }

    static class MyArraDataException extends Exception {      // вопрос насколько ошибка что всё в итоге пришлось сделать static ?(без этого не получалось запустить метод в мейне)
        MyArraDataException(String msg) {
            super(msg);

        }
    }


    static class MyArraySize {
        static int getArray(String[][] myArray) throws MyArraDataException, MySizeArrayException {

            if (myArray.length == 4 && myArray[0].length == 4) {
                System.out.println("Array's length is correct");
            } else {
                throw new MySizeArrayException("Array's length is not correct");
            }


            int sum = 0;
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i].length != 4) {
                    throw new MySizeArrayException("Array's length is not correct");
                }
                for (int j = 0; j < myArray[i].length; j++) {
                    try {
                        sum += Integer.parseInt(myArray[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArraDataException("Unabale to convert " + myArray[i][j]);
                    }
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {

        String[][] array = new String[4][4];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "q" + j;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


            try {
                int sum = MyArraySize.getArray(array);
                System.out.println(sum);
            } catch (MySizeArrayException | MyArraDataException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Конец программы ");



    }

}
