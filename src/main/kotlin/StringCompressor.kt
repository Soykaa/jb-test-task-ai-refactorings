package org.example

class StringCompressor {
    companion object {
        fun compress(input: String): String {
            if (input.isEmpty()) return ""

            val compressedStringBuilder = StringBuilder()
            var currentChar = input[0]
            var counter = 1

            for (i in 1 until input.length) {
                when (currentChar) {
                    input[i] -> {
                        counter++
                    }

                    else -> {
                        compressedStringBuilder.append(currentChar).append("±").append(counter)
                        currentChar = input[i]
                        counter = 1
                    }
                }
            }
            compressedStringBuilder.append(currentChar).append("±").append(counter)
            return compressedStringBuilder.toString()
        }

        fun decompress(input: String): String {
            if (input.isEmpty())
                return ""

            val decompressedStringBuilder = StringBuilder()
            val segments = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)".toRegex())

            for (i in segments.indices step 2) {
                val char = segments[i][0]
                val counter = segments[i + 1].toInt()
                if (counter > 0) {
                    decompressedStringBuilder.append(char.toString().repeat(counter))
                } else {
                    throw IllegalArgumentException("Invalid counter in decompressed data: $counter")
                }
            }
            return decompressedStringBuilder.toString()
        }
    }
}