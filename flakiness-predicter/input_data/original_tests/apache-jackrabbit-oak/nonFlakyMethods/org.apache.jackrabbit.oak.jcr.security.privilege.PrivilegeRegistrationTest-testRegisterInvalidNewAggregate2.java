@Test public void testRegisterInvalidNewAggregate2() throws RepositoryException {
  Map<String,String[]> newCustomPrivs=new LinkedHashMap<String,String[]>();
  newCustomPrivs.put("new",new String[0]);
  newCustomPrivs.put("new2",new String[0]);
  newCustomPrivs.put("new3",getAggregateNames("new","new2"));
  for (  String name : newCustomPrivs.keySet()) {
    boolean isAbstract=true;
    String[] aggrNames=newCustomPrivs.get(name);
    privilegeManager.registerPrivilege(name,isAbstract,aggrNames);
  }
  Map<String,String[]> newAggregates=new LinkedHashMap<String,String[]>();
  newAggregates.put("newA2",getAggregateNames("new"));
  newAggregates.put("newA3",getAggregateNames("new2"));
  for (  String name : newAggregates.keySet()) {
    boolean isAbstract=false;
    String[] aggrNames=newAggregates.get(name);
    try {
      privilegeManager.registerPrivilege(name,isAbstract,aggrNames);
      fail("Invalid aggregation in definition '" + name.toString() + "' : Exception expected");
    }
 catch (    RepositoryException e) {
    }
  }
}
