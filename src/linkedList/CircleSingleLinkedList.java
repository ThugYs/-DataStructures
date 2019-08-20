package linkedList;

public class CircleSingleLinkedList {
    private Node first = null;
    public CircleSingleLinkedList(){

    }
    public void addNode(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确");
        }
        Node curNode = null;
        for(int i = 1; i<=nums; ++i){
            Node node = new Node(i);
            if( i == 1 ){
                this.first = node;
                this.first.setNext(this.first);
                curNode = this.first;
            }
            curNode.setNext(node);
            node.setNext(this.first);
            curNode = node;
        }
    }
    public void showNode(){
        if(this.first == null){
            System.out.println("none");
        }
        Node curNode = this.first;
        while(true){
            System.out.printf("小孩的编号 %d \n", curNode.data);
            if(curNode.getNext() == this.first){
                return;
            }
            curNode = curNode.getNext();

        }
//        for(Node curNode =this.first; curNode !=this.first; curNode = curNode.next){
//            System.out.printf("小孩的编号 %d \n", curNode.data);
//            System.out.println(curNode);
//        }
    }

    /***
     * joshfu func
     */
    public void countNode2(int countNum){
        while(this.first.next !=first){
            int j =0;
            for(j = 0;j<countNum-2; j++){
                first = this.first.next;
            }
            System.out.printf("小孩%d出圈\n", this.first.next.getData());
            first.next = first.next.next;
            first= first.next;
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", this.first.getData());
    }

    public void countNode(int countNum){
        if( this.first != null){
            Node help;
            /***
             * help循环到最后一个, first 前一个 ,有一个help在很省步奏
             */
            for(help = this.first; help.getNext() !=this.first; help = help.next){
            }
            int j;
            //help and first move together
            while(help !=this.first){
                for(j = 0;j<countNum -1; j++){
                    first = this.first.next;
                    help = help.next;
                }
                System.out.printf("小孩%d出圈\n", this.first.getData());

                help.next = first.next;
                first = first.next;
            }
            System.out.printf("最后留在圈中的小孩编号%d \n", this.first.getData());
        }else{
            System.out.println("参数输入有误， 请重新输入");
        }

    }
}
