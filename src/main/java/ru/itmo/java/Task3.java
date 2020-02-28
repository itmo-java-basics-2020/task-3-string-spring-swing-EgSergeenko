package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray)
    {
        if (inputArray == null)
        {
            return new int[0];
        }
        else if (inputArray.length == 0 )
        {
            return inputArray;
        }
        else {
            int tmp = inputArray[inputArray.length - 1];
            for (int i = inputArray.length - 1; i > 0; i = i - 1) {
                inputArray[i] = inputArray[i - 1];
            }
            inputArray[0] = tmp;
            return inputArray;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray)
    {
        if (inputArray == null)
        {
            return 0;
        }
        else if (inputArray.length == 0 || inputArray.length == 1)
        {
            return 0;
        }
        else
        {
            int max1 = Math.max(inputArray[1], inputArray[0]);
            int max2 = Math.min(inputArray[0], inputArray[1]);
            for (int i = 2; i < inputArray.length; i++)
            {
                if (inputArray[i] >= max1)
                {
                    max2 = max1;
                    max1 = inputArray[i];
                }
                if (inputArray[i] > max2 && inputArray[i] < max1)
                {
                    max2 = inputArray[i];
                }
            }
            return max1 * max2;
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input)
    {
        if (input == null || input.equals(""))
        {
            return 0;
        }
        char[] arr = input.toCharArray();
        double c = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 'a' || arr[i] == 'b'|| arr[i] == 'B' || arr[i] == 'A')
            {
                c++;
            }
        }
        return (int) Math.floor((c / arr.length) * 100);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null || input.equals(""))
        {
            return  false;
        }
        return input.equals(new StringBuffer(input).reverse().toString());
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        char[] arr = input.toCharArray();
        int c = 1;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] != arr[i - 1])
            {
                res.append(arr[i - 1]);
                res.append(c);
                c = 1;
            }
            else
            {
                c++;
            }
        }
        res.append(arr[arr.length - 1]);
        res.append(c);
        return res.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two)
    {
        if (one == null || two == null || one.length() == 0)
        {
            return false;
        }
        char[] arr1 = one.toCharArray();
        char[] arr2 = two.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        one = new String(arr1);
        two = new String(arr2);
        return one.equals(two);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s)
    {
        if (s == null || s.length() == 0)
        {
            return false;
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] == arr[i - 1])
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m)
    {
        if (m == null)
        {
            return new int[0][0];
        }
        else if (m.length == 0)
        {
            return m;
        }
        else
        {

            for (int i = 0; i < m.length; i++) {
                for (int j = i+1; j < m.length; j++) {
                    int temp = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = temp;
                }
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator)
    {
        if (separator == null)
        {
            separator = ' ';
        }
        if (inputStrings == null || inputStrings.length == 0)
        {
            return "";
        }
        String res = "";
        for (int i = 0; i < inputStrings.length; i++)
        {
            res = res + inputStrings[i] + separator.toString();
        }
        return res.substring(0, res.length() - 1);
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix)
    {
        if (inputStrings == null || inputStrings.length == 0 || prefix == null)
        {
            return 0;
        }
        int c = 0;
        for (int i = 0; i < inputStrings.length; i++)
        {
            if (inputStrings[i].startsWith(prefix))
            {
                c++;
            }
        }
        return c;
    }
}
