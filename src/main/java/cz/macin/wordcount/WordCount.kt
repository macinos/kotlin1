package cz.macin.wordcount

import de.m3y.kformat.Table
import de.m3y.kformat.table
import edu.stanford.nlp.simple.Sentence
import java.io.File
import java.lang.StringBuilder
import java.net.URL


class WordCount {

    //https://stackoverflow.com/questions/1833252/java-stanford-nlp-part-of-speech-labels
    private val NOUN_PREFIX = "NN"
    private val VERB_PREFIX = "VB"
    private val EXCLUDED_VERBS = setOf("is", "be", "are", "'s", "'m", "do", "'re", "was", "let", "got", "has", "were", "been", "have", "'ve", "do")
    private val MAX_WORDS_IN_TABLE = 30

    fun countWordsInFiles(wordFileName: String) {
        val resource: URL = WordCount::class.java.getResource(wordFileName)!!
        val file = File(resource.toURI())

        val totalWordCount = findWordsWithCountInFile(file)

        val totalWordCountOrderedDesc: List<Pair<String, Int>> = totalWordCount.toList()
            .sortedByDescending { pair -> pair.second }

        val orderedWordTable = table {
            header("Order", "Word", "Count")

            totalWordCountOrderedDesc.forEachIndexed { index, pair ->
                if (index+1 > MAX_WORDS_IN_TABLE) {
                    return@forEachIndexed
                }
                row(index+1, pair.first, pair.second)
            }

            hints {
                borderStyle = Table.BorderStyle.SINGLE_LINE
            }
        }.render(StringBuilder())

        println(orderedWordTable)
    }

    private fun findWordsWithCountInFile(file: File): HashMap<String, Int> {
        val totalWordCount = HashMap<String, Int>()
        var linesProcessed = 0

        file.forEachLine { line ->
            // only non-empty lines
            linesProcessed++
            if (linesProcessed.mod(100) == 0) println("$linesProcessed lines processed from the file")
            if (line.trim().isEmpty()) return@forEachLine

            val sentence = Sentence(line)
            val wantedWordsInSentence = arrayListOf<String>()

            // get nouns from the sentence
            sentence.tokens().forEach { token ->
                val posTag = sentence.posTags()[token.index()]
                if (posTag.startsWith(NOUN_PREFIX) || posTag.startsWith(VERB_PREFIX)) {
                    val word = token.originalText()
                    if (!EXCLUDED_VERBS.contains(word)) {
                        wantedWordsInSentence.add(word.lowercase())
                    }
                }
            }

            wantedWordsInSentence.groupingBy { word -> word }
                .eachCountTo(totalWordCount)
        }
        return totalWordCount
    }
}

fun main(args: Array<String>) {
//    WordCount().countWordsInFiles("/manowar-lyrics.txt")
//    WordCount().countWordsInFiles("/sabaton-lyrics.txt")
    WordCount().countWordsInFiles("/blink182-lyrics.txt")
}