import kotlin.math.max
import kotlin.properties.Delegates

/**
 * @Description TODO

 * @Date 2021/11/8 下午8:56
 * @Created by wangbin
 */

fun main() {

    val cache = LRUCache2(2)
    cache.put(1, 1);
    cache.put(2, 2);
    println(cache.get(1))       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    println(cache.get(2));       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    println(cache.get(1));       // 返回 -1 (未找到)
    println(cache.get(3));       // 返回  3
    println(cache.get(4));

}


class LRUCache2(capacity: Int) {

    lateinit var container: Array<Node?>

    var currentSize = 0

    var maxSize = 0

    lateinit var lruHead: Node

    lateinit var lruEnd: Node


    init {
        // 初始化一个固定容大小的数组
        container = Array(capacity) {
            null
        }
        maxSize = capacity
        lruHead = Node()
        lruEnd = Node()

        lruHead.lruNext = lruEnd

        lruEnd.lruPre = lruHead
    }


    fun get(key: Int): Int? {
        val node = findTong(key) ?: return -1

        move2Head(node)

        return node.`val`

    }


    fun move2Head(node: Node) {
        node.lruPre?.lruNext = node.lruNext
        node.lruNext?.lruPre = node.lruPre

        node.lruPre = lruHead
        node.lruNext = lruHead.lruNext
        lruHead.lruNext?.lruPre = node
        lruHead.lruNext = node
    }


    fun put(key: Int, value: Int) {

        val index = key % maxSize

        var currentNode = findTong(key)
        var rowNode = container[index]
        if (currentNode == null) {

            val node = Node()

            node.key = key
            node.`val` = value
            node.lruPre = lruHead
            node.lruNext = lruHead.lruNext
            lruHead.lruNext?.lruPre = node
            lruHead.lruNext = node
            currentSize++
            if (rowNode == null) {
                container[index] = node
            } else {
                node.next = rowNode
                container[index] = node
            }

            if (currentSize > maxSize) {
                // 删除尾部
                val end = lruEnd.lruPre
                end?.lruPre?.lruNext = end?.lruNext
                end?.lruNext?.lruPre = end?.lruPre
                // 删除桶中数据
                val target = findTong(end!!.key)
                removeTong(target)
                currentSize--
            }
        } else {
            // 重新赋值
            currentNode.`val` = value
            // update lru
            move2Head(currentNode)

        }

    }

    fun findTong(key: Int): Node? {
        val index = key % maxSize

        var current: Node? = container[index] ?: return null

        while (current != null) {
            if (current.key == key) {
                return current
            }
            current = current.next
        }
        return null
    }

    fun removeTong(node: Node?) {

        if (node == null) return
        val index = node.key % maxSize

        var current = container[index]

        var pre: Node? = null
        var isexist = false
        while (current != null) {
            if (current.key == node.key) {
                isexist = true
                break
            }
            pre = current
            current = current.next
        }

        if (isexist) {
            if (pre == null) {
                container[index] = null
            } else {
                pre.next = node.next
            }
        }
    }


    // 存放value的node
    class Node {

        // 桶中的
        var next: Node? = null

        var pre: Node? = null

        // 描述最新使用的

        var lruPre: Node? = null

        var lruNext: Node? = null

        var `val`: Int? = null

        var key by Delegates.notNull<Int>()
    }

}