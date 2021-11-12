package com.example.lc

import java.util.*


/**
 * @ClassName: SplitWord
 * @Description: //TODO
 * @Author: wangbin
 * @Date: 11/12/21
 */


fun main() {
    val s = "catsandog"
    val ss = arrayOf("cats", "dog", "sand", "and", "cat").toList()
    println(wordBreak(s, ss))
}

// DP
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    var maxWordLength = 0
    val wordSet: MutableSet<String> = HashSet(wordDict.size)
    for (word in wordDict) {
        wordSet.add(word)
        if (word.length > maxWordLength) {
            maxWordLength = word.length
        }
    }
    val dp = BooleanArray(s.length + 1)
    dp[0] = true
    for (i in 1 until dp.size) {
        for (j in (if (i - maxWordLength < 0) 0 else i - maxWordLength) until i) {
            if (dp[j] && wordSet.contains(s.substring(j, i))) {
                dp[i] = true
                break
            }
        }
    }
    return dp[dp.size - 1]
}
