import org.example.StringCompressor
import kotlin.test.Test
import kotlin.test.assertEquals

class StringCompressorTest {
    @Test
    fun testCompressionSample() {
        val original = "AAAAABBB#####"
        val expectedCompressed = "A±5B±3#±5"
        val actualCompressed = StringCompressor.compress(original)
        assertEquals(expectedCompressed, actualCompressed)
    }

    @Test
    fun testDecompressionSample() {
        val original = "AAAAABBB#####"
        val actualCompressed = StringCompressor.compress(original)
        val decompressed = StringCompressor.decompress(actualCompressed)
        assertEquals(original, decompressed)
    }

    @Test
    fun testCompressionMultidigitsNums() {
        val original = "AAAAAAAAAABBBBBBBBBBB#####"
        val expectedCompressed = "A±10B±11#±5"
        val actualCompressed = StringCompressor.compress(original)
        assertEquals(expectedCompressed, actualCompressed)
    }

    @Test
    fun testDecompressionMultidigitsNums() {
        val original = "AAAAAAAAAABBBBBBBBBBB#####"
        val actualCompressed = StringCompressor.compress(original)
        val decompressed = StringCompressor.decompress(actualCompressed)
        assertEquals(original, decompressed)
    }

    @Test
    fun testCompressEmptyString() {
        val original = ""
        val expectedCompressed = ""
        val actualCompressed = StringCompressor.compress(original)
        assertEquals(expectedCompressed, actualCompressed)
    }

    @Test
    fun testDecompressEmptyString() {
        val original = ""
        val actualCompressed = StringCompressor.compress(original)
        val decompressed = StringCompressor.decompress(actualCompressed)
        assertEquals(original, decompressed)
    }

    @Test
    fun testCompressStringWithSeparatorsOnly() {
        val original = "±±±±±"
        val expectedCompressed = "±±5"
        val actualCompressed = StringCompressor.compress(original)
        assertEquals(expectedCompressed, actualCompressed)
    }

    @Test
    fun testDecompressStringWithSeparatorsOnly() {
        val original = "±±±±±"
        val actualCompressed = StringCompressor.compress(original)
        val decompressed = StringCompressor.decompress(actualCompressed)
        assertEquals(original, decompressed)
    }
    
    @Test
    fun testCompressInv() {
        val original = "ABC"
        val actualCompressed = StringCompressor.compress(original)
        val decompressed = StringCompressor.decompress(actualCompressed)
        println(actualCompressed)
        assertEquals(original, decompressed)
    }
}
