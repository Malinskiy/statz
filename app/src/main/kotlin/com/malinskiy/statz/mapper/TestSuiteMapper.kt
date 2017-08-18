package com.malinskiy.statz.mapper

import com.malinskiy.statz.entity.TestSuiteMetric
import org.apache.maven.plugins.surefire.report.ReportTestSuite

class TestSuiteMapper(
        val suiteName: String,
        val buildId: String,
        val gitCommitSha: String) : Mapper<List<ReportTestSuite>, TestSuiteMetric> {

    val fileMapper = TestFileMapper(buildId = buildId, gitCommitSha = gitCommitSha)

    override fun map(input: List<ReportTestSuite>): TestSuiteMetric {


        val metric = TestSuiteMetric()

        metric.buildId = buildId
        metric.gitCommitSha = gitCommitSha

        metric.suiteName = suiteName
        metric.success = input.map { it.numberOfFailures }.reduce { acc, i -> acc + i } == 0
        metric.time = input.map { it.timeElapsed }.reduce { acc, fl -> acc + fl }.toDouble()
        metric.cases = input.map { fileMapper.map(it) }.toMutableList()

        return metric
    }
}