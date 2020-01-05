package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test83_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//餐桌数
            int m = sc.nextInt();//客人批数
            int table[] = new int[n];//每个餐桌人数初始化
            for (int i = 0; i < n; i++) {
                table[i] = sc.nextInt();
            }

            int[][] custom = new int[m][2];
            for (int j = 0; j < m; j++) {
                custom[j][0] = sc.nextInt();//每批客人人数
                custom[j][1] = sc.nextInt();//每批客人支付钱数
            }
            Arrays.sort(table);
            Arrays.sort(custom, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            long res = 0L;
            int index = 0;
            boolean[] tableb = new boolean[n];
            for (int i = 0; i < m; i++) {
                if (custom[i][0] > table[n - 1]) {
                    continue;
                }
                index = bs(table,custom[i][0]);
                while (index<n && tableb[index]==true){
                    index++;
                }
                    if(index<n){
                        res+=custom[i][1];
                        tableb[index]=true;
                    }
                }
                System.out.println(res);
        }
        sc.close();
        }


    private static int bs(int[] num, int tar) {
        int low = 0;
        int high = num.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (num[mid] >= tar) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
            return low;
        }
    }
