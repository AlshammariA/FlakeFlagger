@Test public void ignoreByName() throws Exception {
  final List<String> expected=of("/content/two");
  Tree content=root.getTree("/").addChild("content");
  Tree one=content.addChild("one");
  one.setProperty(JCR_PRIMARYTYPE,NT_UNSTRUCTURED);
  one.setProperty("jcr:title","abc");
  one.setProperty(NOT_IN,"azerty");
  Tree two=content.addChild("two");
  two.setProperty(JCR_PRIMARYTYPE,NT_UNSTRUCTURED);
  two.setProperty("jcr:title","abc");
  two.setProperty(NOT_IN,"querty");
  root.commit();
  String query="/jcr:root/content//*[jcr:contains(., 'abc' )" + " and (@" + NOT_IN + " = 'querty') ]";
  assertQuery(query,"xpath",expected);
}
