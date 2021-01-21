/** 
 * Creates the following revision history: <pre> + rev1 (first commit with /child1) |\ | + branchRev1 (branch from rev1) | + branchRev11 (branch commit /child1/foo:1) | + rev2 (second commit with /child2) |\ | + branchRev2 (brach from rev2) </pre> The test reads /child from <code>branchRev2</code> and expects the version from the first commit.
 * @throws ParseException
 */
@Test public void isolatedBranches() throws ParseException {
  String rev1=mk.commit("","+\"/child1\":{}",null,"");
  String branchRev1=mk.branch(rev1);
  mk.commit("/child1","^\"foo\":1",branchRev1,"");
  String rev2=mk.commit("","+\"/child2\":{}",null,"");
  String branchRev2=mk.branch(rev2);
  String json=mk.getNodes("/child1",branchRev2,0,0,-1,null);
  JSONParser parser=new JSONParser();
  JSONObject obj=(JSONObject)parser.parse(json);
  assertFalse(obj.containsKey("foo"));
}
