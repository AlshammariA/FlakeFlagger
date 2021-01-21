@Test public void testCreateGroup() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  Group gr=createGroup(p);
  createdGroups.add(gr);
  assertNotNull(gr.getID());
  assertEquals(p.getName(),gr.getPrincipal().getName());
  assertFalse("A new group must not have members.",gr.getMembers().hasNext());
}
