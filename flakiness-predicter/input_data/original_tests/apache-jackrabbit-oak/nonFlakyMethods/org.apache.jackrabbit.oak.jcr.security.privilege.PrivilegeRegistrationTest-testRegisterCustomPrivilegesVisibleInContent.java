/** 
 * @since oak
 */
@Test public void testRegisterCustomPrivilegesVisibleInContent() throws RepositoryException {
  Workspace workspace=session.getWorkspace();
  workspace.getNamespaceRegistry().registerNamespace("test","http://www.apache.org/jackrabbit/test");
  Map<String,String[]> newCustomPrivs=new HashMap<String,String[]>();
  newCustomPrivs.put("new",new String[0]);
  newCustomPrivs.put("test:new",new String[0]);
  for (  String name : newCustomPrivs.keySet()) {
    boolean isAbstract=true;
    String[] aggrNames=newCustomPrivs.get(name);
    Privilege registered=privilegeManager.registerPrivilege(name,isAbstract,aggrNames);
    Node privilegeRoot=session.getNode(PrivilegeConstants.PRIVILEGES_PATH);
    assertTrue(privilegeRoot.hasNode(name));
    Node privNode=privilegeRoot.getNode(name);
    assertTrue(privNode.getProperty(PrivilegeConstants.REP_IS_ABSTRACT).getBoolean());
    assertFalse(privNode.hasProperty(PrivilegeConstants.REP_AGGREGATES));
  }
}
