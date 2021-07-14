package snorlaxa.com.lab.algorithm.leetcode.notarchived;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @Author: 余子毅
 * @Date: 2021/6/30 17:10
 * 用于执行对应标号的题目，输入题号，如04，就会执行对应的main方法
 */
public class LeetcodeExecutor {
    private static final String LEETCODE_CLASS_PATH = "snorlaxa.com.lab.algorithm.leetcode.notarchived.done";
    private static final String LC_CLASS_NAME_PREX = "Lc";
    private static final String ECHO_PREX = "SYSTEM: ";
    private static final String ECHO_ERR_PREX = "ERROR: ";
    private static final Object[] mainParams = new Object[]{new String[]{}};

    public static void main(String[] args) {
        boolean exit = false;
        int current = 0;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            echo("Input Leetcode No：");
            String next = scanner.next();
            if (next.equals("q") || next.equals("exit")) {
                exit = true;
                continue;
            } else if (next.equals("n") || next.equals("next")) {
                current++;
            } else {
                try {
                    if (next.length() > 1 && next.startsWith("0")) current = Integer.parseInt(next.replaceAll("0", ""));
                    else current = Integer.parseInt(next);
                } catch (Exception e) {
                    echoErr("Can not recognize command: " + next);
                }
            }
            try {
                Class<?> lcClass = Class.forName(LEETCODE_CLASS_PATH + "." + LC_CLASS_NAME_PREX + current);
                Method main = lcClass.getMethod("main", String[].class);
                echoWithNoPrex("========================= Lc" + current + " ===============================");
                echoEmptyLine(1);
                main.invoke(null, mainParams);
                echoEmptyLine(1);
                echoWithNoPrex("==============================================================");
            } catch (ClassNotFoundException e) {
                echoErr("Can not found snorlaxa.com.lab.leetcode.leetcode no." + current);
            } catch (NoSuchMethodException e) {
                echoErr("This class has no main function! ");
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println("exit");
    }

    private static void echo(String content) {
        System.out.println(ECHO_PREX + content);
    }

    private static void echoWithNoPrex(String content) {
        System.out.println(content);
    }

    private static void echoEmptyLine(int n) {
        while (n-- > 0) {
            System.out.println();
        }
    }

    private static void echoErr(String content) {
        System.out.println(ECHO_ERR_PREX + content);
    }
}
