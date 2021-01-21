@Test public void length() throws RepositoryException {
  PropertyValue p=f.propertyValue("selectorName","propertyName");
  Length l=f.length(p);
  assertEquals(p,l.getPropertyValue());
  assertEquals("LENGTH([selectorName].[propertyName])",l.toString());
}
