@Test public void pathPropertyFromPathValue() throws RepositoryException {
  PropertyState pathProperty=PropertyStates.createProperty("path","oak-prefix:a/oak-prefix:b",PropertyType.PATH);
  Value nameValue=ValueFactoryImpl.createValue(pathProperty,namePathMapper);
  PropertyState namePropertyFromValue=PropertyStates.createProperty("path",nameValue);
  assertEquals(pathProperty,namePropertyFromValue);
}
