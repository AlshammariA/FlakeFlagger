@Test public void getNamedWeakReferences() throws RepositoryException {
  Session session=getAdminSession();
  Node referee=getNode("/foo");
  referee.addMixin("mix:referenceable");
  Value value=session.getValueFactory().createValue(referee,true);
  getNode(TEST_PATH).setProperty("weak-reference1",value);
  getNode("/bar").setProperty("weak-reference2",value);
  session.save();
  PropertyIterator refs=referee.getWeakReferences("weak-reference1");
  assertTrue(refs.hasNext());
  Property p=refs.nextProperty();
  assertEquals("weak-reference1",p.getName());
  assertFalse(refs.hasNext());
}
