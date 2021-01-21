@Test public void testCreateGroupWithAbsolutePath2() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String groupRoot=UserConstants.DEFAULT_GROUP_PATH;
  String path=groupRoot + "/any/path/to/the/new/group";
  Group gr=createGroup(p,path);
  createdGroups.add(gr);
  assertTrue(gr.getPath().startsWith(path));
}
