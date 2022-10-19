package com.example.quizze

object setData {

    fun getQuestion(): ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = arrayListOf()

        var question1 = QuestionData(
            "what is the capital of India",
            1,
            "Shimla",
            "Chandigarh",
            "Kanpur",
            "Delhi",
            4
        )
        var question2 = QuestionData(
            "who was the first indian women in space",
            2,
            "kalpana chawla",
            "Sunita Williams",
            "Koneru humpy",
            "None of the above",
            1
        )
        var question3 = QuestionData(
            "who was the first president of india",
            3,
            "Abdul kalam",
            "lal Bahadur Shastri",
            "Dr.Rajendra prasad",
            "Zakir hussain",
            3
        )
        var question4 = QuestionData(
            "Who built Jama Masjid",
            4,
            "Jahangir",
            "Akbar",
            "Imam Bukhari",
            "shah Jahan",
            4
        )
        var question5 = QuestionData(
            "who Wrote the national anthem",
            5,
            "Bakim Chandra Chatterji",
            "Rabindra nath tagore",
            "Swami Vivekanand",
            "none of the above",
            2
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que


    }
}