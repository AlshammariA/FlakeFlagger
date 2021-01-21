@Test public void addURIProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"uri",getAdminSession().getValueFactory().createValue("http://www.day.com/",PropertyType.URI));
}
