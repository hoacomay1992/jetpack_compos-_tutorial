package cmc.com.jpackcomponentcomposetutorial

class SampleData {
    companion object {
        val conversationSample: List<Message> = listOf(
            Message("CMC", "Chào các bạn mình là công ty CMC"),
            Message("FPT", "Chào các bạn mình là FPT"),
            Message(
                "VIN", "Chào các bạn mình là VIN Group\n" +
                        "\t\t\tAndroid version 1 bản phát hành đầu tiên\n" +
                        "\t\t\tAndroid version 2 bản phát hành 2\n" +
                        "\t\t\tAndroid version 3 bản phát hành 3\n" +
                        "\t\t\tAndroid version 4 bản phát hành 4\n" +
                        "\t\t\tAndroid version 5 bản phát hành 5\n" +
                        "\t\t\tAndroid version 6 bản phát hành 6\n" +
                        "\t\t\tAndroid version 7 bản phát hành 7"
            ),
            Message("VNPT", "Mình là VNPT mình là nhân viên mới"),
            Message("Viettel", "Mình là Viettel mình mới gia nhập nhóm")
        )
    }

}