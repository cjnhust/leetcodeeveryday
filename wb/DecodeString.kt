package lc

import java.util.*

/**
 * @Description TODO

 * @Date 2021/11/10 下午11:50
 * @Created by wangbin
 */


fun decodeString(s: String): String {
    var sb = ""
    var num = 0
    val stack_1 = LinkedList<Int>()

    val stack_2 = LinkedList<String>()

    s.toCharArray().forEach {
        when (it) {
            '[' -> {
                stack_1.push(num)
                stack_2.push(sb)
                num = 0
                sb = ""
            }

            ']' -> {
                var temp = ""
                val cur = stack_1.pop()
                for (i in 0 until cur) {
                    temp+= sb
                }
                sb = stack_2.pop() + temp
            }

            in '0'..'9' -> {

                num = num * 10 + (it+"").toInt()

            }

            else -> sb += it

        }
    }

    return sb

}