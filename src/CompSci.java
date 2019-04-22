public class CompSci {
    public static final Requirement[] requirements = {
        new Requirement(
            "CSCE_CAROLINA_CORE_SCI", RequirementType.FOUR_OF, new String[] {
                                    "CHEM111", "CHEM111L", "CHEM112", "CHEM112L",
                                    "PHYS211", "PHYS211L", "PHYS212", "PHYS212L"}
        ),
        new Requirement(
            "CSCE_CAROLINA_CORE_ARP", RequirementType.ALL_OF,  new String[] {"MATH141", "MATH142"}
        ),
        new Requirement(
            "CSCE_GEN_ED_REQUIRED", RequirementType.ALL_OF, new String[] {"MATH241", "MATH374", "MATH344", "MATH344L", "STAT509"}
        ),
        new Requirement(
            "CSCE_GEN_ED_LAB", RequirementType.ONE_OF, new String[] {"ANTH161", "ASTR101", 
                            "BIO101", "BIO101L", "BIO110", "CHEM111", "CHEM111L",
                            "CHEM141", "ENVR101", "ENVR101L", "ENVR200", "GEOG201", "GEOG202", "GEOL101",
                            "GEOL103", "GEOL201", "GEOL215", "GEOL215L", "GEOL302", "MSCI101", "MSCI102",
                            "MSCI215", "MSCI215L", "PHYS211", "PHYS211L"}
        ),
        new Requirement(
            "CSCE_GEN_ED_LIBARTS", RequirementType.THREE_OF, new String[] {" AERO401", "AERO402", "ANTH101", 
                            "ARMY401", "ARMY402", "ARTE101", "ARTE260", 
                            "ARTH105", "ARTS103", "CHIN103", "CLAS220", "CPLT150", "CRJU101", "DANC101", "ECON123", 
                            "ENGL270", "FAMS180", "FREN109", "GEOG103", "GERM190", "HIST101", "ITAL101", "JAPA121", 
                            "LASP201", "LATN109", "LING300", "MART110", "MUSC110", "NAVY401", "NAVY402", "PHIL101", 
                            "PHIL112", "POLI101", "PORT121", "PSYC101", "RELG101", "RUSS121", "SOCY101", "SOST101", 
                            "SPAN109", "THEA170", "WGST112"}
        ),
        new Requirement(
            "CSCE_LOWER_DIV_COMPUTING", RequirementType.ALL_OF, new String[] {"CSCE145", "CSCE146", "CSCE190", 
                            "CSCE211", "CSCE212", "CSCE215", "CSCE240", "CSCE247"}
        ),
        new Requirement(
            "CSCE_REQUIRED", RequirementType.ALL_OF, new String[] {"CSCE311", "CSCE330", "CSCE350", "CSCE355", 
                            "CSCE416", "CSCE490", "CSCE492"}
        ),
        new Requirement(
            "CSCE_ELECTIVE", RequirementType.THREE_OF, new String[] {"CSCE317", "CSCE500", "CSCE699"}
        ),//9 classes from application area below
        new Requirement(
            "APPLICATION_AREA", RequirementType.NINE_OF, new String[] {"", ""}
        )

    };

    static RequirementEvaluated[] evaluate(StudentRecord sr) {
		RequirementEvaluated[] rv = new RequirementEvaluated[requirements.length];
		for (int i = 0; i < requirements.length; i++) {
			rv[i] = new RequirementEvaluated(requirements[i],sr);
		}
		return rv;
    }
    
} // Ending bracket for class CompSci