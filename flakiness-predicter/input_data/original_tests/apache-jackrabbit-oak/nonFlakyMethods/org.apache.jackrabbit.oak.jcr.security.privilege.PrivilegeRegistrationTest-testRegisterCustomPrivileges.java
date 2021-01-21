@Test public void testRegisterCustomPrivileges() throws RepositoryException {
  Workspace workspace=session.getWorkspace();
  workspace.getNamespaceRegistry().registerNamespace("test","http://www.apache.org/jackrabbit/test");
  Map<String,String[]> newCustomPrivs=new HashMap<String,String[]>();
  newCustomPrivs.put("new",new String[0]);
  newCustomPrivs.put("test:new",new String[0]);
  for (  String name : newCustomPrivs.keySet()) {
    boolean isAbstract=true;
    String[] aggrNames=newCustomPrivs.get(name);
    Privilege registered=privilegeManager.registerPrivilege(name,isAbstract,aggrNames);
    Privilege privilege=privilegeManager.getPrivilege(name);
    assertNotNull(privilege);
    assertEquals(name,privilege.getName());
    assertTrue(privilege.isAbstract());
    assertEquals(0,privilege.getDeclaredAggregatePrivileges().length);
    assertContainsDeclared(privilegeManager.getPrivilege(PrivilegeConstants.JCR_ALL),name);
  }
  Map<String,String[]> newAggregates=new HashMap<String,String[]>();
  newAggregates.put("newA2",getAggregateNames("test:new","new"));
  newAggregates.put("newA1",getAggregateNames("new",PrivilegeConstants.JCR_READ));
  newAggregates.put("aggrBuiltIn",getAggregateNames(PrivilegeConstants.JCR_MODIFY_PROPERTIES,PrivilegeConstants.JCR_READ));
  for (  String name : newAggregates.keySet()) {
    boolean isAbstract=false;
    String[] aggrNames=newAggregates.get(name);
    privilegeManager.registerPrivilege(name,isAbstract,aggrNames);
    Privilege p=privilegeManager.getPrivilege(name);
    assertNotNull(p);
    assertEquals(name,p.getName());
    assertFalse(p.isAbstract());
    for (    String n : aggrNames) {
      assertContainsDeclared(p,n);
    }
    assertContainsDeclared(privilegeManager.getPrivilege(PrivilegeConstants.JCR_ALL),name);
  }
}
