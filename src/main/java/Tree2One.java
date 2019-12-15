import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree2One {

    public static void main(String[] args) {
        Tree2One testDemo = new Tree2One();
        testDemo.demo();
    }

    private void demo() {
        String[] a = {"1", "1-3-4", "1-2", "1-2"};
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> item = new HashMap<String, String>();

        for (String str : a) {//遍历字符数组
            String strArr[] = str.split("-");//将单个字符以-分隔成字符
            for (int i = 0; i < strArr.length; i++) {
                item = new HashMap<String, String>();
                if (i == 0) {
                    item.put("id", strArr[i]);
                    item.put("parentId", "");//第一个值就直接设置父id为空字符
                } else {
                    item.put("id", strArr[i]);
                    item.put("parentId", strArr[i - 1]);//到第二个值才设置父id为前一个下标值的id
                }
                // 判断是否已经存在值相同的
                boolean isAdd = true;
                for (Map<String, String> itemT : list) {//遍历最外层的list
                    if (itemT.get("id").equals(item.get("id")) && itemT.get("parentId").equals(item.get("parentId"))) {
                        isAdd = false;
                    }//如果取到一个元素map里id和parent都和这次的相同，那就说明已经有了，就不要添加到集合里
                }
                if (isAdd) {
                    list.add(item);
                }

            }

        }
        for (Map<String, String> itemT : list) {
            System.out.println(itemT.get("id") + "\t" + itemT.get("parentId"));
        }
        // 开始递归
        JsonArray jsonArray = new JsonArray();
        for (Map<String, String> itemT : list) {
            if ("".equals(itemT.get("parentId"))) {//这种写法还是不完美，如果空字符不是第一个位置，就完全不会走了，我想多了，循环肯定会走到的
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("id", itemT.get("id"));
                jsonArray.add(jsonObject);//把第一个根节点加入jsonArray
                seracherItem(jsonObject, list);
            }
        }

        System.out.println(jsonArray.toString());


    }

    /**
     * 递归调用
     *
     * @param jsonObject
     * @param list
     */
    private void seracherItem(JsonObject jsonObject, List<Map<String, String>> list) {
        JsonArray jsonArray = new JsonArray();
        jsonObject.add("children", jsonArray);//新建一个children和jsonArray搭配的节点

        for (Map<String, String> itemT : list) {//还是以最大的list进行循环

            if (jsonObject.get("id").getAsString().equals(itemT.get("parentId"))) {
                //如果传进来的id和循环过程中的取到的parentId相等，那么就进行操作
                System.out.println(jsonObject.get("id").getAsString() + "  " + itemT.get("parentId"));

                JsonObject jsonObjectT = new JsonObject();//新建一个JsonObject
                jsonObjectT.addProperty("id", itemT.get("id"));//将这个
                jsonObjectT.addProperty("parentId", jsonObject.get("id").getAsString());//将这个
                jsonArray.add(jsonObjectT);
                seracherItem(jsonObjectT, list);
            }

        }
    }//这个遍历的思想就是传入每一层的根节点和一维目录，进行递归

}