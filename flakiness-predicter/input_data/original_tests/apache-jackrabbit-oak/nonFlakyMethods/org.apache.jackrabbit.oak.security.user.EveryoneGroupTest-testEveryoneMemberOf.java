@Test public void testEveryoneMemberOf() throws Exception {
  Iterator<Group> groups=everyoneGroup.memberOf();
  assertFalse(groups.hasNext());
}
