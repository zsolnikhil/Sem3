public class MembershipCard {
    static String libraryName;
    static String validUntil;
    String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {
        String[] students = {"Ravi", "Meera", "Karthik", "Divya", "Arjun"};

        for (int i = 0; i < students.length; i++) {
            MembershipCard card = new MembershipCard(students[i]);
            System.out.println("Card issued to " + card.studentName
                    + " | " + MembershipCard.libraryName
                    + " | Valid until " + MembershipCard.validUntil);
        }
    }
}
