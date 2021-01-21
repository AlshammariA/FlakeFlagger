@Test public void lowerCase() throws RepositoryException {
  PropertyValue p=f.propertyValue("selectorName","propertyName");
  Length length=f.length(p);
  LowerCase l=f.lowerCase(length);
  assertEquals(length,l.getOperand());
  assertEquals("LOWER(LENGTH([selectorName].[propertyName]))",l.toString());
}
