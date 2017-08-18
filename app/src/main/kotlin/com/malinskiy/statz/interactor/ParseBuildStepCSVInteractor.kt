package com.malinskiy.statz.interactor

import com.malinskiy.statz.entity.BuildStepMetric
import org.apache.commons.csv.CSVFormat
import java.io.File
import java.io.FileReader


class ParseBuildStepCSVInteractor {
    fun execute(buildId: String, gitCommitSha: String, file: File): List<BuildStepMetric> {
        val file = FileReader(file)
        val records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(file)

        val list = mutableListOf<BuildStepMetric>()
        for (record in records) {
            val metric = BuildStepMetric()
            metric.buildId = buildId
            metric.gitCommitSha = gitCommitSha
            metric.name = record.get("task")
            metric.timeMs = record.get("ms").toLong()
            metric.success = record.get("success").toBoolean()

            list.add(metric)
        }

        return list
    }
}