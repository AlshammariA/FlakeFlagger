@Test public void testFindAuthorizable2() throws Exception {
  for (  String relPath : unmappedPaths) {
    user.setProperty(relPath,nameValue);
  }
  superuser.save();
  session.refresh(false);
  Map<String,String> m=ImmutableMap.of("my:property","my:value","my:node/my:property2","my:value");
  for (  String relPath : m.keySet()) {
    String value=m.get(relPath);
    Iterator<Authorizable> result=getUserManager(session).findAuthorizables(relPath,value);
    assertTrue(result.hasNext());
    assertEquals(user.getID(),result.next().getID());
  }
}
