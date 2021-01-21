@Test public void getReferences() throws RepositoryException {
  Session session=getAdminSession();
  Node referee=getNode("/foo");
  referee.addMixin("mix:referenceable");
  getNode(TEST_PATH).setProperty("reference",session.getValueFactory().createValue(referee));
  session.save();
  PropertyIterator refs=referee.getReferences();
  assertTrue(refs.hasNext());
  Property p=refs.nextProperty();
  assertEquals("reference",p.getName());
  assertFalse(refs.hasNext());
}
