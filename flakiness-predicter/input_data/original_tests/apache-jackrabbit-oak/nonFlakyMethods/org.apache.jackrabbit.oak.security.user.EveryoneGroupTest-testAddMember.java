@Test public void testAddMember() throws Exception {
  for (  Authorizable a : authorizables) {
    assertFalse(everyoneGroup.addMember(a));
  }
}
