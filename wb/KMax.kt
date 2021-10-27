package com.example

import java.util.*

/**
 * @ClassName: KMax
 * @Description: //TODO
 * @Author: wangbin
 * @Date: 10/27/21
 */
class KMax {


    /**
     * 第k大的数
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {


        // 优先级队列
        val queue = PriorityQueue<Int>()

        for (num in nums) {
            // 先填满
            if(queue.size < k){
                queue.add(num)
                continue
            }
            if(queue.peek() < num){
                queue.poll()
                queue.add(num)
            }
        }

        return queue.peek()

    }
}