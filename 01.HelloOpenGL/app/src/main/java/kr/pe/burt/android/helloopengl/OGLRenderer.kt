package kr.pe.burt.android.helloopengl

import android.opengl.GLES20
import android.opengl.GLSurfaceView

import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Created by burt on 2016. 5. 3..
 */
class OGLRenderer : GLSurfaceView.Renderer {

    override fun onSurfaceCreated(gl10: GL10, eglConfig: EGLConfig) {
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f)
    }

    override fun onSurfaceChanged(gl10: GL10, i: Int, i1: Int) {

    }

    override fun onDrawFrame(gl10: GL10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
    }
}
