import java.util.List;

public interface TreeObject {

    Object getId();

    void setId(Object id);

    Object getParentId();

    void setParentId(Object parentId);

    String getName();

    void setName(String name);

    List getChildren();

    void setChildren(List children);
}
