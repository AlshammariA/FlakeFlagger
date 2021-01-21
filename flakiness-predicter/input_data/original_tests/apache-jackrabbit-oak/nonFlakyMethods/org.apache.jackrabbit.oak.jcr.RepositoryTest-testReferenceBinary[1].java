@Test public void testReferenceBinary() throws RepositoryException {
  ValueFactory valueFactory=getAdminSession().getValueFactory();
  Binary binary=valueFactory.createBinary(new RandomInputStream(1,256 * 1024));
  String reference=binary instanceof ReferenceBinary ? ((ReferenceBinary)binary).getReference() : null;
  assumeTrue(reference != null);
  Session session=createAdminSession();
  try {
    valueFactory=session.getValueFactory();
    assertEquals(binary,valueFactory.createValue(new SimpleReferenceBinary(reference)).getBinary());
  }
  finally {
    session.logout();
  }
}
