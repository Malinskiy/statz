package com.malinskiy.statz.mapper

import com.malinskiy.statz.entity.TestFileMetric
import org.apache.maven.plugins.surefire.report.ReportTestSuite

class TestFileMapper(private val buildId: String, private val gitCommitSha: String) : Mapper<ReportTestSuite, TestFileMetric> {

    val mapper = TestCaseMapper(buildId = buildId, gitCommitSha = gitCommitSha)

    override fun map(input: ReportTestSuite): TestFileMetric {

        val metric = TestFileMetric()

        metric.buildId = buildId
        metric.gitCommitSha = gitCommitSha

        metric.fileName = input.fullClassName
        metric.success = input.numberOfFailures == 0
        metric.time = input.timeElapsed.toDouble()
        metric.cases = input.testCases.map { mapper.map(it) }.toMutableList()

        return metric
    }
}