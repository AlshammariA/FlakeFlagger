@Test public void namePropertyFromNameValue() throws RepositoryException {
  PropertyState nameProperty=PropertyStates.createProperty("name","oak-prefix:value",PropertyType.NAME);
  Value nameValue=ValueFactoryImpl.createValue(nameProperty,namePathMapper);
  PropertyState namePropertyFromValue=PropertyStates.createProperty("name",nameValue);
  assertEquals(nameProperty,namePropertyFromValue);
}
