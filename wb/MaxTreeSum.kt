import algorithm.offer.TreeNode

/**
 * @Description TODO

 * @Date 2021/11/2 下午11:19
 * @Created by wangbin
 */

// 最大路径和
fun maxPathSum(root: TreeNode?): Int {
    digui(root)
    return maxSum
}

var maxSum = Int.MIN_VALUE


fun digui(node: TreeNode?): Int{
    if(node == null){
        return 0
    }

    // 递归计算左右子节点的最大贡献值
    // 只有在最大贡献值大于 0 时，才会选取对应子节点
    var leftMax = Math.max(digui(node.left),0)
    var rightMax = Math.max(digui(node.right),0)
    // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
    val currentMax = leftMax+rightMax+ node.`val`
    // 更新答案
    maxSum = Math.max(currentMax, maxSum)
    // 返回节点的最大贡献值
    return node.`val` + Math.max(leftMax, rightMax)
}