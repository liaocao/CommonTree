

import java.io.Serializable;
import java.util.List;

public class MenuTreeDto implements Serializable, TreeObject {
    private static final long serialVersionUID = 1L;
    private String id;//菜单id
    private String menuName;//菜单名称
    private Short menuType;//菜单类型
    private String menuCode;//菜单代码
    private String parentId;//父节点id
    private Long sortNo;//排序
    private Short expand;//展开状态
    private Short isShow;//是否为叶子
    private String permission;//权限标识
    private String comt;//备注
    private Short enable;//是否启用
    private String iconcls;//节点图标css类名
    private String request;//请求地址
    private List children;//子部门

    @Override
    public Object getId() {
        return this.id;
    }

    @Override
    public void setId(Object id) {
        this.id = (String) id;
    }

    @Override
    public Object getParentId() {
        return this.parentId;
    }

    @Override
    public void setParentId(Object parentId) {
        this.parentId = (String) parentId;
    }

    @Override
    public String getName() {
        return this.menuName;
    }

    @Override
    public void setName(String name) {
        this.menuName = name;
    }

    @Override
    public List getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Short getMenuType() {
        return menuType;
    }

    public void setMenuType(Short menuType) {
        this.menuType = menuType;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getSortNo() {
        return sortNo;
    }

    public void setSortNo(Long sortNo) {
        this.sortNo = sortNo;
    }

    public Short getExpand() {
        return expand;
    }

    public void setExpand(Short expand) {
        this.expand = expand;
    }

    public Short getIsShow() {
        return isShow;
    }

    public void setIsShow(Short isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getComt() {
        return comt;
    }

    public void setComt(String comt) {
        this.comt = comt;
    }

    public Short getEnable() {
        return enable;
    }

    public void setEnable(Short enable) {
        this.enable = enable;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}