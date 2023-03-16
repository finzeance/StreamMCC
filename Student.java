/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3;

/**
 *
 * @author Indonesia
 */
public class Student {
    private String nama;
    private int semester;
    private boolean status;
    
    public Student(){
    }
    
    public Student(String nama, int semester, boolean status){
        this.nama = nama;
        this.semester = semester;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" + "nama=" + nama + ", semester=" + semester + ", isGraduated=" + status + '}';
    }
    
    
    
}
