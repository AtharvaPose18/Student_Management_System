import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
class Student{
    int rollNo;
    String name;
    double marks;
    Student(int rollNo,String name,double marks){
        this.rollNo=rollNo;
        this.name=name;
        this.marks=marks;
    }
    void display(){
        System.out.println("Roll No:"+rollNo+",Name:"+name+",Marks:"+marks);
    }
}
public class StudentManagementSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students=new ArrayList<>();
        int choice=0;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Search Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Update Marks");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            try {
                choice=sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        System.out.print("Enter roll number:");
                        int roll=sc.nextInt();
                        sc.nextLine();
                        boolean exists=false;
                        for (Student s:students) {
                            if (s.rollNo==roll) {
                                exists=true;
                                break;
                            }
                        }
                        if(exists){
                            System.out.println("Roll number already exists!");
                            break;
                        }
                        System.out.print("Enter student name:");
                        String name=sc.nextLine();
                        if(name.trim().isEmpty()){
                            System.out.println("Name cannot be empty!");
                            break;
                        }
                        System.out.print("Enter marks:");
                        double marks=sc.nextDouble();
                        sc.nextLine();
                        if (roll<=0 || marks<0 || marks>100){
                            System.out.println("Invalid roll number or marks!");
                            break;
                        }
                        students.add(new Student(roll,name,marks));
                        System.out.println("Student added successfully!");
                        break;
                    case 2:
                        if(students.isEmpty()) {
                            System.out.println("No students available.");
                        } 
                        else{
                            for(Student s:students){
                                s.display();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Enter roll number to search:");
                        int searchRoll=sc.nextInt();
                        sc.nextLine();
                        boolean found=false;
                        for (Student s:students) {
                            if(s.rollNo==searchRoll) {
                                s.display();
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter roll number to delete:");
                        int deleteRoll=sc.nextInt();
                        sc.nextLine();
                        boolean removed=false;
                        for (int i=0;i<students.size();i++){
                            if(students.get(i).rollNo==deleteRoll){
                                students.remove(i);
                                removed=true;
                                System.out.println("Student deleted successfully!");
                                break;
                            }
                        }
                        if(!removed){
                            System.out.println("Student not found.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter roll number:");
                        int updateRoll=sc.nextInt();
                        sc.nextLine();
                        boolean updated=false;
                        for (Student s:students){
                            if(s.rollNo== updateRoll){
                                System.out.print("Enter new marks:");
                                double newMarks=sc.nextDouble();
                                sc.nextLine();
                                if(newMarks>=0 && newMarks<=100) {
                                    s.marks=newMarks;
                                    System.out.println("Student marks updated successfully!");
                                } 
                                else{
                                    System.out.println("Invalid marks! Enter marks between 0 and 100.");
                                }
                                updated=true;
                                break;
                            }
                        }
                        if(!updated){
                            System.out.println("Student not found.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting Student Management System...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter the correct data type.");
                sc.nextLine();
                choice=0;
            }
        } while(choice!=6);
        sc.close();
    }
}
