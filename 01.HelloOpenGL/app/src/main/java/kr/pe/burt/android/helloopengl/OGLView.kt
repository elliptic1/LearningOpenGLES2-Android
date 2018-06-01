package kr.pe.burt.android.helloopengl

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet

/**
 * Created by burt on 2016. 5. 3..
 */
class OGLView : GLSurfaceView {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        // use opengl es 2.0
        setEGLContextClientVersion(2)

        // store opengl context
        preserveEGLContextOnPause = true

        // set renderer
        setRenderer(OGLRenderer())
    }
}
