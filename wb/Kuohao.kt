package com.example.lc

import java.util.*
import kotlin.properties.Delegates

/**
 * @ClassName: Kuohao
 * @Description: //TODO
 * @Author: wangbin
 * @Date: 11/11/21
 */

fun main() {
    println(generateParenthesis(3))
}

val result = mutableListOf<String>()

var total by Delegates.notNull<Int>()

// val path = mutableListOf<String>()

fun generateParenthesis(n: Int): List<String> {

    total = n

    if(n == 0)
        return result

    dfs("", 0, 0)

    return result
}


/**
 * 路径，当前树高，已经使用的左括号，已经使用的右括号
 */
fun dfs(path: String, leftUse: Int, rightUse: Int) {

    // 到底了
    if (leftUse  == total && total == rightUse) {
        result.add(path.fold("") { a, b ->
            a + b
        })

        return
    }

    if (rightUse > leftUse) {
        return
    }

    // 还有左括号可以用
    if (leftUse < total) {
        dfs("$path(", leftUse + 1, rightUse)
    }

    if (rightUse < total) {
        dfs("$path)", leftUse, rightUse + 1)
    }


}