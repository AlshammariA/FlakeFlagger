@Test public void testEveryoneDeclaredMemberOf() throws Exception {
  Iterator<Group> groups=everyoneGroup.declaredMemberOf();
  assertFalse(groups.hasNext());
}
