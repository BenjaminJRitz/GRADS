public class CompInfo {
    
    public static final Requirement[] requirements = {
        new Requirement(
            "CIS_CAROLINA_CORE_ARP", RequirementType.TWO_OF, new String[] {"CSCE145", "MATH122", "MATH141"}
        ),
        new Requirement(
            "CIS_CAROLINA_CORE_SCI", RequirementType.TWO_OF, new String[] {"BIOL101", "BIOL101L", "BIOL102", "BIOL102L", "BIOL120", "BIOL120L", 
                                        "BIOL243", "BIOL242L", "BIOL244", "BIOL244L", "BIOL270", "BIOL270L", "CHEM111", 
                                        "CHEM111L", "CHEM112", "CHEM112L", "GEOL215", "GEOL215L", "MSCI210", "MSCI210L", 
                                        "MCSI215", "MCSI215L", "PHYS201", "PHYS201L", "PHYS202", "PHYS202L", "PHYS211", 
                                        "PHYS211L", "PHYS212", "PHYS212L"}
        ),
        new Requirement(
                "CIS_GEN_ED_MATH", RequirementType.THREE_OF, new String[] {"Math174", "MATH374", "STAT509", "STAT515", "STAT516"}
        ),
        new Requirement(
                "CIS_GEN_ED_LIBARTS", RequirementType.THREE_OF, new String[] {" AERO401", "AERO402", "ANTH101", "ANTH499", "ARMY401", "ARMY402", "ARTE101", "ARTE260", 
                                        "ARTH105", "ARTH366", "ARTS103", "ARTS261", "CHIN103", "CHIN550", "CLAS220", "CLAS598",  "CPLT150", "CPLT597", "CRJU101", "CRJU494", "DANC101", "DANC381", "ECON123", "ECON499", 
                                        "ENGL270", "ENGL499", "FAMS180", "FAMS597", "FREN109", "FREN615", "GEOG103", "GEOG595", "GERM190", "GERM615", "HIST101", "HIST692", "ITAL101", "ITAL615", "JAPA121", "JAPA500", 
                                        "LASP201", "LASP451", "LATN109", "LATN615", "LING300", "LING600", "MART110", "MART341", "MUSC110", "MUSC140", "NAVY401", "NAVY402", "PHIL101", "PHIL109",
                                        "PHIL112", "PHIL598", "POLI101", "POLI499", "PORT121", "PORT615", "PSYC101", "PSYC499", "RELG101", "RELG552", "RUSS121", "RUSS616", "SOCY101", "SOCY499", "SOST101", "SOST500",
                                        "SPAN109", "SPAN615", "THEA170", "THEA565", "WGST112", "WGST555"}
        ),
        new Requirement(
                "CIS_LOWER_DIV_COMPUTING", RequirementType.ALL_OF, new String[] {"CSCE146", "CSCE190", "CSCE201", "CSCE210", "CSCE215", "CSCE240"}
        ),
        new Requirement(
                "CIS_REQUIRED", RequirementType.ALL_OF, new String[] {"CSCE205", "CSCE311", "CSCE350", "CSCE416", "CSCE490", "CSCE492", "CSCE520", "CSCE522"}
        ),
        new Requirement(
                "CIS_ELECTIVE", RequirementType.ONE_OF, new String[] {"CSCE317", "CSCE500", "CSCE699"}
        ),
        new Requirement(
                "CIS_BIM_REQUIRED", RequirementType.ONE_OF, new String[] {"ECON224", "ACCT222", "MGMT371", "MDSC390", "MGSC490", "MGSC590"}
        ),
        new Requirement(
                "CIS_BIM_ELECTIVE", RequirementType.TWO_OF, new String[] {"ACCT324", "ECON311", "ECON379", "FINA333", "IBUS301", "MGMT472", "MKTG350", "MKTG351", "MGSC392", "MGSC395", "MGSC594"}
        )
    };
}  // Ending bracket for class CompInfo