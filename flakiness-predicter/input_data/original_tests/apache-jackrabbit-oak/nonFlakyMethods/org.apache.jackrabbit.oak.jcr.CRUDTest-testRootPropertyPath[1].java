@Test public void testRootPropertyPath() throws RepositoryException {
  Property property=getAdminSession().getRootNode().getProperty("jcr:primaryType");
  assertEquals("/jcr:primaryType",property.getPath());
}
