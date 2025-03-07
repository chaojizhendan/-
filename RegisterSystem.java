package com.test.StudentManageSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RegisterSystem {
    private static ArrayList<User> userlist = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1登录 2注册 3忘记密码");
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> forgetPassword();
            }
            for (int i = 0; i < userlist.size(); i++) {
                System.out.println(userlist.get(i).getUsername());
                System.out.println(userlist.get(i).getPassword());
                System.out.println(userlist.get(i).getIdentitynumber());
                System.out.println(userlist.get(i).getPhonenumber());
            }
        }
    }

    //判断用户名是否存在
    public static boolean isexist(ArrayList<User> u, String id) {
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getUsername().equals(id)) {
                return true;
            }
        }
        return false;
    }

    //判断用户名组合是否正确(身份证前17位是否为数字)
    public static boolean isexist(String id) {
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);
            if (ch - '0' < 9 && ch - '0' > 0) {
                sum++;
            }
        }
//        System.out.println(sum);
//        System.out.println(id.length());
        return sum == id.length();
    }


    //注册
    public static void register() {
        System.out.println("欢迎使用注册功能");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名(3-15位)");
        User u = new User();
        //用户名
        String name;
        while (true) {
            name = sc.next();
            if (name.length() < 3 || name.length() > 15) {
                System.out.println("用户名长度不合适，请重新输入");
            } else if (isexist(userlist, name)) {
                System.out.println("用户名已存在，请重新输入");
            } else if (isexist(name)) {
                System.out.println("用户名组合错误(需要字母+数字)，请重新输入");
            } else {
                System.out.println("用户名录入成功");
                u.setUsername(name);
                break;
            }
        }
        //密码
        String password1;
        String password2;
        while (true) {
            System.out.println("请输入密码");
            password1 = sc.next();
            System.out.println("请再次输入密码");
            password2 = sc.next();
            if (password1.equals(password2)) {
                System.out.println("密码录入成功");
                u.setPassword(password1);
                break;
            } else {
                System.out.println("两次密码不一致，请重新输入");
            }
        }
        //身份证号码
        System.out.println("请输入身份证号码");
        String id;
        while (true) {
            id = sc.next();
            if (id.length() != 18) {
                System.out.println("身份证号码长度错误，请重新输入");
            } else if (id.charAt(0) == '0') {
                System.out.println("身份证号码开头错误(不能为0)，请重新输入");
            } else if (!isexist(id)) {
                System.out.println("身份证前17位不都为数字，请重新输入");
            } else if (id.charAt(17) != 'x' && id.charAt(17) != 'X' && (id.charAt(17) - '0' > 9 || id.charAt(17) - '0' < 0)) {
                System.out.println("身份证最后一位错误，请重新输入");
            } else {
                System.out.println("身份证录入成功");
                u.setIdentitynumber(id);
                break;
            }
        }
        //电话号码
        String phnum;
        while (true) {
            System.out.println("请输入电话号码");
            phnum = sc.next();
            if (phnum.length() != 11) {
                System.out.println("电话号码长度错误，请重新输入");
            } else if (phnum.charAt(0) == '0') {
                System.out.println("电话号码开头错误(不能为0)，请重新输入");
            } else if (!isexist(phnum)) {
                System.out.println("电话号码不都为数字，请重新输入");
            } else {
                System.out.println("电话号码录入成功");
                u.setPhonenumber(phnum);
                break;
            }
        }
        userlist.add(u);
        System.out.println("注册成功");
    }

    //验证码生成
    public static String getCode() {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder b = new StringBuilder();
        Random r = new Random();
        int j;
        for (int i = 0; i < 4; i++) {
            j = r.nextInt(a.length);
            b.append(a[j]);
        }
        b.append((char) (r.nextInt(10) + '0'));
        char[] result = b.toString().toCharArray();
        //System.out.println(result);
        char temp = ' ';
        for (int i = 0; i < result.length; i++) {
            j = r.nextInt(result.length);
            //System.out.println(j);
            temp = result[j];
            result[j] = result[i];
            result[i] = temp;
            //System.out.println(result);
            if (j == 5) {
                break;
            }
        }
        String s = new String(result);
        //System.out.println(result);
        return s;
    }

    //判断用户名密码是否匹配
    public static boolean ismatch(ArrayList<User> u, String username, String password) {
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getUsername().equals(username) && u.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    //判断用户名与身份证号和手机号是否匹配
    public static boolean ismatch(ArrayList<User> u, String username, String idnumber, String phonenumber) {
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getUsername().equals(username) && u.get(i).getIdentitynumber().equals(idnumber) && u.get(i).getPhonenumber().equals(phonenumber)) {
                return true;
            }
        }
        return false;
    }

    //替换旧密码为新密码
    public static void pwreplace(ArrayList<User> u, String username, String password) {
        for (int i = 0; i < u.size(); i++) {
            if(u.get(i).getUsername().equals(username)){
                u.get(i).setPassword(password);
                System.out.println("密码修改成功");
            }
        }
    }

    //登录
    public static void login() {
        System.out.println("欢迎使用登录功能");
        Scanner sc = new Scanner(System.in);
        //登录验证
        String name;
        String password;
        int i = 0;
        while (true) {
            System.out.println("请输入用户名");
            name = sc.next();
            if (!isexist(userlist, name)) {
                System.out.println("用户名未注册，请先注册");
                return;
            }
            System.out.println("请输入密码");
            password = sc.next();
            i++;
            if (ismatch(userlist, name, password)) {
                System.out.println("登录成功");
                StudentManageSystem s=new StudentManageSystem();
                s.startStudentManageSystem();
                break;
            } else if (i < 3) {
                System.out.println("用户名或密码错误，请重新输入");
                System.out.println("您还有" + (3 - i) + "次机会");
            } else if (i >= 3) {
                System.out.println("您已输入错误超过三次，即将返回主界面");
                return;
            }
        }


        //验证码
        String prove = getCode();
        System.out.println(prove);
        System.out.println("请输入验证码");
        String prove1 = sc.next();
        while (true) {
            if (prove.equalsIgnoreCase(prove1)) {
                break;
            } else {
                System.out.println("验证码不正确请重新输入");
                prove = getCode();
                System.out.println(prove);
                prove1 = sc.next();
            }
        }

    }

    //忘记密码
    public static void forgetPassword() {
        System.out.println("欢迎使用忘记密码功能");
        Scanner sc = new Scanner(System.in);
        String name;
        String idnumber;
        String phonenumber;
        String password;
        while (true) {
            System.out.println("请输入用户名");
            name = sc.next();
            if (!isexist(userlist, name)) {
                System.out.println("用户名未注册，请先注册");
                return;
            }
            System.out.println("请输入身份证号码");
            idnumber = sc.next();
            System.out.println("请输入电话号码");
            phonenumber = sc.next();
            if (ismatch(userlist, name, idnumber, phonenumber)) {
                System.out.println("请输入新密码");
                password = sc.next();
                pwreplace(userlist,name,password);
                return;
            } else {
                System.out.println("账号信息不匹配，修改失败,即将退回主界面");
                return;
            }

        }

    }
}
