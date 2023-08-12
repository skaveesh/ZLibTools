package io.github.skaveesh;

import io.github.skaveesh.util.ZLibUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter ZLib data String [q for quit]:");
            String input = scanner.nextLine();

            if (input != null && input.equals("q")) {
                System.exit(0);
            } else {
                String out = ZLibUtil.decompressWithBase64(input);
                System.out.println("--------------CSV OUTPUT--------------\n");
                String[] outArr = out.split("\n");

                for (int i = 0; i < outArr.length; i++) {
                    if(outArr[i].contains(",")) {
                        System.out.println(outArr[i].substring(0, outArr[i].indexOf(",")) + ": ");
                        System.out.println(outArr[i].substring(outArr[i].indexOf(",") + 1) + "\n");
                    }
                }

                System.out.println("\n-------------END OF OUTPUT------------");
            }
            System.out.println();
        }

    }
}