@Test public void loginWithCredentialsAttribute() throws RepositoryException {
  SimpleCredentials sc=getAdminCredentials();
  sc.setAttribute("attr","val");
  Session session=null;
  try {
    session=getRepository().login(sc,null);
    String[] attributeNames=session.getAttributeNames();
    assertEquals(1,attributeNames.length);
    assertEquals("attr",attributeNames[0]);
    assertEquals("val",session.getAttribute("attr"));
  }
  finally {
    if (session != null) {
      session.logout();
    }
  }
}
