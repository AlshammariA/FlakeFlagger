/** 
 * @since oak
 */
@Test public void testVersionablePath() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  VersionHistory vh=n.getVersionHistory();
  Property versionablePath=vh.getProperty(superuser.getWorkspace().getName());
  assertEquals(n.getPath(),versionablePath.getString());
}
