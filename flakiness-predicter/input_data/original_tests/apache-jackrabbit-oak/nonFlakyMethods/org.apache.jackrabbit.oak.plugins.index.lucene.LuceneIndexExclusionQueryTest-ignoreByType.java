@Test public void ignoreByType() throws Exception {
  Tree content=root.getTree("/").addChild("content");
  Tree one=content.addChild("one");
  one.setProperty(JCR_PRIMARYTYPE,NT_UNSTRUCTURED);
  one.setProperty(JCR_LASTMODIFIED,"2013-04-01T09:58:03.231Z",DATE);
  one.setProperty("jcr:title","abc");
  Tree two=content.addChild("two");
  two.setProperty(JCR_PRIMARYTYPE,NT_UNSTRUCTURED);
  two.setProperty(JCR_LASTMODIFIED,"2014-04-01T09:58:03.231Z",DATE);
  two.setProperty("jcr:title","abc");
  root.commit();
  String query="/jcr:root/content//*[jcr:contains(., 'abc' )" + " and (@" + JCR_LASTMODIFIED + " > xs:dateTime('2014-04-01T08:58:03.231Z')) ]";
  assertQuery(query,"xpath",of("/content/two"));
}
