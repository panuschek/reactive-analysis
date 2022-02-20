package de.pan.springimperative.service

import org.springframework.stereotype.Service

@Service
class MockServiceImpl : MockService {
    private var executionCounter = 0

    override fun doWork(): String {
        executionCounter++

        if(executionCounter > 1100) {
            executionCounter = 0
        }

        if(executionCounter >= 1000) {
            Thread.sleep(1500)
        }

        return "result"
    }
}