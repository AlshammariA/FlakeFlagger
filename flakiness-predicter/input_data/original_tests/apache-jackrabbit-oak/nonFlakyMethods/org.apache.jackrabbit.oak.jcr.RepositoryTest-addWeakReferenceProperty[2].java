@Test public void addWeakReferenceProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  Node referee=getAdminSession().getNode("/foo");
  referee.addMixin("mix:referenceable");
  getAdminSession().save();
  addProperty(parentNode,"weak reference",getAdminSession().getValueFactory().createValue(referee,true));
}
