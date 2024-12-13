public class overriding {
    int m() {
        System.out.println("A의 m()");
        return 0;
    }
}

class overridingchild extends overriding{
    int m(int i) {
        System.out.println("Achild m()");
        return -1;
    }
}

/*
조건
1) 메소드 이름이 같아야 함
2) 리턴타입이 일치해야 함 new Achild(); a.m();
3) 파라미터의 타입과 순서와 갯수가 모두 일치해야 함
4)
 */