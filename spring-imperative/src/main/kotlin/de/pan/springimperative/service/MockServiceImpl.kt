package de.pan.springimperative.service

import org.springframework.stereotype.Service

@Service
class MockServiceImpl : MockService {
    private var executionCounter = 0

    override fun doWork(): String {
        executionCounter++

        if(executionCounter in 1001..1099) {
            Thread.sleep(1500)
        }

        return "result"
    }
}