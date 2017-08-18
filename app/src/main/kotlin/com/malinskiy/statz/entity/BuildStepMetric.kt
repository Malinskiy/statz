package com.malinskiy.statz.entity

import com.malinskiy.statz.entity.base.CommitMetric
import com.malinskiy.statz.extensions.parse
import kotlin.properties.Delegates

class BuildStepMetric : CommitMetric(BuildStepMetric::class.simpleName) {
    var name: String by Delegates.parse()
    var timeMs: Long by Delegates.parse()
    var success: Boolean by Delegates.parse()
}