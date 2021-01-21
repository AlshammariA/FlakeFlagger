/** 
 * Make sure repo-level acl is not imported below any other node than the root node.
 * @throws Exception
 */
public void testImportRepoACLAtTestNode() throws Exception {
  try {
    Node target=testRootNode.addNode("test");
    target.addMixin("rep:RepoAccessControllable");
    superuser.save();
    doImport(target.getPath(),XML_REPO_POLICY_TREE);
    fail("Importing repo policy to non-root node must fail");
  }
 catch (  AccessControlException e) {
  }
 finally {
    superuser.refresh(false);
  }
}
