package com.malinskiy.statz.interactor

import com.malinskiy.statz.entity.BuildStepMetric
import org.parse4j.ParseQuery

class QueryBuildStepMetric(val buildId: String = "", val gitCommitSha: String = "") {
    fun execute(): List<BuildStepMetric> {
        var query = ParseQuery.getQuery(BuildStepMetric::class.java)

        if (!buildId.isNullOrEmpty()) query = query.whereEqualTo(BuildStepMetric::buildId.name, buildId)
        if (gitCommitSha.isNullOrEmpty()) query = query.whereEqualTo(BuildStepMetric::gitCommitSha.name, gitCommitSha)

        return query.find() ?: emptyList<BuildStepMetric>()
    }
}