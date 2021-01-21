/** 
 * OAK-1208 property existence constraints break queries
 */
@Test public void testOAK1208() throws Exception {
  Tree t=root.getTree("/").addChild("containsWithMultipleOr");
  Tree one=t.addChild("one");
  one.setProperty("p","dam/smartcollection");
  one.setProperty("t","media");
  Tree two=t.addChild("two");
  two.setProperty("p","dam/collection");
  two.setProperty("t","media");
  Tree three=t.addChild("three");
  three.setProperty("p","dam/hits");
  three.setProperty("t","media");
  root.commit();
  StringBuffer stmt=new StringBuffer();
  stmt.append("//*[jcr:contains(., 'media') and (@p = 'dam/smartcollection' or @p = 'dam/collection') ]");
  assertQuery(stmt.toString(),"xpath",ImmutableList.of(one.getPath(),two.getPath()));
}
