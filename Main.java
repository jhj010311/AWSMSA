import java.util.*;
import java.time.*;
import java.io.*;

public class Main {
    public static boolean mainPage(boolean end, Scanner scanner) {
        System.out.println("ToDoList 프로그램 메인페이지입니다");
        System.out.println("사용하실 기능을 선택해주세요");
        System.out.println("1. ToDoList 작성하기    2. ToDoList 열람하기    3. ToDoList 삭제하기");
        System.out.println("0. 프로그램 종료하기");

        int select = scanner.nextInt();

        switch (select) {
            case 1:
                end = makingList(scanner);
                break;
            case 2:
                
                break;
            case 3:
                break;
            case 0:
                break;
            default:
                break;
        }
        
        return end;
    }

    public static boolean makingList(Scanner scanner) {
        String input = new String();
        StringBuilder text = new StringBuilder();

        

        System.out.println("\n\n당신의 ToDoList를 작성해봅시다");

        
        System.out.println("목표를 한 줄씩 적어주세요");
        System.out.println("**그만하시려면 END를 적어주세요**");

        while(!input.equals("END")){
            if(text.length() == 0){
                text.append(input);
            } else {
                text.append("\n" + input);
            }

            input = scanner.nextLine();
        }
        
        System.out.println("이상의 내용을 파일로 저장할까요? 저장하길 바라신다면 YES를 적어주세요");
        input = scanner.nextLine();

        if(input.equals("YES")){
            LocalDateTime current = LocalDateTime.now();
            String fileCurrent = current.toString().replaceAll(":", "");
            fileCurrent = fileCurrent.substring(0, fileCurrent.indexOf("."));
            String filePath = "ToDoList_" + fileCurrent + ".txt";

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
                writer.write(text.toString());
                System.out.println("ToDoList 파일이 생성되었습니다!");
            } catch(IOException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }

        System.out.println("프로그램 메인으로 돌아가시겠습니까?");
        System.out.println("1. 돌아간다     (그 외). 프로그램을 종료한다");

        int select = scanner.nextInt();

        if(select == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean end = false;

        while (!end) {
            end = mainPage(end, scanner);
        }

        System.out.println("\n\n프로그램을 종료합니다");
        
        scanner.close();

    }
}