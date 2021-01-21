@Test public void addSmallBinaryProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  InputStream is=new NumberStream(1234);
  Binary bin=getAdminSession().getValueFactory().createBinary(is);
  addProperty(parentNode,"bigBinary",getAdminSession().getValueFactory().createValue(bin));
}
