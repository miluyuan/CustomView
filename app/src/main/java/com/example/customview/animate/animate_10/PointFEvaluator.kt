/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.customview.animate.animate_10

import android.animation.TypeEvaluator
import android.graphics.PointF

/**
 * This evaluator can be used to perform type interpolation between `PointF` values.
 */
class PointFEvaluator : TypeEvaluator<PointF> {

    private var mPoint: PointF = PointF()
    private var angle: Float = 0f

    constructor() {

    }

    constructor(angle: Float) {
        this.angle = angle
    }

    override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
        val x = startValue.x + fraction * (endValue.x - startValue.x)
        val y = startValue.y + fraction * (endValue.y - startValue.y)

        mPoint.set(x, y)

        return mPoint
    }
}
