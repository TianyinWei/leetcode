// Given a sorted array of strings interspersed with empty strings, write a method to find the location of a given string


import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        String[] strs = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String str = "ball";
        System.out.println(searchStrArr(strs, str, 0, strs.length - 1));
        // System.out.println("a".compareTo("b"));
    }

    public static int searchStrArr(String[] strArr, String str, int low, int hi) {
        int mid = (low + hi) / 2;
        int len = strArr.length - 1;
        int left = 0, right = 0;
        boolean reset = true;
        while (left >= 0 && right <= len) {
            //if (strArr[mid].equals(str))    return mid;
            if (reset) {
                left = mid - 1;
                right = mid + 1;
            }
            if (strArr[mid].isEmpty() && !strArr[right].isEmpty()) {
                mid = right;
                reset = false;
                System.out.println("mid = right");
                continue;
            }
            if (strArr[mid].isEmpty() && !strArr[left].isEmpty()) {
                mid = left;
                reset = false;
                System.out.println("mid = left");
                continue;
            }
            if (!strArr[mid].isEmpty()) {
                if (strArr[mid].compareTo(str) < 0) low = mid + 1;  //search right
                if (strArr[mid].compareTo(str) > 0) hi = mid - 1;
                if (strArr[mid].compareTo(str) == 0) return mid;

                mid = (low + hi) / 2;
                reset = true;
                System.out.println("adjust left and right");
                continue;
            }
            // if (strArr[mid].isEmpty() && strArr[left].isEmpty() && strArr[right].isEmpty()) {
                left--;
                right++;
                reset = false;
                System.out.println("both neighbors are empty");
            // }
        }

        return -1;
    }
}
