/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Indonesia
 */
public class StreamStudent {

    static ArrayList<Student> getData() {
        //DATA ARRAY STUDENT
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Mirza Muhammad Zidane", 8, false),
                new Student("Alfin Zidane Rahman", 6, false),
                new Student("Muh Syafiq Hidayatullah", 8, true),
                new Student("Meylawati Marfu'atin", 7, true),
                new Student("Thalia Anggita Marcela", 7, true),
                new Student("Dwi Fatimah Kasri", 4, false),
                new Student("Tasya Rosa Anggrek", 9, false)
        ));
        return students;
    }

    //METHOD UNTUK MENJALANKAN KONSOL MENU
    static void run(ArrayList<Student> students) {
        boolean menu = true;
        String name;
        while (menu) {
            System.out.println(" ");
            System.out.println("==================KONSOL MENU SERBAGUNA DATA MAHASISWA==================");
            System.out.println("Menu:");
            System.out.println("1. - Tunjukkan data Mahasiswa");
            System.out.println("2. - Input data Mahasiswa");
            System.out.println("3. - Update data Mahasiswa");
            System.out.println("4. - Hapus data Mahasiswa");
            System.out.println("5. - Cari data Mahasiswa");
            System.out.println("6. - Keluar");
            System.out.println("  ");

            Scanner scan = new Scanner(System.in);
            System.out.print("Pilih menu yang hendak dituju: ");
            int pilihan = scan.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Data Mahasiswa:");
                    System.out.println("========================================================================================================================");
                    System.out.println("NAMA MAHASISWA \t\t\t|\t\t   SEMESTER \t\t|\t      STATUS KELULUSAN");
                    students.forEach((student) -> {
                        System.out.println(student.getNama() + "\t\t|\t\t\t" + student.getSemester() + "\t\t|\t\t" + (student.isStatus() == true ? "Lulus" : "Belum lulus"));
                    });
                    System.out.println("========================================================================================================================");
                    break;
                case 2:
                    System.out.println("Tuliskan data mahasiswa yang hendak diinput");

                    Scanner scan2 = new Scanner(System.in);
                    System.out.print("Nama Mahasiswa: ");
                    String inputName = scan2.nextLine();

                    Scanner scan3 = new Scanner(System.in);
                    System.out.print("Semester: ");
                    int inputSmt = scan3.nextInt();

                    Scanner scan4 = new Scanner(System.in);
                    System.out.print("Status mahasiswa \n1. Lulus\n2. Belum Lulus \nMasukkan kode: ");
                    int inputGraduateCode = scan4.nextInt();

                    boolean inputGraduate = false;
                    switch (inputGraduateCode) {
                        case 1:
                            inputGraduate = true;
                            break;
                        case 2:
                            inputGraduate = false;
                            break;
                        default:
                            System.out.println("Kode yang dimasukkan tidak valid.");
                            break;
                    }

                    Student input = new Student(inputName, inputSmt, inputGraduate);
                    students.add(input);
                    System.out.println("*********Data sukses dimasukkan*********");

                    break;

                case 3: //UPDATE DATA
                    System.out.println("Tuliskan data mahasiswa yang hendak diupdate");

                    Scanner scan5 = new Scanner(System.in);
                    System.out.print("Nama Mahasiswa: ");
                    String updateName = scan5.nextLine();

                    Student studentToUpdate = null;
                    for (Student student : students) {
                        if (student.getNama().equals(updateName)) {
                            studentToUpdate = student;
                            break;
                        }

                    }

                    if (studentToUpdate == null) {
                        System.out.println("Mahasiswa dengan nama " + updateName + "tidak ditemukan.");
                        break;
                    }

                    Scanner scan6 = new Scanner(System.in);
                    System.out.print("Semester: ");
                    int updateSmt = scan6.nextInt();
                    studentToUpdate.setSemester(updateSmt);

                    System.out.println("Status Kelulusan: \n1. Lulus\n2. Belum Lulus");
                    Scanner scan7 = new Scanner(System.in);
                    System.out.print("Masukkan status saat ini: ");
                    boolean updateGraduate = scan7.nextInt() == 1;
                    studentToUpdate.setStatus(updateGraduate);

                    System.out.println("======================================================================================");
                    System.out.println("Data Mahasiswa berhasil diupdate.");
                    break;

                case 4:
                    System.out.println("Tuliskan data mahasiswa yang hendak dihapus");

                    Scanner scan8 = new Scanner(System.in);
                    System.out.print("Nama Mahasiswa: ");
                    String deleteName = scan8.nextLine();

                    Student studentToDelete = null;
                    for (Student student : students) {
                        if (student.getNama().equals(deleteName)) {
                            studentToDelete = student;
                            break;
                        }

                    }

                    if (studentToDelete == null) {
                        System.out.println("======================================================================================");
                        System.out.println("Mahasiswa dengan nama " + deleteName + "tidak ditemukan.");
                        break;
                    } else {
                        students.remove(studentToDelete);
                        System.out.println("======================================================================================");
                        System.out.println("Data mahasiswa dengan nama " + deleteName + " berhasil dihapus.");
                    }

                    break;

                case 5://SEARCH
                    System.out.print("Kategori apa yang ingin digunakan untuk mencari? \n1. - Nama Mahasiswa \n2. - Semester \n3. - Status Kelulusan \nMasukkan kategori sesuai kode: ");
                    Scanner scan9 = new Scanner(System.in);
                    String keyword = scan9.nextLine();
                    Scanner scan10 = new Scanner(System.in);
                    int kategoriCode = scan10.nextInt();
                    

                    switch (kategoriCode) {
                        case 1:
                            System.out.println("=========================CARI DAN SORTIR MENGGUNAKAN NAMA MAHASISWA=========================");
                            Scanner scan11 = new Scanner(System.in);
                            System.out.print("Masukkan kata kunci: ");
                            String keyword1 = scan11.nextLine();

                            List<Student> searchResults = students.stream()
                                    .filter(n -> n.getNama().contains(keyword1))
                                    .collect(Collectors.toList());

                            if (searchResults.isEmpty()) {
                                System.out.println("Tidak ditemukan mahasiswa dengan kata kunci " + keyword1);
                            } else {
                                System.out.println("Berikut hasil pencarian: ");
                                System.out.println("======================================================================================");
                                System.out.println("Nama Mahasiswa \t\t\t Semester \t\t\t Status Mahasiswa");
                                searchResults.forEach((result) -> {
                                    System.out.println(result.getNama() + "\t\t    " + result.getSemester() + "\t\t\t\t" + (result.isStatus() ? "    lulus" : "    belum lulus"));

                                });
                                System.out.println("======================================================================================");
                            }
                            break;

                        case 2:
                            System.out.println("=========================CARI DAN SORTIR MENGGUNAKAN SEMESTER=========================");
                            Scanner scan12 = new Scanner(System.in);
                            System.out.print("Masukkan kata kunci: ");
                            int keyword2 = scan12.nextInt();

                            List<Student> searchResults2 = students.stream()
                                    .filter(s -> s.getSemester() == (keyword2))
                                    .collect(Collectors.toList());

                            if (searchResults2.isEmpty()) {
                                System.out.println("Tidak ditemukan mahasiswa dengan kata kunci " + keyword2);
                            } else {
                                System.out.println("Berikut hasil pencarian: ");
                                System.out.println("======================================================================================");
                                System.out.println("Nama Mahasiswa \t\t\t Semester \t\t\t Status Mahasiswa");
                                searchResults2.forEach((result2) -> {
                                    System.out.println(result2.getNama() + "\t\t    " + result2.getSemester() + "\t\t\t\t" + (result2.isStatus() ? "    lulus" : "    belum lulus"));

                                });
                                System.out.println("======================================================================================");
                            }
                            break;

                        case 3:
                            System.out.println("=========================CARI DAN SORTIR MENGGUNAKAN STATUS KELULUSAN=========================");
                            boolean menuFilterStatus = true;
                            while (menuFilterStatus) {
                                Scanner scan13 = new Scanner(System.in);
                                System.out.print("Apa status yang dicari? \n1.Lulus \n2. belum lulus \nMasukkan kode: ");
                                int inputGraduateCode2 = scan13.nextInt();
                                boolean inputGraduate2;

                                switch (inputGraduateCode2) {
                                    case 1:
                                        inputGraduate2 = true;
                                        List<Student> searchResults3 = students.stream()
                                                .filter(s -> s.isStatus() == inputGraduate2)
                                                .collect(Collectors.toList());

                                        if (searchResults3.isEmpty()) {
                                            System.out.println("Tidak ditemukan mahasiswa dengan kata kunci " + inputGraduateCode2);
                                        } else {
                                            System.out.println("Berikut hasil pencarian: ");
                                            System.out.println("======================================================================================");
                                            System.out.println("Nama Mahasiswa \t\t\t Semester \t\t\t Status Mahasiswa");
                                            searchResults3.forEach((result3) -> {
                                                System.out.println(result3.getNama() + "\t\t    " + result3.getSemester() + "\t\t\t\t" + (result3.isStatus() ? "    lulus" : "    belum lulus"));

                                            });
                                            System.out.println("======================================================================================");
                                        }
                                        menuFilterStatus = false;
                                        break;
                                    case 2:
                                        inputGraduate2 = false;
                                        List<Student> searchResults4 = students.stream()
                                                .filter(s -> s.isStatus() == inputGraduate2)
                                                .collect(Collectors.toList());

                                        if (searchResults4.isEmpty()) {
                                            System.out.println("Tidak ditemukan mahasiswa dengan kata kunci " + inputGraduateCode2);
                                        } else {
                                            System.out.println("Berikut hasil pencarian: ");
                                            System.out.println("======================================================================================");
                                            System.out.println("Nama Mahasiswa \t\t\t Semester \t\t\t Status Mahasiswa");
                                            searchResults4.forEach((result4) -> {
                                                System.out.println(result4.getNama() + "\t\t    " + result4.getSemester() + "\t\t\t\t" + (result4.isStatus() ? "    lulus" : "    belum lulus"));

                                            });
                                            System.out.println("======================================================================================");
                                        }
                                        menuFilterStatus = false;
                                        break;

                                    default:
                                        System.out.println("Kode yang dimasukkan tidak valid.");
                                        break;

                                }
                            }

                            break;

                        case 6:

                            menu = false;
                            System.out.println("**************TERIMA KASIH TELAH MENGGUNAKAN LAYANAN KONSOL KAMI**************");

                            break;

                        default:
                            System.out.println("===========================");
                            System.out.println("Menu tidak ditemukan!");
                            System.out.println("===========================");

                    }
            }

        }
    
    }
    

    

    public static void main(String[] args) {

        run(getData());
    }

}
