package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/qq_41399429/article/details/82629387
 * 任意一个对象，实现Nodeable接口
 * 返回id，和父节点id
 */
public class Demo implements Nodeable {

    private String id;
    private String pid;
    private String name;

    public Demo(String id, String pid){
        this.id = id;
        this.pid = pid;
    }

    @Override
    public String theId() {
        return id;
    }
    @Override
    public String theParentId() {
        return pid;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     useroot
     10
     120
     4876
     41344
     4582
     45664
     58761
     125
     451
     454678
     64487
     510345
     115
     11
     153
     186
     178
     13
     137
     15130
     5131
     158
     1783
     1568
     136


     */


    public static void main(String[] args) throws Exception{
        List<Demo> list = new ArrayList();
        list.add(new Demo("10", ""));
        list.add(new Demo("120", "10"));
        list.add(new Demo("4876", "120"));
        list.add(new Demo("41344", "4876"));
        list.add(new Demo("4582", "120"));
        list.add(new Demo("45664", "4582"));
        list.add(new Demo("58761", "4582"));
        list.add(new Demo("125", "10"));
        list.add(new Demo("451", "125"));
        list.add(new Demo("454678", "451"));
        list.add(new Demo("64487", "454678"));
        list.add(new Demo("510345", "64487"));
        list.add(new Demo("115", "10"));
        list.add(new Demo("11", ""));
        list.add(new Demo("153", "11"));
        list.add(new Demo("186", "11"));
        list.add(new Demo("178", "11"));
        list.add(new Demo("13", ""));
        list.add(new Demo("137", "13"));
        list.add(new Demo("15130", "137"));
        list.add(new Demo("5131", "15130"));
        list.add(new Demo("158", "13"));
        list.add(new Demo("1783", "158"));
        list.add(new Demo("1568", "158"));
        list.add(new Demo("136", "13"));

        TreeHandler<Demo> tree = new TreeHandler<>("useroot");
        NodeInfo<Demo> root = tree.parseArray(list);

        NodeInfo<Demo> childTree = tree.queryTree("4582");
        System.out.println(childTree.getParentIds());

        List<NodeInfo<Demo>> nodes = tree.getNodes();

        TreeHandler handler = tree.splitById("13", "");
        handler.getNodeMap();

    }
}