package lab1;

public class TestLab1 {
    public static void main(String[] args) {
        Player p1 = new Player("Michael Quick", "defence", 99);
        System.out.println(p1.getName());
        System.out.println(p1.getPosition());
        System.out.println(p1.getJerseyNum());

        p1.setJerseyNum(77);
        p1.setPosition("forward");

        System.out.println(p1.getName());
        System.out.println(p1.getPosition());
        System.out.println(p1.getJerseyNum());

        System.out.println(p1);
    }
}
