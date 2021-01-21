/** 
 * simple index aggregation from jcr:content to nt:file
 */
@Test public void testNtFileAggregate() throws Exception {
  String sqlBase="SELECT * FROM [nt:file] as f WHERE";
  String sqlCat=sqlBase + " CONTAINS (f.*, 'cat')";
  String sqlDog=sqlBase + " CONTAINS (f.*, 'dog')";
  Tree file=root.getTree("/").addChild("myFile");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE,Type.NAME);
  Tree resource=file.addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty("jcr:lastModified",Calendar.getInstance());
  resource.setProperty("jcr:encoding","UTF-8");
  resource.setProperty("jcr:mimeType","text/plain");
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy dog."));
  root.commit();
  assertQuery(sqlDog,ImmutableList.of("/myFile"));
  root.getTree("/").getChild("myFile").getChild(JCR_CONTENT).setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy cat."));
  root.commit();
  assertQuery(sqlDog,new ArrayList<String>());
  assertQuery(sqlCat,ImmutableList.of("/myFile"));
  root.getTree("/").getChild("myFile").getChild(JCR_CONTENT).remove();
  Tree unstrContent=root.getTree("/").getChild("myFile").addChild(JCR_CONTENT);
  unstrContent.setProperty(JCR_PRIMARYTYPE,JcrConstants.NT_UNSTRUCTURED,Type.NAME);
  Tree foo=unstrContent.addChild("foo");
  foo.setProperty(JCR_PRIMARYTYPE,JcrConstants.NT_UNSTRUCTURED,Type.NAME);
  foo.setProperty("text","the quick brown fox jumps over the lazy dog.");
  root.commit();
  assertQuery(sqlDog,ImmutableList.of("/myFile"));
  assertQuery(sqlCat,new ArrayList<String>());
  root.getTree("/").getChild("myFile").getChild(JCR_CONTENT).getChild("foo").remove();
  root.commit();
  assertQuery(sqlDog,new ArrayList<String>());
  assertQuery(sqlCat,new ArrayList<String>());
  root.getTree("/").getChild("myFile").getChild(JCR_CONTENT).remove();
  resource=root.getTree("/").getChild("myFile").addChild(JCR_CONTENT);
  resource.setProperty(JCR_PRIMARYTYPE,"nt:resource",Type.NAME);
  resource.setProperty("jcr:lastModified",Calendar.getInstance());
  resource.setProperty("jcr:encoding","UTF-8");
  resource.setProperty("jcr:mimeType","text/plain");
  resource.setProperty(binaryProperty(JCR_DATA,"the quick brown fox jumps over the lazy cat."));
  root.commit();
  assertQuery(sqlDog,new ArrayList<String>());
  assertQuery(sqlCat,ImmutableList.of("/myFile"));
}
