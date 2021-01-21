@Test public void upperCase() throws RepositoryException {
  PropertyValue p=f.propertyValue("selectorName","propertyName");
  Length length=f.length(p);
  UpperCase u=f.upperCase(length);
  assertEquals(length,u.getOperand());
  assertEquals("UPPER(LENGTH([selectorName].[propertyName]))",u.toString());
}
