@Test public void testGetAuthorizableByPath() throws Exception {
  assertNotNull(getUserManager(session).getAuthorizableByPath(authorizable.getPath()));
}
