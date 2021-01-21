@Test public void addBigBinaryProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  InputStream is=new NumberStream(123456);
  Binary bin=getAdminSession().getValueFactory().createBinary(is);
  addProperty(parentNode,"bigBinary",getAdminSession().getValueFactory().createValue(bin));
}
