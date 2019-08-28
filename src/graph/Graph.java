package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 * use int [][] && ArrayList to define the graph.
 *  vertex is a String array{A,B,....}
 * edge is represent as A->B if weight is 1, and if 0 there is no edge between A->B
 *
 */

public class Graph {
    //define vertex
    private int vertexSize;
    private ArrayList<String> vertexList;
    private int[][] edges;// 邻接矩阵
    private static final int MAX_WEIGHT = 1000;// 代表顶点之间不连通
    private boolean[] isVisited; // 顶点是否已经被访问
    //num of edges
    private int numOfEdges;
    //define which node has been visited

    public static void main(String[] args) {
        int n = 8;
        String[] Vertexs = new String[]{"A", "B", "C", "D", "F", "E", "G", "H"};
        Graph graph = new Graph(n);
        String[] var7 = Vertexs;

        for (int i = 0; i < Vertexs.length; ++i) {
            String vertex = Vertexs[i];
            graph.insertVertex(vertex);
        }
        int[] v0 = { 0, 4, MAX_WEIGHT, 7, 2, MAX_WEIGHT };
        int[] v1 = { MAX_WEIGHT, 0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3 };
        int[] v2 = { MAX_WEIGHT, 9, 0, 5, 6, MAX_WEIGHT };
        int[] v3 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT, MAX_WEIGHT };
        int[] v4 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT };
        int[] v5 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 1, 0 };


        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.showGraph();
        System.out.println("深度遍历");
//        graph.dfs();
        System.out.println("广度优先!");
        graph.broadFirstSearch();
    }

    /**
     * define a graph with n edges
     *
     * @param vertexSize
     */
    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        this.edges = new int[vertexSize][vertexSize];
        this.vertexList = new ArrayList(vertexSize);
        this.numOfEdges = 0;
        isVisited = new boolean[vertexSize];
    }

    /***
     * get number of the vertexs
     * @return
     */
    public int getNumOfVertex() {
        return this.vertexList.size();
    }

    /***
     * traversal the graph
     */
    public void showGraph() {
        int[][] var4;
        int var3 = (var4 = this.edges).length;
        for (int var2 = 0; var2 < var3; ++var2) {
            int[] link = var4[var2];
            System.err.println(Arrays.toString(link));
        }
    }

    /***
     * get the number of edges. from field defined in class
     * @return
     */
    public int getNumOfEdges() {
        return this.numOfEdges;
    }

    //value = get vertexList[index]
    public String getValueByIndex(int i) {
        return (String) this.vertexList.get(i);
    }

    /**
     * @param v1 vertex 1
     * @param v2 vertex 2
     * @return return weight if edge or not
     */
    public int getWeight(int v1, int v2) {
        return this.edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        this.vertexList.add(vertex);
    }

    /***
     * @param v1 vertex 1
     * @param v2 vertex 2
     * @param weight edge, and  num ++
     */
    public void insertEdge(int v1, int v2, int weight) {
        this.edges[v1][v2] = weight;
        this.edges[v2][v1] = weight;
        ++this.numOfEdges;
    }

    /***
     *
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < this.vertexSize; j++) {
            if (this.edges[index][j] > 0 && edges[index][j] != 1000) {
                return j;
            }
        }
        return -1;
    }
    public int getNextNeighbor(int v, int index) {
        for (int j = index + 1; j < this.vertexSize; j++) {
            if (this.edges[v][j] > 0 && edges[v][j] != 1000) {
                return j;
            }
        }
        return -1;
    }

    /***
     * dfs from root i
     */
    public void dfs(int i) {
                    // 开始遍历顶点i---所以将其标记为已经遍历了
        isVisited[i] = true;
                    //traversal each vertex, first get the first neighbor
        int FN = getFirstNeighbor(i);
                    //if first FN exist and isVisited is false;
        while (FN != -1) {
            if (!isVisited[FN]) {
                System.out.println("traversal:" + FN + "vertex");
                            //then traversal the following neighbor with calling the method dfs recurively
                dfs(FN);
            }
            //if the FN has been visited, find  another node,
            FN = getNextNeighbor(i, FN);
        }
    }
    // the exposed method
    public void dfs() {
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                System.out.println("遍历到了:" + i + "顶点");
                dfs(i);
            }
        }
    }

    /***
     * broad search
     */

    public void broadFirstSearch(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        isVisited[i] = true;
        //mark as visited
        System.out.println("traversal:"+i+"vertex");
        while (!queue.isEmpty()){
            Integer head =queue.poll();
            //get the neighbour of head of queue
            int FN = getFirstNeighbor(head);
            while(FN != -1){
                if(!isVisited[FN]){
                    isVisited[FN] = true;
                    System.out.println("traversal:"+FN+"vertex");
                    queue.add(FN);
                }
                FN = getNextNeighbor(head, FN);
            }
        }
    }
    // 对外提供的广度优先遍历
    public void broadFirstSearch() {
        // 如我例子中的节点2---所以需要对每一个节点进行一下循环
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                System.out.println("traversal:"+i+"done");
                broadFirstSearch(i);
            }
        }
    }

}
