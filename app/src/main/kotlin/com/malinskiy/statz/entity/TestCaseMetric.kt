package com.malinskiy.statz.entity

import com.malinskiy.statz.entity.base.CommitMetric
import com.malinskiy.statz.extensions.parse
import kotlin.properties.Delegates

class TestCaseMetric : CommitMetric(TestCaseMetric::class.simpleName) {
    var name: String by Delegates.parse()
    var success: Boolean by Delegates.parse()
    var failureMessage: String? by Delegates.parse()
    var failureStackTrace: String? by Delegates.parse()
    var coverage: Double by Delegates.parse()
    var time: Double by Delegates.parse()
}