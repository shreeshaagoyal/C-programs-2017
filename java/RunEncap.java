public class RunEncap {
    public static void main(String[] args) {
        EncapTest encap = new EncapTest();
        encap.setName("Shreeshaa Goyal");
        encap.setIdNum("7387389");
        encap.setAge(18);

        System.out.println("Name: " + encap.getName() + "\nID #: " + encap.getIdNum() + "\nAge: " + encap.getAge());
    }
}