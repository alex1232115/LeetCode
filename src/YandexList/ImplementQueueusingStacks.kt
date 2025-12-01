package YandexList

import java.util.*

class MyQueue() {
    private val stack1: Stack<Int> = Stack<Int>()
    private val stack2: Stack<Int> = Stack<Int>()


    fun push(x: Int) {
        stack1.push(x)
    }

    fun pop(): Int {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.pop()
    }

    fun peek(): Int {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.peek()
    }

    fun empty(): Boolean {
        return stack1.empty() && stack2.empty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */