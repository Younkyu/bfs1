package com.company;
// 미로찾기 BFS

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> box = new ArrayList<>();
    public static int count = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //총 몇개의 숫자를 입력 받을 것인지
        int a;
        int b;
        int c[][];

        a = sc.nextInt();
        b = sc.nextInt();

        c = new int[a + 1][b + 1];

        int input = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                input = sc.nextInt();
                if (input == 1) c[i][j] = -1;
                else c[i][j] = input;
            }
        }

        sc.close();

        findGoalBFS(c, a, 1);

        System.out.println(c[1][b]);


    }

    public static void findGoalBFS(int[][] c, int a, int b) {
        Queue<int[]> q = new LinkedList<>();

        c[a][b] = 0;
        int[] data;
        data = new int[]{a, b, 0};
        q.offer(data);

        while (!q.isEmpty()) {

            data = q.poll();

            int[][] dataS = new int[4][3];
            dataS[0] = new int[]{data[0] - 1, data[1], data[2] + 1};
            dataS[1] = new int[]{data[0], data[1] + 1, data[2] + 1};
            dataS[2] = new int[]{data[0], data[1] - 1, data[2] + 1};
            dataS[3] = new int[]{data[0] + 1, data[1], data[2] + 1};

            for (int i = 0; i < 4; i++) {

                int[] da = dataS[i];

                if (da[0] <= 0 || da[0] >= c.length || da[1] >= c[0].length || da[1] <= 0 || c[da[0]][da[1]] == -1) ;
                else if (c[da[0]][da[1]] == 0 || c[da[0]][da[1]] > da[2]) {
                    c[da[0]][da[1]] = da[2];
                    q.offer(da);
                }
            }


        }


    }


    public static void findGoalDFS(int[][] c, int a, int b, int length) {

        if (a <= 0 || b <= 0 || a >= c.length || b >= c[0].length || c[a][b] == -1) return;

        if (a == 1 && b == c[0].length - 1) {
            if (c[a][b] == 0 || length < c[a][b]) c[a][b] = length;
            return;
        }

        if (c[a][b] == 0 || c[a][b] > length) c[a][b] = length;
        else return;

        findGoalDFS(c, a - 1, b, length + 1);
        findGoalDFS(c, a, b + 1, length + 1);
        findGoalDFS(c, a + 1, b, length + 1);
        findGoalDFS(c, a, b - 1, length + 1);

    }

}










