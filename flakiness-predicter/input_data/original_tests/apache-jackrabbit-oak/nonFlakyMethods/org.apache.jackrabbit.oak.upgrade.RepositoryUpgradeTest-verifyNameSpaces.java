@Test public void verifyNameSpaces() throws Exception {
  Session session=createAdminSession();
  try {
    assertEquals("http://www.example.org/",session.getNamespaceURI("test"));
  }
  finally {
    session.logout();
  }
}
