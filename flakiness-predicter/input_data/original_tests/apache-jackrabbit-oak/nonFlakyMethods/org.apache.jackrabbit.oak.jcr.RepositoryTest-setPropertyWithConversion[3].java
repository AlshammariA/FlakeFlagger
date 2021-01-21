@Test public void setPropertyWithConversion() throws RepositoryException {
  Node n=getNode(TEST_PATH);
  Node file=n.addNode("file","nt:file");
  Node content=file.addNode("jcr:content","nt:resource");
  long value=System.currentTimeMillis();
  Property property=content.setProperty("jcr:lastModified",value);
  assertEquals(value,property.getDate().getTimeInMillis());
  content.setProperty("jcr:data",new ByteArrayInputStream("foo".getBytes()));
  content.setProperty("jcr:mimeType","text/plain");
  n.getSession().save();
}
