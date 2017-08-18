package com.malinskiy.statz.mapper

import com.malinskiy.statz.entity.TestCaseMetric
import org.apache.maven.plugins.surefire.report.ReportTestCase

class TestCaseMapper(private val buildId: String, private val gitCommitSha: String) : Mapper<ReportTestCase, TestCaseMetric> {
    override fun map(testCase: ReportTestCase): TestCaseMetric {

        var metric = TestCaseMetric()

        metric.buildId = buildId
        metric.gitCommitSha = gitCommitSha

        metric.name = "${testCase.fullName}"
        metric.success = !testCase.hasFailure()
        if (!metric.success) {
            metric.failureMessage = testCase.failureMessage ?: ""
            metric.failureStackTrace = testCase.failureDetail ?: ""
        }
        metric.time = testCase.time.toDouble()

        return metric
    }
}