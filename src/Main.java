public class Main {
    public static void main(String[] args) {
        Btree btree = new Btree();
        for (int i = 1; i < 100 ; i++) {
            btree.insert(i);
        }

        System.out.println(btree.search(5));
        btree.print();
    }

}
