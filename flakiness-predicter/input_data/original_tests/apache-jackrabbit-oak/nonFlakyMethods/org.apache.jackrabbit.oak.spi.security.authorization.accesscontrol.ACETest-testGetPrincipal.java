@Test public void testGetPrincipal() throws RepositoryException {
  ACE tmpl=createEntry(new String[]{PrivilegeConstants.JCR_READ},true);
  assertNotNull(tmpl.getPrincipal());
  assertEquals(testPrincipal.getName(),tmpl.getPrincipal().getName());
  assertSame(testPrincipal,tmpl.getPrincipal());
}
