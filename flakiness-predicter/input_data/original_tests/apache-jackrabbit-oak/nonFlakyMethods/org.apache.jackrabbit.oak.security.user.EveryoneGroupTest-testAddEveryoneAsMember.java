@Test public void testAddEveryoneAsMember() throws Exception {
  assertFalse(everyoneGroup.addMember(everyoneGroup));
}
