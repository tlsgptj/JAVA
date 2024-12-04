class Dan {
    public void GuGu() {
        for (int n = 1; n <= 10; n++) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.println(n + "*" + i + "*" + j + "=" + (n * i * j));
                }
            }
        }
        System.out.println(" ");
    }

    static class Dan2 {
        public void GuGu2() {
            int i = 1;
            do {
                int j = 1;
                do {
                    int k = 1;
                    do {
                        System.out.println(i+"*"+j+"*"+k+"="+i*j*k);
                        k++;
                    } while (k<=9);
                    j++;
                } while (j<=9);
                i++;
                System.out.println(" ");
            } while (i<=9);
        }

        static class Star {
            public void MakeStar() {
                for(int i = 1; i <= 4; i ++) {
                    for (int j = 1; j <= 4; j ++) {
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
            }
        }

        static class Start {
            public void ManyStart() {
                for(int i = 1; i <= 4; i++){
                    for(int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }

                System.out.println(" ");

                for(int i = 1; i < 5; i++){
                    for(int j = 5; j>i; j--) {
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }

                System.out.println(" ");

                for(int i = 1; i <= 4; i++){
                    for(int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }

                System.out.println(" ");

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j<i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j<4-i; j++) {
                        System.out.print("*");
                    }
                    System.out.println(" ");
                }
            }
        }

        public static void main(String[] args) {
            Dan dan = new Dan();
            Dan.Dan2 dan2 = new Dan2();
            Star star = new Star();
            Start start = new Start();
            dan.GuGu();
            dan2.GuGu2();
            star.MakeStar();
            start.ManyStart();
        }

    }
}