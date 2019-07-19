import java.util.*;
import java.io.*;


public class ReadWrite {
    public static void main(String[] args) throws Exception {
        LinkedList <String> groups, students;
        String file_name = "full_list", files_path="/home/random/Projects/java_4_lab06/assets/", line, group, name;
        StringTokenizer tokenizer;
        Scanner sc;
        PrintWriter pw;
        long startTime, endTime;

        System.out.println("\"quick\" sort start");
        startTime = System.nanoTime();
        sc = new Scanner(new File(files_path+file_name+".txt"));
        groups = new LinkedList<>();
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line);
            tokenizer = new StringTokenizer(line);
            name = tokenizer.nextToken();
            group = tokenizer.nextToken();
            if(!groups.contains(group)) {
                groups.add(group);
                pw = new PrintWriter(new FileWriter(files_path+group+".txt"));
                pw.println(name);
                pw.close();
            }
            else {
                pw = new PrintWriter(new FileWriter(files_path + group + ".txt", true));
                pw.println(name);
                pw.close();
            }
        }
        endTime = System.nanoTime();
        System.out.println("\"quick\" sort end and it took "+ ((endTime - startTime)/1000000) + " miliseconds");

        System.out.println("alphabet sort start");
        startTime = System.nanoTime();

        for(String grp: groups) {
            System.out.println(grp+": ");
            students = new LinkedList<>();
            sc = new Scanner(new File(files_path+grp+".txt"));
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                students.add(line);
            }
            Collections.sort(students);
            pw = new PrintWriter(new FileWriter(files_path + grp + ".txt"));
            for (String student : students) {
                pw.println(student);
            }
            pw.close();
        }
        endTime = System.nanoTime();
        System.out.println("alphabet sort end and it took "+ ((endTime - startTime)/1000000) + " miliseconds");

    }
}
