@Test public void testSessionGetProperty() throws Exception {
  Property pp=superuser.getProperty(p.getPath());
  assertTrue(p.isSame(pp));
}
