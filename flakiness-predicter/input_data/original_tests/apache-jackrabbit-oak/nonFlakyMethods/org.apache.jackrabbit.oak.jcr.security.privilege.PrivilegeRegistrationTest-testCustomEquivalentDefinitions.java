@Test public void testCustomEquivalentDefinitions() throws RepositoryException {
  privilegeManager.registerPrivilege("custom4",false,new String[0]);
  privilegeManager.registerPrivilege("custom5",false,new String[0]);
  privilegeManager.registerPrivilege("custom2",false,new String[]{"custom4","custom5"});
  List<String[]> equivalent=new ArrayList<String[]>();
  equivalent.add(new String[]{"custom4","custom5"});
  equivalent.add(new String[]{"custom2","custom4"});
  equivalent.add(new String[]{"custom2","custom5"});
  int cnt=6;
  for (  String[] aggrNames : equivalent) {
    try {
      String name="custom" + (cnt++);
      privilegeManager.registerPrivilege(name,false,aggrNames);
      fail("Equivalent '" + name + "' definitions must be detected.");
    }
 catch (    RepositoryException e) {
    }
  }
}
