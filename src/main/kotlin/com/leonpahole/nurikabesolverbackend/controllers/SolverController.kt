package com.leonpahole.nurikabesolverbackend.controllers

import Matrix
import NurikabeField
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class SolveRequest(
        val data: Array<Array<Int>>
)

data class SolveResponse(
        val solution: Array<Array<Boolean>>,
        val data: Array<Array<Int>>,
        val elapsedTime: Long
)


@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/solve")
class SolverController {

    @PostMapping
    fun solve(@RequestBody request: SolveRequest): ResponseEntity<SolveResponse> {

        val start = System.currentTimeMillis()
        val grid = NurikabeField(Matrix(request.data))
        val solution = grid.solve()
        val elapsedTimeInMs = System.currentTimeMillis() - start
        return ResponseEntity.status(HttpStatus.OK).body(SolveResponse(solution = solution.data, data = request.data, elapsedTime = elapsedTimeInMs))
    }

}