package Data

object Data {
    val database = mapOf<String, Properties>(
        "motorizedRegimentLeader" to Properties(150.0, "Командир мотострелкового полка"),
        "motorizedBattalionLeader" to Properties(150.0, "Командир мотострелкового батальона"),
        "motorizedCompanyLeader" to Properties(150.0, "Командир мотострелковой роты"),
        "motorizedPlatoonLeader" to Properties(140.0, "Командир мотосрелкового взвода"),
        "motorizedSquadLeader" to Properties(130.0, "Командир мотосрелкового отделения"),

        "tankRegimentLeader" to Properties(150.0, "Командир танкового полка"),
        "tankBattalionLeader" to Properties(145.0, "Командир танкового батальона"),
        "tankCompanyLeader" to Properties(145.0, "Командир танковой роты"),
        "tankPlatoonLeader" to Properties(135.0, "Командир танкового взвода"),
        "tankCommander" to Properties(125.0, "Командир танка"),
        //
        "deputyCompanyLeader" to Properties(145.0, "Заместитель командира роты"),
        //
        "driverMechanic" to Properties(50.0, "Механик-водитель"),
        "gunnerOperator" to Properties(80.0, "Наводчик-оператор"),
        "seniorRifleman" to Properties(120.0, "Старший стрелок"),
        "machineGunner" to Properties(250.0, "Пулемётчик"),
        "grenadeLauncher" to Properties(300.0, "Гранатомётчик"),
        "grenadeLauncherAssistant" to Properties(90.0, "Стрелок-помочник гранатомётчика"),
        "rifleman" to Properties(100.0, "Стрелок"),
        //
        "BMP_3" to Properties(1200.0, "БМП-3"),
        "T_72B3" to Properties(3000.0, "Т-72Б3"),
    )
    val name = listOf<String>(
        "Иван",
        "Пётр",
        "Сидор",
        "Василий",
    )
    val surname = listOf<String>(
        "Иванов",
        "Петров",
        "Сидоров",
        "Васильев",
    )
    val patronymic = listOf<String>(
        "Иванович",
        "Петрович",
        "Сидорович",
        "Васильевич",
    )
}