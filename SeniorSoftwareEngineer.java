public class SeniorSoftwareEngineer implements JobDescription {
    private static final String BASE_URL = "http://careers.citygrid.com/";

    private static final Gson GSON = new Gson();

    @Test
    public void verifyIndustryFacts() {
       IndustryFacts facts = fromJson(
                invokeService("facts", String.class, "type", "all"),
                IndustryFacts.class);
    
        assertEquals(facts.getPercentageOfSMBsInUS(), "95%");
        assertEquals(facts.getAllConsumerExperiences(), "LOCAL");
        assertEquals(facts.getTopLocalAdNetworkInUS(), "CITYGRID");
    }
    
    @Test
    public void verifyBusinessModel() {
        BusinessModel bizModel = fromJson(
                invokeService("about", String.class, "name", "citygridmedia"),
                BusinessModel.class);
 
        assertTrue(bizModel.isLocalContentNetwork());
        assertTrue(bizModel.isLocalAdvertisingNetwork());
        assertTrue(bizModel.links(BusinessModel.LOCAL_BUSINESSES, BusinessModel.WEB_AND_MOBILE_PUBLISHERS));
        assertEquals(bizModel.getOwnedAndOperatedProperties(), Arrays.asList("Citysearch", "InsiderPages", "UrbanSpoon"));
 
    }

    @Test
    public void verifyHandsOnSkillSet() {
        List<String> techStack = Arrays.asList(
                "Java 1.6",
                "Spring 3.1",
                "Web Services (REST, SOAP)",
                "Oracle",
                "NoSQL",
                "Scripting languages (Bash, Python etc)",
                "Algorithms and Data Structures",
                "OOA/D",
                "Big Data (Hadoop, Cascading, Coherence)");
 
        SkillSet skillset = fromJson(
                invokeService("engineering/java", String.class, "type", "ws"),
                SkillSet.class);
 
        assertEquals(skillset.getLevel(), "Senior");
        assertEquals(skillset.getPercentile(), "Top 5%");
        assertEquals(skillset.getRequiredBaseExperience(), >5 years);

    }
 
    @Test
    public void shouldAcceptCandidateWithRequiredSkills() {
        Candidate candidate = new CandidateBuilder().withTechStack("The Java ecosystem").withMentality("Hacker")
                .withLevel("Senior").withPercentile("Top 5%").favorsAgile().isCriticalThinking().build();
 
        String result = invokeService("candidate/apply", String.class, "jobId", "candidateRequest", 10003L, toJson(candidate));
 
        assertEquals(result, "200");
    }

    private <T> T invokeService(String verb, Class<T> clazz, String key, String val) {
        String fullURL = BASE_URL + verb + "/{" + key + "}";
        return new RestTemplate().getForObject(fullURL, clazz, val);
    }
    private <T> T invokeService(String verb, Class<T> clazz, String key1, String key2, String val1, String val2) {
        String fullURL = BASE_URL + verb + "/{" + key1 + "}" + "/{" + key2 + "}";
        return new RestTemplate().getForObject(fullURL, clazz, val1, val2);
    }

    private <T> T fromJson(String json, Class<T> clazz) { return GSON.fromJson(json, clazz); }
 
    private String toJson(Object o) { return GSON.toJson(o); }

//CITYGRID is an equal opportunity employer and an operating business of IAC (NASDAQ: IACI)

}