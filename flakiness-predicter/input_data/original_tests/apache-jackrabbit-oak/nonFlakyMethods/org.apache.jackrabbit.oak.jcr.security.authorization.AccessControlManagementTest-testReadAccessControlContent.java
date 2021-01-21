@Test public void testReadAccessControlContent() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_READ_ACCESS_CONTROL));
  deny(path,privilegesFromName(Privilege.JCR_READ));
  assertTrue(testSession.nodeExists(path + "/rep:policy"));
  assertTrue(testSession.propertyExists(path + "/rep:policy/jcr:primaryType"));
  assertFalse(testSession.nodeExists(path));
  assertFalse(testSession.propertyExists(path + "/jcr:primaryType"));
}
