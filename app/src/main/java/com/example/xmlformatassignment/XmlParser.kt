package com.example.xmlformatassignment

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlParser {
    private val students = ArrayList<Student>()
    private var text = ""

    private var id = 0
    private var name = ""
    private var grade = 0f

    fun parse(inputStream: InputStream): ArrayList<Student>{
        try{
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while(eventType != XmlPullParser.END_DOCUMENT){
                val tagName = parser.name
                when(eventType){
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id", true) -> id = text.toInt()
                        tagName.equals("name", true) -> name = text
                        tagName.equals("grade", true) -> {
                            grade = text.toFloat()
                            students.add(Student(id, name, grade))
                        }
                        else -> {}
                    }
                    else -> {}
                }
                eventType = parser.next()
            }
        }catch(e: XmlPullParserException){
            e.printStackTrace()
        }catch(e: IOException){
            e.printStackTrace()
        }
        return students
    }
}