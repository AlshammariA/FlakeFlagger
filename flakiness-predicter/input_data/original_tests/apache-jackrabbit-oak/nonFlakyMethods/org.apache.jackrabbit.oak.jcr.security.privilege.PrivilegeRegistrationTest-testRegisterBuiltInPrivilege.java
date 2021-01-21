@Test public void testRegisterBuiltInPrivilege() throws RepositoryException {
  Map<String,String[]> builtIns=new HashMap<String,String[]>();
  builtIns.put(PrivilegeConstants.JCR_READ,new String[0]);
  builtIns.put(PrivilegeConstants.JCR_LIFECYCLE_MANAGEMENT,new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES});
  builtIns.put(PrivilegeConstants.REP_WRITE,new String[0]);
  builtIns.put(PrivilegeConstants.JCR_ALL,new String[0]);
  for (  String builtInName : builtIns.keySet()) {
    try {
      privilegeManager.registerPrivilege(builtInName,false,builtIns.get(builtInName));
      fail("Privilege name " + builtInName + " already in use -> Exception expected");
    }
 catch (    RepositoryException e) {
    }
  }
  for (  String builtInName : builtIns.keySet()) {
    try {
      privilegeManager.registerPrivilege(builtInName,true,builtIns.get(builtInName));
      fail("Privilege name " + builtInName + " already in use -> Exception expected");
    }
 catch (    RepositoryException e) {
    }
  }
}
