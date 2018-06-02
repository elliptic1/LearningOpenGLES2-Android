package kr.pe.burt.android.square.glkit

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.CharBuffer
import java.nio.DoubleBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer
import java.nio.ShortBuffer

/**
 * Created by burt on 2016. 5. 11..
 */
object BufferUtils {

    fun newFloatBuffer(numFloats: Int): FloatBuffer {
        val buffer = ByteBuffer.allocateDirect(numFloats * 4)
        buffer.order(ByteOrder.nativeOrder())
        return buffer.asFloatBuffer()
    }

    fun newDoubleBuffer(numDoubles: Int): DoubleBuffer {
        val buffer = ByteBuffer.allocateDirect(numDoubles * 8)
        buffer.order(ByteOrder.nativeOrder())
        return buffer.asDoubleBuffer()
    }

    fun newByteBuffer(numBytes: Int): ByteBuffer {
        val buffer = ByteBuffer.allocateDirect(numBytes)
        buffer.order(ByteOrder.nativeOrder())
        return buffer
    }

    fun newShortBuffer(numShorts: Int): ShortBuffer {
        val buffer = ByteBuffer.allocateDirect(numShorts * 2)
        buffer.order(ByteOrder.nativeOrder())
        return buffer.asShortBuffer()
    }

    fun newCharBuffer(numChars: Int): CharBuffer {
        val buffer = ByteBuffer.allocateDirect(numChars * 2)
        buffer.order(ByteOrder.nativeOrder())
        return buffer.asCharBuffer()
    }

    fun newIntBuffer(numInts: Int): IntBuffer {
        val buffer = ByteBuffer.allocate(numInts * 4)
        buffer.order(ByteOrder.nativeOrder())
        return buffer.asIntBuffer()
    }

    fun newLongBuffer(numLongs: Int): LongBuffer {
        val buffer = ByteBuffer.allocate(numLongs * 8)
        buffer.order(ByteOrder.nativeOrder())
        return buffer.asLongBuffer()
    }
}
