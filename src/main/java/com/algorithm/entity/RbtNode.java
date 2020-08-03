package com.algorithm.entity;


import java.util.ArrayList;
import java.util.List;

public class RbtNode {

    // 左子节点
    RbtNode leftRbtNode;
    // 右子节点
    RbtNode rightRbtNode;
    //父节点
    RbtNode parentNode;
    //节点颜色
    String color;
    // 值
    Object value;

    //创建Node时直接赋值
    public RbtNode(int value) {
        this.value = value;
    }

    // 红黑树插入数据的方法
    public void addRbt(int v) {
        if (null == value) {
            value = v;
            this.parentNode = null;
            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        } else {
            // 新增的值，比当前值小或者相同

            if (v - ((Integer) value) <= 0) {
                if (null == leftRbtNode) {
                    //左节点差值
                    leftRbtNode = new RbtNode(0);   //初始化新节点的value
                    leftRbtNode.value = v;
                    leftRbtNode.parentNode = this;         //新节点的父节点
                    leftRbtNode.color = "red";            //初始化新节点的颜色
                    System.out.println("value=" + value + " leftRbtNode.value=" + leftRbtNode.value);
                    if (null != rightRbtNode) {
                        System.out.println("value=" + value + " rightRbtNode.value=" + rightRbtNode.value);
                    }
                    //*红黑树的平衡判断与变换*//
                    leftRbtNode.judge(leftRbtNode);
                } else {
                    leftRbtNode.addRbt(v);
                }
                //新增的值，比当前值大
            } else {
                if (null == rightRbtNode) {
                    rightRbtNode = new RbtNode(0);  //初始化新节点的value
                    rightRbtNode.value = v;
                    rightRbtNode.parentNode = this;       //新节点的父节点
                    rightRbtNode.color = "red";           //初始化新节点的颜色
                    System.out.println("value=" + value + " rightRbtNode.value=" + rightRbtNode.value);
                    if (null != leftRbtNode) {
                        System.out.println("value=" + value + " leftRbtNode.value=" + leftRbtNode.value);
                    }
                    //*红黑树的平衡判断与变换*//
                    rightRbtNode.judge(rightRbtNode);
                } else {
                    rightRbtNode.addRbt(v);
                }
            }
        }
    }

    //如果新插入节点影响平衡则变换
    private void judge(RbtNode rbtNode) {
        RbtNode rootRbtNode = this.queryRoot(this);
        System.out.println("根节点值为" + rootRbtNode.value + "，根节点颜色为" + rootRbtNode.color);
        List<Object> result = rootRbtNode.midFind();   //遍历值
        List<String> colors = rootRbtNode.midFindColro();  //遍历颜色
        System.out.println("节点值：" + result + "，节点颜色" + colors);
        //父节点为根节点时
        if (rbtNode.parentNode.parentNode == null || rbtNode.parentNode.color == "black") {
            return;
        } else {
            //父节点与叔父节点都为红时
            if (rbtNode.parentNode.parentNode.rightRbtNode != null && rbtNode.parentNode.parentNode.leftRbtNode != null) {
                if (rbtNode.parentNode.parentNode.leftRbtNode.color == "red" && rbtNode.parentNode.parentNode.rightRbtNode.color == "red") {
                    rbtNode.parentNode.parentNode.leftRbtNode.color = "black";
                    rbtNode.parentNode.parentNode.rightRbtNode.color = "black";
                    //如果祖父节点不为根节点，则祖父节点需变色并以祖父节点作为新插入节点进行迭代判断
                    if (rbtNode.parentNode.parentNode.parentNode != null) {
                        rbtNode.parentNode.parentNode.color = "red";
                        //如果祖父节点不是根节点，则将祖父节点作为新插入节点向上迭代验证
                        rbtNode.parentNode.parentNode.judge(rbtNode.parentNode.parentNode);
                    }
                    return;
                }
            }
            //新节点为父节点的左节点时
            if (rbtNode == rbtNode.parentNode.leftRbtNode) {
                //父节点为祖父节点的左节点且父节点为红，叔父节点为空或黑时，旋转一次：祖父节点右旋转并变色
                if (rbtNode.parentNode == rbtNode.parentNode.parentNode.leftRbtNode && rbtNode.parentNode.color == "red") {
                    if (rbtNode.parentNode.parentNode.rightRbtNode == null || rbtNode.parentNode.parentNode.rightRbtNode.color == "black") {
                        rbtNode.parentNode = rbtNode.parentNode.rightRotate(rbtNode.parentNode.parentNode, rbtNode.parentNode);
                        rbtNode.parentNode.color = "black";
                        rbtNode.parentNode.rightRbtNode.color = "red";
                    }
                    return;
                }
                //父节点为祖父节点的右节点且父节点为红，叔父节点为空或黑时，旋转两次：父节点右旋转、祖父节点左旋转并变色
                else if (rbtNode.parentNode == rbtNode.parentNode.parentNode.rightRbtNode && rbtNode.parentNode.color == "red") {
                    if (rbtNode.parentNode.parentNode.leftRbtNode == null || rbtNode.parentNode.parentNode.leftRbtNode.color == "black") {
                        rbtNode = rbtNode.rightRotate(rbtNode.parentNode, rbtNode);
                        rbtNode = rbtNode.leftRotate(rbtNode.parentNode, rbtNode);
                        rbtNode.color = "black";
                        rbtNode.leftRbtNode.color = "red";
                    }
                    return;
                }
            }
            //新节点为父节点的右节点时
            else if (rbtNode == rbtNode.parentNode.rightRbtNode) {
                //父节点为祖父节点的右节点且父节点为红，叔父节点为空或黑时，旋转一次：祖父节点左旋转并变色
                if (rbtNode.parentNode == rbtNode.parentNode.parentNode.rightRbtNode && rbtNode.parentNode.color == "red") {
                    if (rbtNode.parentNode.parentNode.leftRbtNode == null || rbtNode.parentNode.parentNode.leftRbtNode.color == "black") {
                        rbtNode.parentNode = rbtNode.parentNode.leftRotate(rbtNode.parentNode.parentNode, rbtNode.parentNode);
                        rbtNode.parentNode.color = "black";
                        rbtNode.parentNode.leftRbtNode.color = "red";
                    }
                    return;
                }
                //父节点为祖父节点的左节点且父节点为红，叔父节点为空或黑时，旋转两次：父节点左旋转、祖父节点右旋转并变色
                else if (rbtNode.parentNode == rbtNode.parentNode.parentNode.leftRbtNode && rbtNode.parentNode.color == "red") {
                    if (rbtNode.parentNode.parentNode.rightRbtNode == null || rbtNode.parentNode.parentNode.rightRbtNode.color == "black") {
                        rbtNode = rbtNode.leftRotate(rbtNode.parentNode, rbtNode);
                        rbtNode = rbtNode.rightRotate(rbtNode.parentNode, rbtNode);
                        rbtNode.color = "black";
                        rbtNode.rightRbtNode.color = "red";
                    }
                    return;
                }
            }
        }
    }

    //红黑树删除数据
    public void delete(int x) {
        //查找是否存在该数值的节点
        RbtNode rbtNode = queryNode(x);
        //节点不为空
        if (rbtNode != null) {
            //该节点不是叶子结点时,调换value到叶子结点
            if (rbtNode.leftRbtNode != null || rbtNode.rightRbtNode != null) {
                rbtNode = rbtNode.transposition(rbtNode);
            }
            //确定节点变为叶子结点后， 分多种情况删除
//            String Nodecolor = rbtNode.color;          //记录该叶子节点颜色
//            RbtNode parentNode = rbtNode.parentNode;   //记录该节点的父节点
//            rbtNode = null;                            //删除该节点
            //调整红黑树结构
            rbtNode.adjust(rbtNode);
            //最后删除该节点
            if (rbtNode == rbtNode.parentNode.leftRbtNode) {
                rbtNode.parentNode.leftRbtNode = null;
            } else {
                rbtNode.parentNode.rightRbtNode = null;
            }
            rbtNode = null;
        }
    }

    private void adjust(RbtNode rbtNode) {
        //叶子结点为黑时，分以下多种情况调整删除
        if (rbtNode.color == "black") {
            //当该叶子结点为左节点时
            if (rbtNode == rbtNode.parentNode.leftRbtNode) {
                //1.当兄弟节点也为黑，且没有子节点时，将兄弟节点设为红，父节点向上递归调整红黑树，直至根节点或红节点
                if (rbtNode.parentNode.rightRbtNode.color == "black" && rbtNode.parentNode.rightRbtNode.leftRbtNode == null && rbtNode.parentNode.rightRbtNode.rightRbtNode == null) {
                    rbtNode.parentNode.rightRbtNode.color = "red";
                    //向上递归检查并调整红黑树
                    if (rbtNode.parentNode.color == "black" && rbtNode.parentNode.parentNode != null) {
                        rbtNode.parentNode.adjust(rbtNode.parentNode);  //若父节点为黑且不为根节点，则父节点需向上递归调整
                    } else if (rbtNode.parentNode.color == "red") {
                        rbtNode.parentNode.color = "black";  //若父节点为红，则改为黑即平衡
                    }
                    //2.兄弟节点为黑，且有一个红色的左节点，右旋转再左旋转，再变色
                } else if (rbtNode.parentNode.rightRbtNode.color == "black" && rbtNode.parentNode.rightRbtNode.leftRbtNode != null && rbtNode.parentNode.rightRbtNode.leftRbtNode.color == "red" && rbtNode.parentNode.rightRbtNode.rightRbtNode == null) {
                    RbtNode rbtNode1 = rbtNode.rightRotate(rbtNode.parentNode.rightRbtNode, rbtNode.parentNode.rightRbtNode.leftRbtNode);
                    rbtNode1 = rbtNode.leftRotate(rbtNode.parentNode, rbtNode.parentNode.rightRbtNode);
                    rbtNode.parentNode.parentNode.color = rbtNode.parentNode.color;
                    rbtNode.parentNode.color = "black";
                    //3.兄弟节点为黑，且有一个红色的右节点，左旋转，再变色
                } else if (rbtNode.parentNode.rightRbtNode.color == "black" && rbtNode.parentNode.rightRbtNode.rightRbtNode != null && rbtNode.parentNode.rightRbtNode.rightRbtNode.color == "red" && rbtNode.parentNode.rightRbtNode.leftRbtNode == null) {
                    RbtNode rbtNode1 = rbtNode.leftRotate(rbtNode.parentNode, rbtNode.parentNode.rightRbtNode);
                    rbtNode.parentNode.parentNode.color = rbtNode.parentNode.color;
                    rbtNode.parentNode.color = "black";
                    rbtNode.parentNode.parentNode.rightRbtNode.color = "black";
                    //4.兄弟节点为黑，且有两个红色的子节点，左旋转，再变色
                } else if (rbtNode.parentNode.rightRbtNode.color == "black" && rbtNode.parentNode.rightRbtNode.rightRbtNode != null && rbtNode.parentNode.rightRbtNode.rightRbtNode.color == "red" && rbtNode.parentNode.rightRbtNode.leftRbtNode != null && rbtNode.parentNode.rightRbtNode.leftRbtNode.color == "red") {
                    RbtNode rbtNode1 = rbtNode.leftRotate(rbtNode.parentNode, rbtNode.parentNode.rightRbtNode);
                    rbtNode.parentNode.parentNode.color = rbtNode.parentNode.color;
                    rbtNode.parentNode.color = "black";
                    rbtNode.parentNode.parentNode.rightRbtNode.color = "black";
                    //4.兄弟节点为红，且有两个黑色的子节点，则父节点必为黑，左旋转，再变色
                } else if (rbtNode.parentNode.rightRbtNode.color == "red" && rbtNode.parentNode.rightRbtNode.rightRbtNode != null && rbtNode.parentNode.rightRbtNode.rightRbtNode.color == "black" && rbtNode.parentNode.rightRbtNode.leftRbtNode != null && rbtNode.parentNode.rightRbtNode.leftRbtNode.color == "black") {
                    RbtNode rbtNode1 = rbtNode.leftRotate(rbtNode.parentNode, rbtNode.parentNode.rightRbtNode);
                    rbtNode.parentNode.parentNode.color = "black";
                    rbtNode.parentNode.rightRbtNode.color = "red";
                }
            } else if (rbtNode == rbtNode.parentNode.rightRbtNode) {   //该叶子结点为右节点时
                //1.当兄弟节点也为黑，且没有子节点时，将兄弟节点设为红，父节点向上递归调整红黑树，直至根节点或红节点
                if (rbtNode.parentNode.leftRbtNode.color == "black" && rbtNode.parentNode.leftRbtNode.leftRbtNode == null && rbtNode.parentNode.rightRbtNode.rightRbtNode == null) {
                    rbtNode.parentNode.leftRbtNode.color = "red";
                    //向上递归检查并调整红黑树
                    if (rbtNode.parentNode.color == "black" && rbtNode.parentNode.parentNode != null) {
                        rbtNode.parentNode.adjust(rbtNode.parentNode);  //若父节点为黑且不为根节点，则父节点需向上递归调整
                    } else if (rbtNode.parentNode.color == "red") {
                        rbtNode.parentNode.color = "black";  //若父节点为红，则改为黑即平衡
                    }
                    //2.兄弟节点为黑，且有一个红色的右节点，左旋转再右旋转，再变色
                } else if (rbtNode.parentNode.leftRbtNode.color == "black" && rbtNode.parentNode.leftRbtNode.rightRbtNode != null && rbtNode.parentNode.leftRbtNode.rightRbtNode.color == "red" && rbtNode.parentNode.leftRbtNode.leftRbtNode == null) {
                    RbtNode rbtNode1 = rbtNode.leftRotate(rbtNode.parentNode.leftRbtNode, rbtNode.parentNode.leftRbtNode.rightRbtNode);
                    rbtNode1 = rbtNode.rightRotate(rbtNode.parentNode, rbtNode.parentNode.leftRbtNode);
                    rbtNode.parentNode.parentNode.color = rbtNode.parentNode.color;
                    rbtNode.parentNode.color = "black";
                    //3.兄弟节点为黑，且有一个红色的左节点，右旋转，再变色
                } else if (rbtNode.parentNode.leftRbtNode.color == "black" && rbtNode.parentNode.leftRbtNode.leftRbtNode != null && rbtNode.parentNode.leftRbtNode.leftRbtNode.color == "red" && rbtNode.parentNode.leftRbtNode.rightRbtNode == null) {
                    RbtNode rbtNode1 = rbtNode.rightRotate(rbtNode.parentNode, rbtNode.parentNode.leftRbtNode);
                    rbtNode.parentNode.parentNode.color = rbtNode.parentNode.color;
                    rbtNode.parentNode.color = "black";
                    rbtNode.parentNode.parentNode.leftRbtNode.color = "black";
                    //4.兄弟节点为黑，且有两个红色的子节点，右旋转，再变色
                } else if (rbtNode.parentNode.leftRbtNode.color == "black" && rbtNode.parentNode.rightRbtNode.rightRbtNode != null && rbtNode.parentNode.rightRbtNode.rightRbtNode.color == "red" && rbtNode.parentNode.rightRbtNode.leftRbtNode != null && rbtNode.parentNode.rightRbtNode.leftRbtNode.color == "red") {
                    RbtNode rbtNode1 = rbtNode.rightRotate(rbtNode.parentNode, rbtNode.parentNode.leftRbtNode);
                    rbtNode.parentNode.parentNode.color = rbtNode.parentNode.color;
                    rbtNode.parentNode.color = "black";
                    rbtNode.parentNode.parentNode.leftRbtNode.color = "black";
                    //4.兄弟节点为红，且有两个黑色的子节点，则父节点必为黑，右旋转，再变色
                } else if (rbtNode.parentNode.leftRbtNode.color == "red" && rbtNode.parentNode.rightRbtNode.rightRbtNode != null && rbtNode.parentNode.rightRbtNode.rightRbtNode.color == "black" && rbtNode.parentNode.rightRbtNode.leftRbtNode != null && rbtNode.parentNode.rightRbtNode.leftRbtNode.color == "black") {
                    RbtNode rbtNode1 = rbtNode.rightRotate(rbtNode.parentNode, rbtNode.parentNode.leftRbtNode);
                    rbtNode.parentNode.parentNode.color = "black";
                    rbtNode.parentNode.leftRbtNode.color = "red";
                }
            }
        }
    }

    private RbtNode transposition(RbtNode rbtNode) {
        //有2个子节点,找后继节点交换value
        if (rbtNode.leftRbtNode != null && rbtNode.rightRbtNode != null) {
            RbtNode rearNode = rbtNode.rightRbtNode;
            while (rearNode.leftRbtNode != null) {
                rearNode = rearNode.leftRbtNode;
            }
            int m = (Integer) rbtNode.value;
            rbtNode.value = rearNode.value;
            rearNode.value = m;
            return rearNode;
            //有1个子节点,直接交换value
        } else {
            if (rbtNode.leftRbtNode != null) {
                int m = (Integer) rbtNode.value;
                rbtNode.value = rbtNode.rightRbtNode.value;
                rbtNode.rightRbtNode.value = m;
                return rbtNode.rightRbtNode;
            } else {
                int m = (Integer) rbtNode.value;
                rbtNode.value = rbtNode.leftRbtNode.value;
                rbtNode.leftRbtNode.value = m;
                return rbtNode.leftRbtNode;
            }
        }
    }

    //查找是否存在该数值的节点
    public RbtNode queryNode(int v) {
        //值比当前值小
        if (v - ((Integer) value) < 0) {
            if (leftRbtNode != null) {
                RbtNode rbtNode = leftRbtNode.queryNode(v);
                return rbtNode;
            } else {
                return null;
            }
        } else if (v - ((Integer) value) > 0) {
            if (rightRbtNode != null) {
                RbtNode rbtNode = rightRbtNode.queryNode(v);
                return rbtNode;
            } else {
                return null;
            }
        } else {
            return this;
        }
    }

    //左旋转
    private RbtNode leftRotate(RbtNode x, RbtNode y) {
//        性质： y = x.rightRbtNode;
        System.out.println("y.value=" + y.value + " x.value=" + x.value);
        if (x.parentNode != null && y.parentNode != null) {
            System.out.println("x.parentNode.value=" + x.parentNode.value + " y.parentNode.value=" + y.parentNode.value);
        }
        if (x.parentNode != null) {
            y.parentNode = x.parentNode;
            if (x == x.parentNode.leftRbtNode) {
                x.parentNode.leftRbtNode = y;
                x.parentNode = y;
            } else {
                x.parentNode.rightRbtNode = y;
                x.parentNode = y;
            }
        } else {
            y.parentNode = null;
            x.parentNode = y;
        }
        if (y.leftRbtNode != null) {
            x.rightRbtNode = y.leftRbtNode;
            y.leftRbtNode.parentNode = x;
        } else {
            x.rightRbtNode = null;
        }
//        x = y.leftRbtNode;
        y.leftRbtNode = x;
        System.out.println("y.leftRbtNode.value=" + y.leftRbtNode.value + " x.parentNode.value=" + x.parentNode.value);
        return y;
    }

    //右旋转
    private RbtNode rightRotate(RbtNode x, RbtNode y) {
//        性质： y = x.leftRbtNode;
        System.out.println("y.value=" + y.value + " x.value=" + x.value);
        if (x.parentNode != null && y.parentNode != null) {
            System.out.println("x.parentNode.value=" + x.parentNode.value + " y.parentNode.value=" + y.parentNode.value);
        }
        if (x.parentNode != null) {
            y.parentNode = x.parentNode;
            if (x == x.parentNode.leftRbtNode) {
                x.parentNode.leftRbtNode = y;
                x.parentNode = y;
            } else {
                x.parentNode.rightRbtNode = y;
                x.parentNode = y;
            }
        } else {
            y.parentNode = null;
            x.parentNode = y;
        }
        if (y.rightRbtNode != null) {
            x.leftRbtNode = y.rightRbtNode;
            y.rightRbtNode.parentNode = x;
        } else {
            x.leftRbtNode = null;
        }
//        x = y.rightRbtNode;
        y.rightRbtNode = x;
        System.out.println("y.rightRbtNode.value=" + y.rightRbtNode.value + " x.parentNode.value=" + x.parentNode.value);
        return y;
    }

    // 前序遍历所有的节点值
    public List<Object> frontFind() {
        List<Object> values = new ArrayList<>();

        // 当前节点
        values.add(value);

        // 左节点的遍历结果
        if (null != leftRbtNode)
            values.addAll(leftRbtNode.frontFind());

        // 右节点的遍历结果
        if (null != rightRbtNode)
            values.addAll(rightRbtNode.frontFind());

        return values;
    }

    // 中序遍历所有的节点值
    public List<Object> midFind() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftRbtNode)
            values.addAll(leftRbtNode.midFind());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightRbtNode)
            values.addAll(rightRbtNode.midFind());

        return values;
    }

    //后序遍历所有的节点值
    public List<Object> rearFind() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftRbtNode)
            values.addAll(leftRbtNode.rearFind());

        // 右节点的遍历结果
        if (null != rightRbtNode)
            values.addAll(rightRbtNode.rearFind());

        // 当前节点
        values.add(value);

        return values;
    }

    // 前序遍历所有的节点颜色
    public List<String> frontFindColor() {
        List<String> values = new ArrayList<>();

        // 当前节点
        values.add(color);

        // 左节点的遍历结果
        if (null != leftRbtNode)
            values.addAll(leftRbtNode.frontFindColor());

        // 右节点的遍历结果
        if (null != rightRbtNode)
            values.addAll(rightRbtNode.frontFindColor());

        return values;
    }

    // 中序遍历所有的节点颜色
    public List<String> midFindColro() {
        List<String> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftRbtNode)
            values.addAll(leftRbtNode.midFindColro());

        // 当前节点
        values.add(color);

        // 右节点的遍历结果
        if (null != rightRbtNode)
            values.addAll(rightRbtNode.midFindColro());

        return values;
    }

    //后序遍历所有的节点颜色
    public List<String> rearFindColro() {
        List<String> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftRbtNode)
            values.addAll(leftRbtNode.rearFindColro());

        // 右节点的遍历结果
        if (null != rightRbtNode)
            values.addAll(rightRbtNode.rearFindColro());

        // 当前节点
        values.add(color);

        return values;
    }

    //查询根节点
    public RbtNode queryRoot(RbtNode rbtNode) {
        if (rbtNode.parentNode != null) {
            RbtNode root = rbtNode.parentNode.queryRoot(rbtNode.parentNode);
            return root;
        } else {
            return rbtNode;
        }
    }

}
