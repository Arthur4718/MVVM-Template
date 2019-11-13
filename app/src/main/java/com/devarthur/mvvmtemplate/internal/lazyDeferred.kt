package com.devarthur.mvvmtemplate.internal

import kotlinx.coroutines.*

//* Created by Arthur Gomes at 2019-11-12 21:45 - contact me at devarthur4718@gmail.com.br
fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}