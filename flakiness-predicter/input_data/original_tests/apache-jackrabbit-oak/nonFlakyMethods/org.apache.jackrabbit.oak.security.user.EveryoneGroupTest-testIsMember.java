@Test public void testIsMember() throws Exception {
  for (  Authorizable a : authorizables) {
    assertTrue(everyoneGroup.isMember(a));
  }
}
