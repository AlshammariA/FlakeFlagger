@Test public void addPathProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"path",getAdminSession().getValueFactory().createValue("/jcr:foo/bar\"",PropertyType.PATH));
}
