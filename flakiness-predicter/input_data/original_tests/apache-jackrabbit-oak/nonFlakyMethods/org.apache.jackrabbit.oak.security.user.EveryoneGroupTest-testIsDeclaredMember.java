@Test public void testIsDeclaredMember() throws Exception {
  for (  Authorizable a : authorizables) {
    assertTrue(everyoneGroup.isDeclaredMember(a));
  }
}
