public class GradReqs {

	public static final Requirement[] requirements = {
		new Requirement(
			"GRAD_GPA", RequirementType.GPA_GREATER_THAN_TWO, null
		),
		new Requirement(
			"CAROLINA_CORE_CMW", RequirementType.ALL_OF, new String[] {
				"ENGL101", "ENGL102"
			}
		),
		new Requirement(
			"CAROLINA_CORE_AIU", RequirementType.ONE_OF, new String[] {
				"ARTE101", "ARTE260", "ARTH105", "ARTH106", "ARTS103",
				"ARTS104", "ARTS210", "CLAS220", "CPLT150", "CPLT270", "DANC101",
				"ENGL200", "ENGL288", "FAMS110", "FAMS180", "FAMS240", "FREN290",
				"GERM270", "GERM290", "MART110", "MART210", "MUSC110", "MUSC113",
				"MUST114", "MUSC115", "MUST140", "MUSC310", "RELG270", "RUSS280",
				"SOST101", "SPAN220", "THEA170", "THEA181", "THEA200"
			}
		),
		new Requirement(
			"CAROLINA_CORE_AIU", RequirementType.ONE_OF, new String[] {
				"FREN109", "FREN110", "GERM109", "GERM110", "LATN109", "LATN110",
				"SPAN109", "SPAN110", "ARAB121", "CHIN121", "GERM121", "GREK121", 
				"ITAL121", "JAPA121", "LATN121", "PORT121", "RUSS121", "SPAN121"
			}
		),
		new Requirement(
			"CAROLINA_CORE_GHS", RequirementType.ONE_OF, new String[] {
				"ARTH107", "FAMS300", "GERM280", "HIST101", "HIST102", "HIST103", 
				"HIST104", "HIST105", "HIST106", "HIST108", "HIST109", "HIST111", 
				"HIST112", "HIST214", "SOST302"
			}
		),
		new Requirement(
			"CAROLINA_CORE_GSS", RequirementType.ONE_OF, new String[] {
				"AFAM201", "AFAM255", "ANTH101", "ANTH102", "ANTH204", "ANTH210",
				"ANTH211", "ANTH212", "ANTH213", "ANTH244", "ANTH320", "ANTH366", 
				"ANTH371", "ANTH381", "ANTH518", "COLA298", "CRJU101", "EDEX205", 
				"EDUC360X", "GEOG103", "GEOG121", "GEOG210", "GEOG221", "GEOG223", 
				"GEOG224", "GEOG225", "GEOG226", "GEOG228", "HRTM280", "LASP331", 
				"LING101", "MUSC210", "POLI101", "POLI201", "PSYC101", "RELG101", 
				"RELG338", "SOCY201", "SOCY202", "SOCY307", "SOCY309", "SOCY310", 
				"SOCY340", "SOCY355", "SOCY561", "SOQK222", "WGST112", "WGST113", 
				"WGST210", "WGST300", "WGST381"
			}
		),
		new Requirement(
			"CAROLINA_CORE_CMS", RequirementType.ALL_OF, new String[] {"SPCH140"}
		),
		new Requirement(
			"CAROLINA_CORE_VSR", RequirementType.ALL_OF, new String[] {"CSCE390"}
		),
		new Requirement(
			"CAROLINA_CORE_INF", RequirementType.ONE_OF, new String[] {
				"ENGL102", "LIBR101", "SLIS202", "SPCH145", "STAT112"
			}
		),
		new Requirement(
			"GEN_ED_ENGL", RequirementType.ONE_OF, new String[] {
				"ENGL462", "ENGL463"
			}
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