package com.malinskiy.statz.interactor

import com.malinskiy.statz.entity.TestSuiteMetric
import com.malinskiy.statz.mapper.TestCaseMapper
import com.malinskiy.statz.mapper.TestFileMapper
import com.malinskiy.statz.mapper.TestSuiteMapper
import org.apache.maven.plugin.surefire.log.api.NullConsoleLogger
import org.apache.maven.plugins.surefire.report.SurefireReportParser
import java.io.File
import java.util.*

class ParseJUnitXMLInteractor(buildId: String, gitCommitSha: String, private val dir: File) {

    val suiteMapper = TestSuiteMapper(suiteName = buildId, buildId = gitCommitSha, gitCommitSha = gitCommitSha)

    fun execute(): TestSuiteMetric {
        if (!dir.isDirectory) throw IllegalArgumentException("Passed $dir. This should be the folder with junit output")

        val parser = SurefireReportParser(listOf(dir), Locale.ENGLISH, NullConsoleLogger())
        val xmlReportFiles = parser.parseXMLReportFiles()

        return suiteMapper.map(xmlReportFiles)
    }
}