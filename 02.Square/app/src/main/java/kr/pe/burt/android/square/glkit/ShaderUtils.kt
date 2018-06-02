package kr.pe.burt.android.square.glkit

import android.content.Context
import android.content.res.AssetManager

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Scanner

/**
 * Created by burt on 2016. 6. 15..
 */
object ShaderUtils {

    fun readShaderFileFromRawResource(context: Context, resourceId: Int): String? {
        val inputStream = context.resources.openRawResource(resourceId)
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)

        var nextLine: String?
        val body = StringBuilder()

        try {
            nextLine = bufferedReader.readLine()
            while (nextLine != null) {
                body.append(nextLine)
                body.append("\n")
                nextLine = bufferedReader.readLine()
            }
        } catch (e: IOException) {
            return null
        }

        return body.toString()
    }

    fun readShaderFileFromFilePath(context: Context, filePath: String): String {
        try {
            val assetManager = context.assets
            val ims = assetManager.open(filePath)

            val re = convertStreamToString(ims)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    private fun convertStreamToString(`is`: InputStream): String {
        val s = Scanner(`is`).useDelimiter("\\A")
        return if (s.hasNext()) s.next() else ""
    }
}
