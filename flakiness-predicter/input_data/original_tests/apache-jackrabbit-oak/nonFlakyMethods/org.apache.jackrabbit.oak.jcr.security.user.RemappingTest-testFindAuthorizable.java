@Test public void testFindAuthorizable() throws Exception {
  user.setProperty("prop",superuser.getValueFactory().createValue(true));
  superuser.save();
  session.refresh(false);
  Map<String,String> m=ImmutableMap.of("prop","true","my:property","value","my:node/my:property2","value");
  for (  String relPath : m.keySet()) {
    String value=m.get(relPath);
    Iterator<Authorizable> result=getUserManager(session).findAuthorizables(relPath,value);
    assertTrue(result.hasNext());
    assertEquals(user.getID(),result.next().getID());
  }
}
