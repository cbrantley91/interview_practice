public class SwapThreeVars {
    public static void main(String[] args) {
        ThreeAmigos swapSet = new ThreeAmigos(1, 2, 3);
        swapThree(swapSet);

        assert swapSet.b == 1;
        assert swapSet.c == 2;
        assert swapSet.a == 3;
    }
    
    public static class ThreeAmigos {
        int a, b, c;

        public ThreeAmigos(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void swapThree(ThreeAmigos in) {
        in.a = in.a + in.b + in.c;
        in.b = in.a - in.b - in.c;
        in.c = in.a - in.c - in.b;
        in.a = in.a - in.b - in.c;
    }
}




    
