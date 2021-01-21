@Test public void testChildNodeWithOrComposite() throws Exception {
  Tree folder=root.getTree("/").addChild("myFolder");
  folder.setProperty(JCR_PRIMARYTYPE,NT_FOLDER,Type.NAME);
  Tree file=folder.addChild("myFile");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  file.setProperty("jcr:title","title");
  file.setProperty("jcr:description","description");
  Tree resource=file.addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty("jcr:lastModified",Calendar.getInstance());
  resource.setProperty("jcr:encoding","UTF-8");
  resource.setProperty("jcr:mimeType","text/plain");
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  root.commit();
  String matchContentSimple="//element(*, nt:folder)[(jcr:contains(myFile, 'dog'))]";
  assertQuery(matchContentSimple,"xpath",ImmutableList.of("/myFolder"));
  String matchContent=" //element(*, nt:folder)[(jcr:contains(myFile, 'dog') or jcr:contains(myFile/@jcr:title, 'invalid') or jcr:contains(myFile/@jcr:description, 'invalid'))]";
  assertQuery(matchContent,"xpath",ImmutableList.of("/myFolder"));
  String matchTitle=" //element(*, nt:folder)[(jcr:contains(myFile, 'invalid') or jcr:contains(myFile/@jcr:title, 'title') or jcr:contains(myFile/@jcr:description, 'invalid'))]";
  assertQuery(matchTitle,"xpath",ImmutableList.of("/myFolder"));
  String matchDesc=" //element(*, nt:folder)[(jcr:contains(myFile, 'invalid') or jcr:contains(myFile/@jcr:title, 'invalid') or jcr:contains(myFile/@jcr:description, 'description'))]";
  assertQuery(matchDesc,"xpath",ImmutableList.of("/myFolder"));
  String matchNone=" //element(*, nt:folder)[(jcr:contains(myFile, 'invalid') or jcr:contains(myFile/@jcr:title, 'invalid') or jcr:contains(myFile/@jcr:description, 'invalid'))]";
  assertQuery(matchNone,"xpath",new ArrayList<String>());
  String matchOnlyTitleOr=" //element(*, nt:folder)[(jcr:contains(myFile/@jcr:title, 'title') or jcr:contains(myFile/@jcr:title, 'unknown') )]";
  assertQuery(matchOnlyTitleOr,"xpath",ImmutableList.of("/myFolder"));
}
