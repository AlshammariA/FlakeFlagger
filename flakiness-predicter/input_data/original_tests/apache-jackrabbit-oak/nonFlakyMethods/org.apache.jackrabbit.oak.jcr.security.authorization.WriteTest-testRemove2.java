@Test public void testRemove2() throws Exception {
  Privilege[] rmChildNodes=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  allow(path,rmChildNodes);
  assertFalse(testSession.hasPermission(path,javax.jcr.Session.ACTION_REMOVE));
  assertFalse(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_REMOVE));
}
