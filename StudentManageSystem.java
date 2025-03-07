package com.test.StudentManageSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManageSystem {
    private static ArrayList<Student> list = new ArrayList<>();

    public static void startStudentManageSystem() {
        loop:while (true) {
            System.out.println("-------------欢迎来到黑马学生管理系统----------------");
            System.out.println("                  1.添加学生");
            System.out.println("                  2.删除学生");
            System.out.println("                  3.修改学生");
            System.out.println("                  4.查询学生");
            System.out.println("                  5.退出");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("添加学生");
                    while (true) {
                        boolean bl = addStudent(list);
                        if (bl) {
                            System.out.println("添加成功");
                            break;
                        } else {
                            System.out.println("学生学号重复，添加失败,请重新添加");
                        }
                    }
                    break;
                case 2:
                    System.out.println("删除学生");
                    boolean bl = deleteStudent(list);
                    if (bl) {
                        System.out.println("删除成功");
                        break;
                    } else {
                        System.out.println("学生学号不存在，删除失败");
                    }
                    break;
                case 3:
                    System.out.println("修改学生");
                    boolean b3 = modifyStudent(list);
                    if (b3) {
                        System.out.println("修改成功");
                        break;
                    } else {
                        System.out.println("学生学号不存在，修改失败");
                    }
                    break;
                case 4:
                    System.out.println("即将打印所有学生信息");
                    System.out.println("id\t\t姓名\t年龄\t居住地");
                    printStudent(list);
                    break;
                case 5:
                    System.out.println("退出");
                    System.exit(0);//退出虚拟机
                    //break loop; 第二种推出主程序循环的方式
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i).getId());
//                System.out.println(list.get(i).getName());
//                System.out.println(list.get(i).getAge());
//                System.out.println(list.get(i).getAddress());
//            }
        }

    }

    public static boolean addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return false;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生居住地：");
        String gender = sc.next();
        Student s = new Student(id, name, age, gender);
        list.add(s);
        return true;
    }

    public static boolean deleteStudent(ArrayList<Student> list) {
        System.out.println("请输入要删除的学生学号：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                int index = list.indexOf(list.get(i));
                list.remove(index);
                return true;
            }
        }
        return false;
    }

    public static boolean modifyStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生学号：");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                int index = list.indexOf(list.get(i));
                System.out.println("请输入学生姓名：");
                String name = sc.next();
                System.out.println("请输入学生年龄：");
                int age = sc.nextInt();
                System.out.println("请输入学生居住地：");
                String gender = sc.next();
                Student s = new Student(id, name, age, gender);
                list.set(index, s);
                return true;
            }
        }
        return false;
    }

    public static void printStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加再查询");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i).getId());
//            System.out.print("       ");
//            System.out.print(list.get(i).getName());
//            System.out.print("       ");
//            System.out.print(list.get(i).getAge());
//            System.out.print("       ");
//            System.out.println(list.get(i).getAddress());
            System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getAge()+"\t"+list.get(i).getAddress());
        }
        return;
    }
}
