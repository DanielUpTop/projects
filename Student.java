package patcode;

///Task 2. Create a class named student. With the private attributes.
class Student {
    private int id;
    private String firstName;
    private String surname;
    private double[] hwMarks;
    private double interimMark;
    private double courseworkMark;
    private double examMark;
    private double finalMark;
    
    public Student(int id, String firstName, String surname, double[] hwMarks, double interimMark, double examMark) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.hwMarks = hwMarks;
        this.interimMark = interimMark;
        this.examMark = examMark;
        this.courseworkMark = calculateCourseworkMark();
        this.finalMark = calculateFinalMark();
    }
    
    public int getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public double getExamMark() {
        return examMark;
    }
    
    public double calculateCourseworkMark() {
        double sum = 0;
        for (double mark : hwMarks) {
            sum += mark;
        }
        sum += interimMark;
        double minHwMark = hwMarks[0];
        for (int i = 1; i < hwMarks.length; i++) {
            if (hwMarks[i] < minHwMark) {
                minHwMark = hwMarks[i];
            }
        }
        sum -= minHwMark;
        return sum / 4;
    }
    
    public double calculateFinalMark() {
        return (courseworkMark * 0.4) + (examMark * 0.6);
    }
}