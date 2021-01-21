@Test public void setPropertyAgain() throws RepositoryException {
  Session session=getAdminSession();
  Property p1=session.getProperty("/foo/stringProp");
  Property p2=p1.getParent().setProperty("stringProp","newValue");
  Property p3=session.getProperty("/foo/stringProp");
  assertEquals("newValue",p1.getString());
  assertEquals("newValue",p2.getString());
  assertEquals("newValue",p3.getString());
}
