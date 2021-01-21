@Test public void testGetProperty() throws Exception {
  for (  String relPath : unmappedPaths) {
    user.setProperty(relPath,nameValue);
    user.setProperty(relPath,new Value[]{nameValue});
  }
  superuser.save();
  session.refresh(false);
  for (  String relPath : mappedPaths) {
    Value[] values=authorizable.getProperty(relPath);
    assertNotNull(values);
    assertEquals(1,values.length);
    if (PropertyType.STRING == values[0].getType()) {
      assertEquals("value",values[0].getString());
    }
 else {
      assertEquals("my:value",values[0].getString());
    }
  }
}
