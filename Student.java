public class Student extends Persoon {

    private String studentnummer;
    private String studierichting;

    public Student() {
        super();
        studentnummer = "Onbekend";
        studierichting = "Onbekend";
        type = "Student";
    }

    public String getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(String studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }
}
