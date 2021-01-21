@Test public void getPropertyFromNode() throws RepositoryException {
  Node node=getNode("/foo");
  Property property=node.getProperty("stringProp");
  assertNotNull(property);
  assertEquals("stringProp",property.getName());
  assertEquals("/foo/stringProp",property.getPath());
  Value value=property.getValue();
  assertNotNull(value);
  assertEquals(PropertyType.STRING,value.getType());
  assertEquals("stringVal",value.getString());
  Property propertyAgain=getProperty("/foo/stringProp");
  assertTrue(property.isSame(propertyAgain));
}
