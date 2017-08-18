package com.malinskiy.statz.interactor

import com.malinskiy.statz.entity.TestSuiteMetric
import org.parse4j.ParseQuery

class QueryTestsInteractor(val buildId: String = "", val gitCommitSha: String = "") {
    fun execute(): List<TestSuiteMetric> {
        var query = ParseQuery.getQuery(TestSuiteMetric::class.java)

        if (!buildId.isNullOrEmpty()) query = query.whereEqualTo(TestSuiteMetric::buildId.name, buildId)
        if (!gitCommitSha.isNullOrEmpty()) query = query.whereEqualTo(TestSuiteMetric::gitCommitSha.name, gitCommitSha)

        return query.find().toList<TestSuiteMetric>()
    }
}