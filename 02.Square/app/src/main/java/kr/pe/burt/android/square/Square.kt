package kr.pe.burt.android.square

import android.content.Context
import android.opengl.GLES20

import java.nio.FloatBuffer
import java.nio.IntBuffer

import kr.pe.burt.android.square.glkit.BufferUtils
import kr.pe.burt.android.square.glkit.ShaderProgram
import kr.pe.burt.android.square.glkit.ShaderUtils

/**
 * code from the url at { @link https://developer.android.com/training/graphics/opengl/shapes.html }
 * Created by burt on 2016. 6. 16..
 */
class Square(context: Context) {

    private lateinit var vertexBuffer: FloatBuffer
    private lateinit var shader: ShaderProgram
    private var vertexBufferId: Int = 0
    private var vertexCount: Int = 0
    private var vertexStride: Int = 0

    init {
        setupShader(context)
        setupVertexBuffer()
    }

    private fun setupShader(context: Context) {
        // compile & link shader
        shader = ShaderProgram(
                ShaderUtils.readShaderFileFromRawResource(context, R.raw.simple_vertex_shader),
                ShaderUtils.readShaderFileFromRawResource(context, R.raw.simple_fragment_shader)
        )
    }

    private fun setupVertexBuffer() {
        // initialize vertex float buffer for shape coordinates
        vertexBuffer = BufferUtils.newFloatBuffer(squareCoords.size)

        // add the coordinates to the FloatBuffer
        vertexBuffer.put(squareCoords)

        // set the buffer to read the first coordinate
        vertexBuffer.position(0)


        //copy vertices from cpu to the gpu
        val buffer = IntBuffer.allocate(1)
        GLES20.glGenBuffers(1, buffer)
        vertexBufferId = buffer.get(0)
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vertexBufferId)
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, squareCoords.size * 4, vertexBuffer, GLES20.GL_STATIC_DRAW)

        vertexCount = squareCoords.size / COORDS_PER_VERTEX
        vertexStride = COORDS_PER_VERTEX * 4 // 4 bytes per vertex
    }

    fun draw() {

        shader.begin()

        shader.enableVertexAttribute("a_Position")
        shader.setVertexAttribute("a_Position", COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, vertexStride, 0)

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vertexBufferId)
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount)

        shader.disableVertexAttribute("a_Position")

        shader.end()
    }

    companion object {

        // number of coordinates per vertex in this array
        internal val COORDS_PER_VERTEX = 3
        internal val squareCoords = floatArrayOf(-0.5f, 0.5f, 0.0f, // top left
                -0.5f, -0.5f, 0.0f, // bottom left
                0.5f, -0.5f, 0.0f, // bottom right

                -0.5f, 0.5f, 0.0f, // top left
                0.5f, -0.5f, 0.0f, // bottom right
                0.5f, 0.5f, 0.0f    // top right
        )
    }
}
