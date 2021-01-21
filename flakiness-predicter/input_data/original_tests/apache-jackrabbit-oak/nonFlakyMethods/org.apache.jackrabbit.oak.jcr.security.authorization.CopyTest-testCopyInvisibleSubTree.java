@Test public void testCopyInvisibleSubTree() throws Exception {
  deny(childNPath,privilegesFromName(Privilege.JCR_READ));
  allow(targetPath,privilegesFromName(Privilege.JCR_ALL));
  assertFalse(testSession.nodeExists(childNPath));
  testSession.getWorkspace().copy(path,destPath);
  Node copiedNode=testSession.getNode(destPath);
  String childName=Text.getName(childNPath);
  assertFalse(copiedNode.hasNode(childName));
  assertTrue(copiedNode.hasNode(Text.getName(childNPath2)));
  superuser.refresh(false);
  assertFalse(superuser.nodeExists(destPath + '/' + childName));
}
