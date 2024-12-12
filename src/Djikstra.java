import java.io.*;
import java.util.*;
public class Djikstra {
    //다익스트라 구현
    //거쳐 갈 혹은 시작할 노드를 방문 후 방문 처리
    //방문한 노드에서 이동할 수 있는 노드들을 탐색
    //탐색된 노드들의 계산된 거리 비용이 현재까지 저장된 최단거리보다 적을 경우 최단거리 갱신
    //최단거리가 갱신된 노드들 중 가장 작은 거리를 가지는 노드로 이동 후 방문 처리
    //1~4번을 계속 반복 후 더 이상 방문할 노드가 없을 때 종료
    //INF 값 초기화
    static final int INF = 9999999;
    // 그래프를 표현 할 2차원 List
    static List<List<Node>> graph = new ArrayList<>();
    // 최단거리테이블을 표현할 배열
    static int[] result;
    //방문 처리를 위한 배열임


    //우선순위 큐에서 정렬기준을 잡기 위해 Comparable를 구현한다.
    static class Node implements Comparable<Node> {
        int index; //노드의 번호
        int distance; //이동할 노드까지의 거리

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

}
