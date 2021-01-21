@Test public void getWeakReferences() throws RepositoryException {
  Session session=getAdminSession();
  Node referee=getNode("/foo");
  referee.addMixin("mix:referenceable");
  getNode(TEST_PATH).setProperty("weak-reference",session.getValueFactory().createValue(referee,true));
  session.save();
  PropertyIterator refs=referee.getWeakReferences();
  assertTrue(refs.hasNext());
  Property p=refs.nextProperty();
  assertEquals("weak-reference",p.getName());
  assertFalse(refs.hasNext());
}
