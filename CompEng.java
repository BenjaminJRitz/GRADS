public class CompEng {

    public static final Requirement[] requirements = {
        new Requirement(
            "CSCE_CAROLINA_CORE_SCI", RequirementType.ALL_OF, new String[] {"CHEM111", "CHEM111L", "PHYS211", "PHYS211L"}
        ),
        new Requirement(
            "CSCE_CAROLINA_CORE_ARP", RequirementType.ALL_OF, new String[] {"MATH141", "MATH142"}
        ),
        new Requirement(
            "CSCE_GEN_ED_REQUIRED", RequirementType.ALL_OF, new String[] {"MATH241", "MATH242", "MATH374", 
                            "MATH344", "MATH344L", "PHYS212", "PHYS212L", "STAT509"}
        ),
        new Requirement(
            "CSCE_LOWER_DIV_COMPUTING", RequirementType.ALL_OF, new String[] {"CSCE145", "CSCE146", "CSCE190", 
                            "CSCE211", "CSCE212", "CSCE215", "CSCE240", "CSCE247"}
        ),
        new Requirement(
            "CPE_REQUIRED", RequirementType.ALL_OF, new String[] {"CSCE311", "CSCE313", "CSCE317", "CSCE250", 
                            "CSCE416", "CSCE490", "CSCE492", "CSCE611"}
        ),
        new Requirement(
            "CPE_ELECTIVE", RequirementType.THREE_OF, new String[] {"CSCE330", "CSCE355", "ELCT321", "ELCT331", 
                            "CSCE510", "CSCE699"}
        ),
        new Requirement(
            "CPE_EE", RequirementType.THREE_OF, new String[] {"ELCT101", "ELCT221", "ELCT222", "ELCT371"}
        )
    };

    static RequirementEvaluated[] evaluate(StudentRecord sr) {
		RequirementEvaluated[] rv = new RequirementEvaluated[requirements.length];
		for (int i = 0; i < requirements.length; i++) {
			rv[i] = new RequirementEvaluated(requirements[i],sr);
		}
		return rv;
    }
    
}