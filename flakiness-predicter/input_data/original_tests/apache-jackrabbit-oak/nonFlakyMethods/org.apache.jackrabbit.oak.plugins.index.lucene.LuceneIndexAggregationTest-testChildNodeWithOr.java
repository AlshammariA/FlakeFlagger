@Test public void testChildNodeWithOr() throws Exception {
  Tree file=root.getTree("/").addChild("myFile");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  Tree resource=file.addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty("jcr:lastModified",Calendar.getInstance());
  resource.setProperty("jcr:encoding","UTF-8");
  resource.setProperty("jcr:mimeType","text/plain");
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  resource.setProperty("jcr:title","title");
  resource.setProperty("jcr:description","description");
  root.commit();
  String matchContentSimple="//element(*, nt:file)[(jcr:contains(jcr:content, 'dog'))]";
  assertQuery(matchContentSimple,"xpath",ImmutableList.of("/myFile"));
  String matchContent=" //element(*, nt:file)[(jcr:contains(jcr:content, 'dog') or jcr:contains(jcr:content/@jcr:title, 'invalid') or jcr:contains(jcr:content/@jcr:description, 'invalid'))]";
  assertQuery(matchContent,"xpath",ImmutableList.of("/myFile"));
  String matchTitle=" //element(*, nt:file)[(jcr:contains(jcr:content, 'invalid') or jcr:contains(jcr:content/@jcr:title, 'title') or jcr:contains(jcr:content/@jcr:description, 'invalid'))]";
  assertQuery(matchTitle,"xpath",ImmutableList.of("/myFile"));
  String matchDesc=" //element(*, nt:file)[(jcr:contains(jcr:content, 'invalid') or jcr:contains(jcr:content/@jcr:title, 'invalid') or jcr:contains(jcr:content/@jcr:description, 'description'))]";
  assertQuery(matchDesc,"xpath",ImmutableList.of("/myFile"));
  String matchNone=" //element(*, nt:file)[(jcr:contains(jcr:content, 'invalid') or jcr:contains(jcr:content/@jcr:title, 'invalid') or jcr:contains(jcr:content/@jcr:description, 'invalid'))]";
  assertQuery(matchNone,"xpath",new ArrayList<String>());
}
