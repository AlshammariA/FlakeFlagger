@Test public void testRemoveEveryoneFromMembers() throws Exception {
  assertFalse(everyoneGroup.removeMember(everyoneGroup));
}
